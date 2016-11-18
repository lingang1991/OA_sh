package service;

import java.util.List;

import entity.Students;

public interface StudentsDAO {
    
	//��ѯ����ѧ����Ϣ
	public List<Students> queryAllStudents();
	//��ѯָ��ѧ����Ϣ
	public Students queryStudentsBySid(String sid);
	//����ѧ������
	public boolean addStudents(Students s);
	//�޸�ѧ������
	public boolean updateStudents(Students s);
	//ɾ��ѧ������
	public boolean deleteStudents(String sid);

}
