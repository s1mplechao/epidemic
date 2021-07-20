package qiandao.bean;

public class Student {
	private int id;
	private String ybUserid;
	private String ybRealname;
	private String ybCollegename;
	private String ybClassname;
	private String ybEnteryear;
	private String ybStudentid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getYbEnteryear() {
		return ybEnteryear;
	}
	public void setYbEnteryear(String ybEnteryear) {
		this.ybEnteryear = ybEnteryear;
	}
	public String getYbStudentid() {
		return ybStudentid;
	}
	public void setYbStudentid(String ybStudentid) {
		this.ybStudentid = ybStudentid;
	}
	public Student(int id, String ybUserid, String ybRealname, String ybCollegename, String ybClassname,
			String ybEnteryear, String ybStudentid) {
		super();
		this.id = id;
		this.ybUserid = ybUserid;
		this.ybRealname = ybRealname;
		this.ybCollegename = ybCollegename;
		this.ybClassname = ybClassname;
		this.ybEnteryear = ybEnteryear;
		this.ybStudentid = ybStudentid;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", ybUserid=" + ybUserid + ", ybRealname=" + ybRealname + ", ybCollegename="
				+ ybCollegename + ", ybClassname=" + ybClassname + ", ybEnteryear=" + ybEnteryear + ", ybStudentid="
				+ ybStudentid + "]";
	}
	
}
