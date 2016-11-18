package service;

import java.util.List;

import entity.Students;

public interface StudentsDAO {
    
	//查询所有学生信息
	public List<Students> queryAllStudents();
	//查询指定学生信息
	public Students queryStudentsBySid(String sid);
	//增加学生资料
	public boolean addStudents(Students s);
	//修改学生资料
	public boolean updateStudents(Students s);
	//删除学生资料
	public boolean deleteStudents(String sid);

}
