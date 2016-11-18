package entity;

import java.util.Date;

public class EmployeeRest {
	
	private String eid;//���
	private String enumb;//����
	private String ename;//����
	private Date erestday;//��������
	private String eresttime;//����ʱ���
	private String eresthours;//����ʱ��
	private String erestreason;//����ԭ��
	private String erestremained;//ʣ�����ʱ��
	public EmployeeRest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeRest(String eid, String enumb, String ename, Date erestday,
			String eresttime, String eresthours, String erestreason,
			String erestremained) {
		
		this.eid = eid;
		this.enumb = enumb;
		this.ename = ename;
		this.erestday = erestday;
		this.eresttime = eresttime;
		this.eresthours = eresthours;
		this.erestreason = erestreason;
		this.erestremained = erestremained;
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
	public Date getErestday() {
		return erestday;
	}
	public void setErestday(Date erestday) {
		this.erestday = erestday;
	}
	public String getEresttime() {
		return eresttime;
	}
	public void setEresttime(String eresttime) {
		this.eresttime = eresttime;
	}
	public String getEresthours() {
		return eresthours;
	}
	public void setEresthours(String eresthours) {
		this.eresthours = eresthours;
	}
	public String getErestreason() {
		return erestreason;
	}
	public void setErestreason(String erestreason) {
		this.erestreason = erestreason;
	}
	public String getErestremained() {
		return erestremained;
	}
	public void setErestremained(String erestremained) {
		this.erestremained = erestremained;
	}
	@Override
	public String toString() {
		return "EmployeeRest [eid=" + eid + ", enumb=" + enumb + ", ename="
				+ ename + ", erestday=" + erestday + ", eresttime=" + eresttime
				+ ", eresthours=" + eresthours + ", erestreason=" + erestreason
				+ ", erestremained=" + erestremained + "]";
	}
	
	
	

}
