package entity;

import java.util.Date;

public class EmployeeSupply {

	private String sid;//序号
	private int sreimburse;//报销金额
	private int snumbs;//用餐人数
	private int stimes;//用餐次数（默认为 1）
	private String scooperate;//是否有外部协作单位（默认为 否）
	private String senum;//用餐人员员工编号
	private String sename;//用餐人员姓名
	private Date sday;//日期
	private String sholiday;//是否假期（默认为 否）
	private String sreason;//工作事由（默认产品研发加班）
	public EmployeeSupply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeSupply(String sid, int sreimburse, int snumbs, int stimes,
			String scooperate, String senum, String sename, Date sday,
			String sholiday, String sreason) {
		
		this.sid = sid;
		this.sreimburse = sreimburse;
		this.snumbs = snumbs;
		this.stimes = stimes;
		this.scooperate = scooperate;
		this.senum = senum;
		this.sename = sename;
		this.sday = sday;
		this.sholiday = sholiday;
		this.sreason = sreason;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getSreimburse() {
		return sreimburse;
	}
	public void setSreimburse(int sreimburse) {
		this.sreimburse = sreimburse;
	}
	public int getSnumbs() {
		return snumbs;
	}
	public void setSnumbs(int snumbs) {
		this.snumbs = snumbs;
	}
	public int getStimes() {
		return stimes;
	}
	public void setStimes(int stimes) {
		this.stimes = stimes;
	}
	public String getScooperate() {
		return scooperate;
	}
	public void setScooperate(String scooperate) {
		this.scooperate = scooperate;
	}
	public String getSenum() {
		return senum;
	}
	public void setSenum(String senum) {
		this.senum = senum;
	}
	public String getSename() {
		return sename;
	}
	public void setSename(String sename) {
		this.sename = sename;
	}
	public Date getSday() {
		return sday;
	}
	public void setSday(Date sday) {
		this.sday = sday;
	}
	public String getSholiday() {
		return sholiday;
	}
	public void setSholiday(String sholiday) {
		this.sholiday = sholiday;
	}
	public String getSreason() {
		return sreason;
	}
	public void setSreason(String sreason) {
		this.sreason = sreason;
	}
	@Override
	public String toString() {
		return "EmployeeSupply [sid=" + sid + ", sreimburse=" + sreimburse
				+ ", snumbs=" + snumbs + ", stimes=" + stimes + ", scooperate="
				+ scooperate + ", senum=" + senum + ", sename=" + sename
				+ ", sday=" + sday + ", sholiday=" + sholiday + ", sreason="
				+ sreason + "]";
	}
	
	
	
	
	
	
	
}
