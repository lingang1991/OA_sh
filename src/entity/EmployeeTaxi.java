package entity;

import java.util.Date;

public class EmployeeTaxi {
	
	private String eid;//序号
	private String enumb;//工号
	private String ename;//姓名
	private Date etaxiday;//打车日期
	private String etaxigo;//打车目的地
	private String etaxicost;//打车费用
	public EmployeeTaxi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeTaxi(String eid, String enumb, String ename, Date etaxiday,
			String etaxigo, String etaxicost) {
		
		this.eid = eid;
		this.enumb = enumb;
		this.ename = ename;
		this.etaxiday = etaxiday;
		this.etaxigo = etaxigo;
		this.etaxicost = etaxicost;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEnumb() {
		return enumb;
	}
	public void setEnumb(String enumb) {
		this.enumb = enumb;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getEtaxiday() {
		return etaxiday;
	}
	public void setEtaxiday(Date etaxiday) {
		this.etaxiday = etaxiday;
	}
	public String getEtaxigo() {
		return etaxigo;
	}
	public void setEtaxigo(String etaxigo) {
		this.etaxigo = etaxigo;
	}
	public String getEtaxicost() {
		return etaxicost;
	}
	public void setEtaxicost(String etaxicost) {
		this.etaxicost = etaxicost;
	}
	@Override
	public String toString() {
		return "EmployeeTaxi [eid=" + eid + ", enumb=" + enumb + ", ename="
				+ ename + ", etaxiday=" + etaxiday + ", etaxigo=" + etaxigo
				+ ", etaxicost=" + etaxicost + "]";
	}
	
	

}
