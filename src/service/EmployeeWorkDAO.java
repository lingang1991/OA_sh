package service;

import java.util.List;

import entity.EmployeeWork;


public interface EmployeeWorkDAO {
    
	//��ѯ���г�����Ϣ
	public List<EmployeeWork> queryAllEmployeeWork();
	//��ѯĳһ�����������Ϣ
	public EmployeeWork queryEmployeeWorkByEid(String eid);
	//���ӳ�������
	public boolean addEmployeeWork(EmployeeWork employeeWork);
	//�޸ĳ�������
	public boolean updateEmployeeWork(EmployeeWork employeeWork);
	//ɾ����������
	public boolean deleteEmployeeWork(String eid);

}
