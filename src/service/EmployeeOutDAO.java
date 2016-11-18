package service;

import java.util.List;

import entity.EmployeeOut;
import entity.Students;

public interface EmployeeOutDAO {
    
	//查询所有出差信息
	public List<EmployeeOut> queryAllEmployeeOut();
	//查询某一条具体出差信息
	public EmployeeOut queryEmployeeOutByEid(String eid);
	//增加出差资料
	public boolean addEmployeeOut(EmployeeOut employeeOut);
	//修改出差资料
	public boolean updateEmployeeOut(EmployeeOut employeeOut);
	//删除出差资料
	public boolean deleteEmployeeOut(String eid);

}
