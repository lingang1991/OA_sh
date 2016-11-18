package service;

import java.util.List;

import entity.EmployeeRest;
import entity.EmployeeSupply;

public interface EmployeeSupplyDAO {
    
	//��ѯ���г�����Ϣ
	public List<EmployeeSupply> queryAllEmployeeSupply();
	//��ѯĳһ�����������Ϣ
	public EmployeeSupply queryEmployeeSupplyBySid(String sid);
	

	//ɾ����������
	public boolean deleteEmployeeSupply(String eid);

}
