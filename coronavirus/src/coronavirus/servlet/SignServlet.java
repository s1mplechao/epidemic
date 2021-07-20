package coronavirus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import coronavirus.bean.Sign;
import coronavirus.dao.SignDao;
import coronavirus.dao.SignDaoImpl;

@WebServlet("/signyq")
public class SignServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理中文乱码
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action.equals("sign")) {
            // 非湖北学生签到
            this.sign(request, response);
        } else if (action.equals("signhb")) {
            // 湖北学生签到
            this.signhb(request, response);
        } else if (action.equals("classname")) {
            // 是否有班级
            this.classname(request, response);
        }
    }

    private void sign(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取用户基本信息
        HttpSession session = request.getSession();

        String ybUserid = session.getAttribute("userid").toString();
        String ybRealname = session.getAttribute("yb_realname").toString();
        String ybCollegename = session.getAttribute("yb_collegename").toString();
        String ybClassname = session.getAttribute("yb_classname").toString();
        if (ybClassname.equals("") || ybClassname == null) {
            ybClassname = request.getParameter("ybClassname");
        }
        String ybStudentid = session.getAttribute("yb_studentid").toString();

        // 通过response对象获得输出流。
        PrintWriter out = response.getWriter();
        // 获取请求参数
        String wenjuan = request.getParameter("wenjuan");
        String position = request.getParameter("position");
        SignDao signDao = new SignDaoImpl();
        Sign sign = signDao.getSign(ybUserid);
        if (sign.getId() == null) {
            sign.setYbUserid(ybUserid);
            sign.setYbRealname(ybRealname);
            sign.setYbStudentid(ybStudentid);
            sign.setYbCollegename(ybCollegename);
            sign.setYbClassname(ybClassname);
            sign.setPosition(position);
            sign.setWenjuan(wenjuan);
            sign.setSignDate(new Date());
            System.out.println(sign.toString());
            // 保存签到信息
            int i = signDao.saveSign(sign);
            if (i == 1) {
                System.out.println(ybCollegename + " " + ybRealname + " 签到成功");
                out.print("1");
            } else {
                System.out.println(ybCollegename + " " + ybRealname + " 签到失败");
                out.print("0");
            }
        } else {
            sign.setId(null);
            sign.setYbUserid(ybUserid);
            sign.setYbRealname(ybRealname);
            sign.setYbStudentid(ybStudentid);
            sign.setYbCollegename(ybCollegename);
            sign.setYbClassname(ybClassname);
            sign.setPosition(position);
            sign.setWenjuan(wenjuan);
            sign.setSignDate(new Date());
            System.out.println(sign.toString());
            int i = signDao.updateSign(sign);
            if (i == 1) {
                System.out.println(ybCollegename + " " + ybRealname + " 更新签到信息成功");
                out.print("2");
            } else {
                System.out.println(ybCollegename + " " + ybRealname + " 更新签到信息失败");
                out.print("-1");
            }

        }
    }

    private void signhb(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取用户基本信息
        HttpSession session = request.getSession();
        String ybUserid = session.getAttribute("userid").toString();
        String ybRealname = session.getAttribute("yb_realname").toString();
        String ybCollegename = session.getAttribute("yb_collegename").toString();
        String ybClassname = session.getAttribute("yb_classname").toString();
        if (ybClassname.equals("") || ybClassname == null) {
            ybClassname = request.getParameter("ybClassname");
        }
        String ybStudentid = session.getAttribute("yb_studentid").toString();

        // 通过response对象获得输出流。
        PrintWriter out = response.getWriter();
        // 获取请求参数
        String wenjuan = request.getParameter("wenjuan");
        String position = request.getParameter("position");
        SignDao signDao = new SignDaoImpl();
        Sign sign = signDao.getSign(ybUserid);
        if (sign.getId() == null) {
            sign.setYbUserid(ybUserid);
            sign.setYbRealname(ybRealname);
            sign.setYbStudentid(ybStudentid);
            sign.setYbCollegename(ybCollegename);
            sign.setYbClassname(ybClassname);
            sign.setPosition(position);
            sign.setWenjuan(wenjuan);
            sign.setSignDate(new Date());
            System.out.println(sign.toString());
            // 保存签到信息
            int i = signDao.saveSignHB(sign);
            if (i == 1) {
                System.out.println(ybCollegename + " " + ybRealname + " 签到成功");
                out.print("1");
            } else {
                System.out.println(ybCollegename + " " + ybRealname + " 签到失败");
                out.print("0");
            }
        } else {
            sign.setId(null);
            sign.setYbUserid(ybUserid);
            sign.setYbRealname(ybRealname);
            sign.setYbStudentid(ybStudentid);
            sign.setYbCollegename(ybCollegename);
            sign.setYbClassname(ybClassname);
            sign.setPosition(position);
            sign.setWenjuan(wenjuan);
            sign.setSignDate(new Date());
            System.out.println(sign.toString());
            int i = signDao.updateSign(sign);
            if (i == 1) {
                System.out.println(ybCollegename + " " + ybRealname + " 更新签到信息成功");
                out.print("2");
            } else {
                System.out.println(ybCollegename + " " + ybRealname + " 更新签到信息失败");
                out.print("-1");
            }

        }
    }

    public void classname(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String classname = session.getAttribute("yb_classname").toString();
        if (classname.equals("") || classname == null) {
            // 未加入班级
            out.print("0");
        } else {
            // 已加入班级
            out.print("1");
        }
    }
}
