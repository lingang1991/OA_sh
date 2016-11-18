package service;

import java.util.List;

import entity.EmployeeRest;

public interface EmployeeRestDAO {
    
	//查询所有出差信息
	public List<EmployeeRest> queryAllEmployeeRest();
	//查询某一条具体出差信息
	public EmployeeRest queryEmployeeRestByEid(String eid);
	//增加出差资料
	public boolean addEmployeeRest(EmployeeRest employeeRest);
	//修改出差资料
	public boolean updateEmployeeRest(EmployeeRest employeeRest);
	//删除出差资料
	public boolean deleteEmployeeRest(String eid);

}
