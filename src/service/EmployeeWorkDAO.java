package service;

import java.util.List;

import entity.EmployeeWork;


public interface EmployeeWorkDAO {
    
	//查询所有出差信息
	public List<EmployeeWork> queryAllEmployeeWork();
	//查询某一条具体出差信息
	public EmployeeWork queryEmployeeWorkByEid(String eid);
	//增加出差资料
	public boolean addEmployeeWork(EmployeeWork employeeWork);
	//修改出差资料
	public boolean updateEmployeeWork(EmployeeWork employeeWork);
	//删除出差资料
	public boolean deleteEmployeeWork(String eid);

}
