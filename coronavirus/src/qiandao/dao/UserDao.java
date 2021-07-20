package qiandao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import qiandao.bean.Student;
import qiandao.util.DbUtil;

public class UserDao {
	// 判断用户在数据库中是否存在，存在返回true，不存在返回false
	public boolean userIsExist(String ybStudentid) {
		Connection conn = DbUtil.getConnection();
		String sql = "select * from stuinfo where ybStudentid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(7, ybStudentid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// 数据库中存在此用户
				return true;
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	// 用户登录，登录成功返回一个含值User对象,如果登录失败返回一个User空对象
	public Student login(String ybStudentid, String ybEnteryear) {
		System.out.println(ybStudentid);
		System.out.println(ybEnteryear);
		Connection conn = DbUtil.getConnection();
		Student student = new Student();// 实例化一个student对象
		String sql = "select * from stuinfo where yb_studentid = ? and yb_enteryear = ?";
		try {
			// 获取PreparedStatement对象
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			// 对sql参数进行动态赋值
			ps.setString(1, ybStudentid);
			ps.setString(2, ybEnteryear);
			ResultSet rs = ps.executeQuery();// 查询结果集
			// System.out.println(rs);
			// 判断数据库中是否存在该用户
			if (rs.next()) {
				// 给用户对象赋值
				student.setYbStudentid(rs.getString("yb_studentid"));
				student.setYbEnteryear(rs.getString("yb_enteryear"));
				student.setYbCollegename(rs.getString("yb_collegename"));
				student.setYbRealname(rs.getString("yb_realname"));
				student.setYbClassname(rs.getString("yb_classname"));
				student.setYbUserid(rs.getString("yb_userid"));
				student.setId(rs.getInt("id"));
				System.out.println(student.toString());
			} else {
				System.out.println("nothing");
			}
			// 释放资源
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		Student s = dao.login("2019232010202", "2019");
		System.out.println(s.toString());
	}
}
