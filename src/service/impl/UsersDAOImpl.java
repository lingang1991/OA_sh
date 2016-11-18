package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDAO;

//用户业务逻辑接口对应的实现类
public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users u) {
		
		System.out.print("UsersDAOImpl implements UsersDAO方法被调用！");
		// TODO Auto-generated method stub

		// 事务对象
		Transaction tx = null;
		// 查询的hql语句
		String hql = "";

		try {

			// 获得会话对象
			/*
			 * ★★★→→Session(org.hibernate.Session) 
			 * (1)单线程的，短寿命的对象，代表了一次会话的过程。
			 * 实际上是把一个JDBC Connection打包
			 * 了，它可以包含一些持久化对象的缓存看作介于数据连接与事物管理一种中间接口.
			 * 在hibernate的设计者中.他们将session看作介于数据连接与事物管理的一种中间接口或者想象成一个持久对象的缓冲区
			 * hibernate能检测到这些持久对象的改变,并及时刷新数据库 
			 * (2) 每一个Session实例和一个数据库事务绑定
			 * 通常将每一个Session实例和一个数据处理库事务绑定
			 * 就是说,每执行一个数据库事务(操作),都应该先创建一个新的Session实例. 如果事务执行中出现异常,应该撤消事务.
			 * 不论事务执行成功与否,最后都应该调用Session的close()方法,从而释放Session实例占用的资源. 
			 * (3)如何获得Session对象 首先创建SessionFactory对象
			 * 应用服务器如果访问多个数据源时,则应该产生多个SessionFactory;
			 * 但是仅仅为了服务与某个请求时,不要创建一个新的SessionFactory
			 * ,因为创建SessionFactory需要消耗大量的资源. 然后根据SessionFactory再创建Session对象
			 */
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.print("UsersDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.print("UsersDAOImpl---开启事务成功！");

			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			
			//将Query对象query转换成集合，并且把该集合赋值给一个新的集合。
			List list = query.list();
			// 对数据库的CURD操作，先保存到缓存里，当commit之后，真正在数据库执行
			tx.commit();
			if (list.size() > 0) {
				System.out.print("用户名和密码验证成功！");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("打印UsersDAOImpl：用户业务逻辑接口对应的实现类有异常！");
			return false;
		} finally {

			// 释放事务资源
			if (tx != null) {
				
				tx = null;
			}

		}

	}

}
