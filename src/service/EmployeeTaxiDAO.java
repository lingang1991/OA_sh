package service;

import java.util.List;

import entity.EmployeeTaxi;
import entity.EmployeeWork;


public interface EmployeeTaxiDAO {
    
	//��ѯ���г�����Ϣ
	public List<EmployeeTaxi> queryAllEmployeeTaxi();
	//��ѯĳһ�����������Ϣ
	public EmployeeTaxi queryEmployeeTaxiByEid(String eid);
	//���ӳ�������
	public boolean addEmployeeTaxi(EmployeeTaxi employeeTaxi);
	//�޸ĳ�������
	public boolean updateEmployeeTaxi(EmployeeTaxi employeeTaxi);
	//ɾ����������
	public boolean deleteEmployeeTaxi(String eid);

}
