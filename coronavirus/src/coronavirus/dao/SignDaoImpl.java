package coronavirus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import coronavirus.bean.Sign;
import coronavirus.util.DbUtil;

public class SignDaoImpl implements SignDao {
    /**
     * 保存签到信息
     * 
     * @param sign 签到信息
     * @return 是否成功
     */
    @Override
    public int saveSign(Sign sign) {
        int i = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into qiandao (yb_userid, yb_realname, yb_collegename, yb_classname, yb_studentid, wenjuan, position, sign_date) values (?,?,?,?,?,?,?,?);";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sign.getYbUserid());
            ps.setString(2, sign.getYbRealname());
            ps.setString(3, sign.getYbCollegename());
            ps.setString(4, sign.getYbClassname());
            ps.setString(5, sign.getYbStudentid());
            ps.setString(6, sign.getWenjuan());
            ps.setString(7, sign.getPosition());
            ps.setString(8, sdf.format(sign.getSignDate()));
            i = ps.executeUpdate();
            DbUtil.close(con, ps, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 保存签到信息
     * 
     * @param sign 签到信息
     * @return 是否成功
     */
    @Override
    public int saveSignHB(Sign sign) {
        int i = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "insert into qiandao (yb_userid, yb_realname, yb_collegename, yb_classname, yb_studentid, wenjuan, position, sign_date, is_hb) values (?,?,?,?,?,?,?,?,1);";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sign.getYbUserid());
            ps.setString(2, sign.getYbRealname());
            ps.setString(3, sign.getYbCollegename());
            ps.setString(4, sign.getYbClassname());
            ps.setString(5, sign.getYbStudentid());
            ps.setString(6, sign.getWenjuan());
            ps.setString(7, sign.getPosition());
            ps.setString(8, sdf.format(sign.getSignDate()));
            i = ps.executeUpdate();
            DbUtil.close(con, ps, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 更新签到信息
     */
    @Override
    public int updateSign(Sign sign) {
        int i = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "update qiandao set yb_userid=?, yb_realname=?, yb_collegename=?, yb_classname=?, yb_studentid=?, wenjuan=?, position=?, sign_date=? where yb_userid = ?";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sign.getYbUserid());
            ps.setString(2, sign.getYbRealname());
            ps.setString(3, sign.getYbCollegename());
            ps.setString(4, sign.getYbClassname());
            ps.setString(5, sign.getYbStudentid());
            ps.setString(6, sign.getWenjuan());
            ps.setString(7, sign.getPosition());
            ps.setString(8, sdf.format(sign.getSignDate()));
            ps.setString(9, sign.getYbUserid());
            i = ps.executeUpdate();
            DbUtil.close(con, ps, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询签到信息
     * 
     * @param ybUserid
     * @return
     */
    @Override
    public Sign getSign(String ybUserid) {
        Sign sign = new Sign();
        String sql = "SELECT * FROM qiandao WHERE yb_userid = ? AND (sign_date) > (CURDATE()) limit 1";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ybUserid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sign.setId(rs.getInt("id"));
                sign.setYbUserid(rs.getString("yb_userid"));
                sign.setYbRealname(rs.getString("yb_realname"));
                sign.setYbStudentid(rs.getString("yb_studentid"));
                sign.setYbCollegename(rs.getString("yb_collegename"));
                sign.setYbClassname(rs.getString("yb_classname"));
                sign.setPosition(rs.getString("position"));
                sign.setWenjuan(rs.getString("wenjuan"));
                sign.setSignDate(rs.getDate("sign_date"));
            }
            DbUtil.close(con, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }
}
