package service;

import entity.Users;

//用户业务逻辑接口
public interface UsersDAO {
	
	//用户登录方法
	public boolean usersLogin(Users u);//返回是布尔类型，表示用户是否登录成功，u表示一个用户对象
	
	
	
	

}
