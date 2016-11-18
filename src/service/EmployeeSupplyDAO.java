package service;

import java.util.List;

import entity.EmployeeRest;
import entity.EmployeeSupply;

public interface EmployeeSupplyDAO {
    
	//查询所有出差信息
	public List<EmployeeSupply> queryAllEmployeeSupply();
	//查询某一条具体出差信息
	public EmployeeSupply queryEmployeeSupplyBySid(String sid);
	

	//删除出差资料
	public boolean deleteEmployeeSupply(String eid);

}
