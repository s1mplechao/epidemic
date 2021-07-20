package coronavirus.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通知阅读记录
 *
 * @author hui
 */
public class Message {
    // 阅读记录id
    private Integer id;
    // 易班id
    private String ybUserid;
    // 姓名
    private String ybRealname;
    // 学院
    private String ybCollegename;
    // 班级
    private String ybClassname;
    // 学号
    private String ybStudentid;
    // 通知id
    private Integer tongzhi;
    // 阅读时间
    private Date readDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYbUserid() {
        return ybUserid;
    }

    public void setYbUserid(String ybUserid) {
        this.ybUserid = ybUserid;
    }

    public String getYbRealname() {
        return ybRealname;
    }

    public void setYbRealname(String ybRealname) {
        this.ybRealname = ybRealname;
    }

    public String getYbCollegename() {
        return ybCollegename;
    }

    public void setYbCollegename(String ybCollegename) {
        this.ybCollegename = ybCollegename;
    }

    public String getYbClassname() {
        return ybClassname;
    }

    public void setYbClassname(String ybClassname) {
        this.ybClassname = ybClassname;
    }

    public String getYbStudentid() {
        return ybStudentid;
    }

    public void setYbStudentid(String ybStudentid) {
        this.ybStudentid = ybStudentid;
    }

    public Integer getTongzhi() {
        return tongzhi;
    }

    public void setTongzhi(Integer tongzhi) {
        this.tongzhi = tongzhi;
    }

    public Date getReadDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            this.readDate = sdf.parse(sdf.format(this.readDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return readDate;
    }

    public void setReadDate(Date readDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            this.readDate = sdf.parse(sdf.format(readDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", ybUserid=" + ybUserid + ", ybRealname=" + ybRealname + ", ybCollegename=" + ybCollegename + ", ybClassname=" + ybClassname + ", ybStudentid=" + ybStudentid
                + ", tongzhi=" + tongzhi + ", readDate=" + readDate + "]";
    }

}
