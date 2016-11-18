package service;

import java.util.List;

import entity.EmployeeTaxi;
import entity.EmployeeWork;


public interface EmployeeTaxiDAO {
    
	//查询所有出差信息
	public List<EmployeeTaxi> queryAllEmployeeTaxi();
	//查询某一条具体出差信息
	public EmployeeTaxi queryEmployeeTaxiByEid(String eid);
	//增加出差资料
	public boolean addEmployeeTaxi(EmployeeTaxi employeeTaxi);
	//修改出差资料
	public boolean updateEmployeeTaxi(EmployeeTaxi employeeTaxi);
	//删除出差资料
	public boolean deleteEmployeeTaxi(String eid);

}
