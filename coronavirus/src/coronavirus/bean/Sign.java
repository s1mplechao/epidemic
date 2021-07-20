package coronavirus.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 签到记录
 *
 * @author hui
 */
public class Sign {
    // 签到id
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
    // 问卷
    private String wenjuan;
    // 问卷
    private String position;
    // 签到时间
    private Date signDate;

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

    public String getWenjuan() {
        return wenjuan;
    }

    public void setWenjuan(String wenjuan) {
        this.wenjuan = wenjuan;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getSignDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.signDate = sdf.parse(sdf.format(this.signDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return signDate;
    }

    public void setSignDate(Date signDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.signDate = sdf.parse(sdf.format(signDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Sign [id=" + id + ", ybUserid=" + ybUserid + ", ybRealname=" + ybRealname + ", ybCollegename=" + ybCollegename + ", ybClassname=" + ybClassname + ", ybStudentid=" + ybStudentid
                + ", wenjuan=" + wenjuan + ", position=" + position + ", signDate=" + signDate + "]";
    }

}
