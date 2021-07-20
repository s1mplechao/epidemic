package coronavirus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coronavirus.bean.Msg;
import coronavirus.dao.MessageDao;
import coronavirus.dao.MessageDaoImpl;
import coronavirus.dao.SignDao;
import coronavirus.dao.SignDaoImpl;

@WebServlet("/coronavirus")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 湖北学生
	private static final String[] HUBEIS = { "23954132", "22725908", "18328110", "21241678", "24729548", "22726954",
			"28360316", "17427064", "19190030", "28444246", "17420064", "22664968", "25692082", "32875176", "28658954",
			"36587736", "25732408", "25859788", "25857416", "36667096", "22687488", "18379126", "30076984", "28600602",
			"28736216", "25723354", "25732434", "25912168", "25856978", "25856814", "19310768", "18328148", "18600524",
			"28752188", "29706018", "25440500", "25693616", "25856198", "25869628", "25856940", "18894460", "28673604",
			"29854104", "28418482", "25898436", "17290966", "28566330", "25344442", "25345442", "25320958", "28593926",
			"25370792", "30235452", "20075414", "20281944", "18338000", "25370674", "25344554", "18809310", "24775686",
			"18358932", "28810998", "18336248", "28614650", "19848196", "17067204", "29240678", "31698916", "25916968",
			"18378720", "22881076", "17139722", "29344860", "19412174" };

	public MessageServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("index")) {
			// 进入首页
			this.index(request, response);
		} else if (action.equals("details")) {
			// 通知内容页
			this.details(request, response);
		} else if (action.equals("where")) {
			// 是否湖北学生
			this.where(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户基本信息
		HttpSession session = request.getSession();

		String ybUserid = session.getAttribute("userid").toString();
		String ybCollegename = session.getAttribute("yb_collegename").toString();
		String ybClassname = session.getAttribute("yb_classname").toString();
		String ybStudentid = session.getAttribute("yb_studentid").toString();

		MessageDao messageDao = new MessageDaoImpl();
		SignDao signDao = new SignDaoImpl();
		// 查询所有通知
		List<Msg> msgs = messageDao.listMsgs(ybUserid);
		// 今日是否已签到
		int isSign = 0;
		if (signDao.getSign(ybUserid).getId() != null) {
			isSign = 1;
		}
		request.setAttribute("msgs", msgs);
		request.setAttribute("ybCollegename", ybCollegename);
		request.setAttribute("ybStudentid", ybStudentid);
		request.setAttribute("ybClassname", ybClassname);
		request.setAttribute("isSign", isSign);
		// 页面跳转
		request.getRequestDispatcher("coronavirus/index.jsp").forward(request, response);
	}

	private void details(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户基本信息
		HttpSession session = request.getSession();

		String ybUserid = session.getAttribute("userid").toString();
		String ybCollegename = session.getAttribute("yb_collegename").toString();

		// 获取请求id
		int id = Integer.parseInt(request.getParameter("id"));
		MessageDao messageDao = new MessageDaoImpl();
		// 查询通知信息
		Msg msg = messageDao.getMsg(ybUserid, id);

		request.setAttribute("msg", msg);
		request.setAttribute("ybCollegename", ybCollegename);
		request.getRequestDispatcher("coronavirus/details.jsp").forward(request, response);
	}

	private void where(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取用户基本信息
		HttpSession session = request.getSession();
		String ybUserid = session.getAttribute("userid").toString();
		// 判断是否湖北学生 0 不是 1 是
		int isHubei = 0;
		for (String hubei : HUBEIS) {
			if (hubei.equals(ybUserid)) {
				isHubei = 1;
				break;
			}
		}

		PrintWriter out = response.getWriter();
		if (isHubei == 0) {
			out.print("0");
		} else {
			out.print("1");
		}
	}
}
