package entity;

import java.util.Date;

public class EmployeeWork {

	private String eid;//���
	private String enumb;//����
	private String ename;//����
	private Date eworkday;//�Ӱ�����
	private String eworktime;//�Ӱ�ʱ���
	private String eworkhours;//�Ӱ�ʱ��
	private String eworkcity;//�Ӱ����
	private String eworklocation;//�Ӱ�ص�
	private String eworkcontent;//�Ӱ�ɹ�
	public EmployeeWork() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeWork(String eid, String enumb, String ename, Date eworkday,
			String eworktime, String eworkhours, String eworkcity,
			String eworklocation, String eworkcontent) {
	
		this.eid = eid;
		this.enumb = enumb;
		this.ename = ename;
		this.eworkday = eworkday;
		this.eworktime = eworktime;
		this.eworkhours = eworkhours;
		this.eworkcity = eworkcity;
		this.eworklocation = eworklocation;
		this.eworkcontent = eworkcontent;
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
	public Date getEworkday() {
		return eworkday;
	}
	public void setEworkday(Date eworkday) {
		this.eworkday = eworkday;
	}
	public String getEworktime() {
		return eworktime;
	}
	public void setEworktime(String eworktime) {
		this.eworktime = eworktime;
	}
	public String getEworkhours() {
		return eworkhours;
	}
	public void setEworkhours(String eworkhours) {
		this.eworkhours = eworkhours;
	}
	public String getEworkcity() {
		return eworkcity;
	}
	public void setEworkcity(String eworkcity) {
		this.eworkcity = eworkcity;
	}
	public String getEworklocation() {
		return eworklocation;
	}
	public void setEworklocation(String eworklocation) {
		this.eworklocation = eworklocation;
	}
	public String getEworkcontent() {
		return eworkcontent;
	}
	public void setEworkcontent(String eworkcontent) {
		this.eworkcontent = eworkcontent;
	}
	@Override
	public String toString() {
		return "EmployeeWork [eid=" + eid + ", enumb=" + enumb + ", ename="
				+ ename + ", eworkday=" + eworkday + ", eworktime=" + eworktime
				+ ", eworkhours=" + eworkhours + ", eworkcity=" + eworkcity
				+ ", eworklocation=" + eworklocation + ", eworkcontent="
				+ eworkcontent + "]";
	}
	
	
	
	
	
	
}
