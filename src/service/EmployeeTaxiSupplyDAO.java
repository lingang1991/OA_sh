package service;

import java.util.List;

import entity.EmployeeOut;
import entity.EmployeeTaxiSupply;
import entity.Students;

public interface EmployeeTaxiSupplyDAO {
    
	//查询所有出差信息
	public List<EmployeeTaxiSupply> queryAllEmployeeTaxiSupply();

	
}
