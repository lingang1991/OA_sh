package service;

import java.util.List;

import entity.EmployeeRest;

public interface EmployeeRestDAO {
    
	//��ѯ���г�����Ϣ
	public List<EmployeeRest> queryAllEmployeeRest();
	//��ѯĳһ�����������Ϣ
	public EmployeeRest queryEmployeeRestByEid(String eid);
	//���ӳ�������
	public boolean addEmployeeRest(EmployeeRest employeeRest);
	//�޸ĳ�������
	public boolean updateEmployeeRest(EmployeeRest employeeRest);
	//ɾ����������
	public boolean deleteEmployeeRest(String eid);

}
