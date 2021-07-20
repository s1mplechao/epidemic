package qiandao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qiandao.bean.Student;
import qiandao.dao.UserDao;

@WebServlet("/LoginServlet")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ybstudentid = request.getParameter("account");
		String ybenteryear = request.getParameter("password");

		if (ybstudentid.equals("2019232010202") && ybenteryear.equals("2019")) {
			UserDao userDao = new UserDao();
			Student student = userDao.login(ybstudentid, ybenteryear);
			ybstudentid = student.getYbStudentid();
			ybenteryear = student.getYbEnteryear();
			request.getSession().setAttribute("userid", student.getYbUserid());
			request.getSession().setAttribute("yb_realname", student.getYbRealname());
			request.getSession().setAttribute("yb_collegename", student.getYbCollegename());
			request.getSession().setAttribute("yb_classname", student.getYbClassname());
			request.getSession().setAttribute("yb_studentid", student.getYbStudentid());
			request.getRequestDispatcher("coronavirus?action=index").forward(request, response);
		} else {
			request.setAttribute("info", " 错误:用户名或密码错误！");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

}
