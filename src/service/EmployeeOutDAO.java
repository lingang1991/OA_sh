package service;

import java.util.List;

import entity.EmployeeOut;
import entity.Students;

public interface EmployeeOutDAO {
    
	//��ѯ���г�����Ϣ
	public List<EmployeeOut> queryAllEmployeeOut();
	//��ѯĳһ�����������Ϣ
	public EmployeeOut queryEmployeeOutByEid(String eid);
	//���ӳ�������
	public boolean addEmployeeOut(EmployeeOut employeeOut);
	//�޸ĳ�������
	public boolean updateEmployeeOut(EmployeeOut employeeOut);
	//ɾ����������
	public boolean deleteEmployeeOut(String eid);

}
