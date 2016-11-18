package entity;
//出差表实体类
public class EmployeeTaxiSupply {
    private String eid;//序号
	private String enumb;//工号
	private String ename;//姓名
	private String eallcost;//加班费用合计
	public EmployeeTaxiSupply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeTaxiSupply(String eid, String enumb, String ename,
			String eallcost) {
		this.eid = eid;
		this.enumb = enumb;
		this.ename = ename;
		this.eallcost = eallcost;
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
	public String getEallcost() {
		return eallcost;
	}
	public void setEallcost(String eallcost) {
		this.eallcost = eallcost;
	}
	@Override
	public String toString() {
		return "EmployeeTaxiSupply [eid=" + eid + ", enumb=" + enumb
				+ ", ename=" + ename + ", eallcost=" + eallcost + "]";
	}
}
