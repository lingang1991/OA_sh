package service.impl;

import org.junit.Assert;
import org.junit.Test;

import service.UsersDAO;
import entity.Users;

public class TestUsersDAOImpl {
	
	@Test
	public void testUsersLogin(){
		
		Users u =new Users(1,"林钢","12345678");
		System.out.println("users--test1--");
		UsersDAO udao = new UsersDAOImpl();
		System.out.println("users--test2--");
		//断言：返回用户登录结果的的布尔值，登陆成功返回true
		Assert.assertEquals(true,udao.usersLogin(u));
	}

}
