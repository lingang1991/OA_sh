package entity;

import java.util.Date;
//�����ʵ����
public class EmployeeOut {
    private String eid;//���
	private String enumb;//����
	private String ename;//����
	private String eoutcity;//�������
	private Date eoutbt;//���ʼʱ��
	private Date eoutot;//�������ʱ��
	private String eoutdays;//��������
	private String echecked;//У��
	private String eoutcontent;//���������
	public EmployeeOut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeOut(String eid, String enumb, String ename, String eoutcity,
			Date eoutbt, Date eoutot, String eoutdays, String echecked,
			String eoutcontent) {
		
		this.eid = eid;
		this.enumb = enumb;
		this.ename = ename;
		this.eoutcity = eoutcity;
		this.eoutbt = eoutbt;
		this.eoutot = eoutot;
		this.eoutdays = eoutdays;
		this.echecked = echecked;
		this.eoutcontent = eoutcontent;
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
	public String getEoutcity() {
		return eoutcity;
	}
	public void setEoutcity(String eoutcity) {
		this.eoutcity = eoutcity;
	}
	public Date getEoutbt() {
		return eoutbt;
	}
	public void setEoutbt(Date eoutbt) {
		this.eoutbt = eoutbt;
	}
	public Date getEoutot() {
		return eoutot;
	}
	public void setEoutot(Date eoutot) {
		this.eoutot = eoutot;
	}
	public String getEoutdays() {
		return eoutdays;
	}
	public void setEoutdays(String eoutdays) {
		this.eoutdays = eoutdays;
	}
	public String getEchecked() {
		return echecked;
	}
	public void setEchecked(String echecked) {
		this.echecked = echecked;
	}
	public String getEoutcontent() {
		return eoutcontent;
	}
	public void setEoutcontent(String eoutcontent) {
		this.eoutcontent = eoutcontent;
	}
	
	
	
}
