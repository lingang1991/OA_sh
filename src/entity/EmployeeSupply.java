package entity;

import java.util.Date;

public class EmployeeSupply {

	private String sid;//���
	private int sreimburse;//�������
	private int snumbs;//�ò�����
	private int stimes;//�òʹ�����Ĭ��Ϊ 1��
	private String scooperate;//�Ƿ����ⲿЭ����λ��Ĭ��Ϊ ��
	private String senum;//�ò���ԱԱ�����
	private String sename;//�ò���Ա����
	private Date sday;//����
	private String sholiday;//�Ƿ���ڣ�Ĭ��Ϊ ��
	private String sreason;//�������ɣ�Ĭ�ϲ�Ʒ�з��Ӱࣩ
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
