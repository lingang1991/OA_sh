package service.impl;

import org.junit.Assert;
import org.junit.Test;

import service.UsersDAO;
import entity.Users;

public class TestUsersDAOImpl {
	
	@Test
	public void testUsersLogin(){
		
		Users u =new Users(1,"�ָ�","12345678");
		System.out.println("users--test1--");
		UsersDAO udao = new UsersDAOImpl();
		System.out.println("users--test2--");
		//���ԣ������û���¼����ĵĲ���ֵ����½�ɹ�����true
		Assert.assertEquals(true,udao.usersLogin(u));
	}

}
