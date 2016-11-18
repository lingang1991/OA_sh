package service.impl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import entity.EmployeeOut;
import entity.EmployeeWork;
import entity.Students;
import service.EmployeeOutDAO;
import service.EmployeeWorkDAO;
import service.StudentsDAO;

public class TestEmployeeWorkDAOImpl {
	@Test
	public void testQueryAllEmployeeWork() {
		EmployeeWorkDAO sdao = new EmployeeWorkDAOImpl();
		List<EmployeeWork> list = sdao.queryAllEmployeeWork();

		for (int i = 0; i < list.size(); i++) {
			
		System.out.println(list.get(i));

		}
		
		 for (EmployeeWork e : list) {
	            if(e.getEname().equals("王二")){
	                System.out.println("对象:"+e.toString());
	            }
	        }

		
	}
	
	
	public void testGetNewSid(){
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		
		//System.out.println(sdao.getNewSid());
		
	}
	
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
