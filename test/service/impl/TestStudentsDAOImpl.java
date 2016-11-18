package service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import entity.Students;
import service.StudentsDAO;

public class TestStudentsDAOImpl {
	
	public void testQueryAllStudents() {
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();

		for (int i = 0; i < list.size(); i++) {
			
		System.out.println(list.get(i));

		}
	}
	
	
	public void testGetNewSid(){
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		
		//System.out.println(sdao.getNewSid());
		
	}
	@Test
	//数据插入测试方法
	public void testAddStudents(){
		
		Students s = new Students();
		s.setSname("老王");
		s.setGender("男");
		s.setBirthday(new Date());
        s.setAddress("三牌楼");
        
        StudentsDAO sdao =new StudentsDAOImpl();
        Assert.assertEquals(true, sdao.addStudents(s));
	}
	
	
	

}
