package coronavirus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import coronavirus.bean.Message;
import coronavirus.bean.Msg;
import coronavirus.util.DbUtil;

public class MessageDaoImpl implements MessageDao {
    /**
     * 获取所有通知
     * 
     * @return 通知List
     */
    @Override
    public List<Msg> listMsgs(String ybUserid) {
        List<Msg> msgs = new ArrayList<Msg>();
        String sql = "SELECT * FROM message;";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Msg msg = new Msg();
                msg.setId(rs.getInt("id"));
                msg.setTitle(rs.getString("title"));
                msg.setDate(rs.getDate("date"));
                msg.setContent(rs.getString("content"));
                msgs.add(msg);
            }
            DbUtil.close(con, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msgs;
    }

    /**
     * 获取某个通知
     * 
     * @param id 通知id
     * @return 通知
     */
    @Override
    public Msg getMsg(String ybUserid, int id) {
        String sql = "SELECT* FROM message where message.id = ?;";
        Msg msg = new Msg();
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                msg.setId(rs.getInt("id"));
                msg.setTitle(rs.getString("title"));
                msg.setDate(rs.getDate("date"));
                msg.setContent(rs.getString("content"));
                System.out.println(msg.toString());
            }
            DbUtil.close(con, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 统计学院阅读通知数
     * 
     * @param ybCollegename 学院
     * @param id            通知id
     * @return 学院阅读数量
     */
    @Override
    public int countCollegeReadMsg(String ybCollegename, int id) {
        int count = 0;
        String sql = "SELECT count(*) AS count FROM tongzhi WHERE yb_collegename = ? AND tongzhi = ?;";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ybCollegename);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
            DbUtil.close(con, ps, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 添加通知阅读记录
     * 
     * @param message 阅读信息
     */
    @Override
    public int saveMessage(Message message) {
        int i = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sql = "insert into tongzhi (yb_userid, yb_realname, yb_collegename, yb_classname, yb_studentid, tongzhi, read_date) values (?,?,?,?,?,?,?);";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, message.getYbUserid());
            ps.setString(2, message.getYbRealname());
            ps.setString(3, message.getYbCollegename());
            ps.setString(4, message.getYbClassname());
            ps.setString(5, message.getYbStudentid());
            ps.setInt(6, message.getTongzhi());
            ps.setString(7, sdf.format(message.getReadDate()));
            i = ps.executeUpdate();
            DbUtil.close(con, ps, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
