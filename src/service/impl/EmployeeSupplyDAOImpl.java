package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.EmployeeOut;
import entity.EmployeeRest;
import entity.EmployeeSupply;
import entity.EmployeeWork;
import service.EmployeeOutDAO;
import service.EmployeeRestDAO;
import service.EmployeeSupplyDAO;

public class EmployeeSupplyDAOImpl implements EmployeeSupplyDAO{

	@Override
	public List<EmployeeSupply> queryAllEmployeeSupply() {
	
		Transaction tx =null;
		List<EmployeeSupply> list2=null;
		String hql="";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeSupplyDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeSupplyDAOImpl---开启事务成功！");

			hql = "from EmployeeSupply";
			Query query = session.createQuery(hql);
			list2 = query.list();
			tx.commit();
			return list2;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeSupplyDAOImpl：用户业务逻辑接口中的所有加班资料查询方法对应的实现类有异常！");
			e.printStackTrace();
			tx.commit();
			return list2;
			
			
		}finally{
			// 释放事务资源
						if (tx != null) {
							
							tx = null;
						}
		}
		
		
	}

	@Override
	public EmployeeSupply queryEmployeeSupplyBySid(String sid) {
		// TODO Auto-generated method stub

		Transaction tx =null;
		EmployeeSupply s=null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeSupplyDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeSupplyDAOImpl---开启事务成功！");
            s=(EmployeeSupply) session.get(EmployeeSupply.class,sid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeSupplyDAOImpl：用户业务逻辑接口中的单个加班资料查询方法对应的实现类有异常！");
			e.printStackTrace();
			tx.commit();
			return s;
			
			
		}finally{
			// 释放事务资源
						if (tx != null) {
							
							tx = null;
						}
		}
		
		
	}

	
	@Override
	public boolean deleteEmployeeSupply(String sid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		//String hql="";
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeSupplyDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeSupplyDAOImpl---开启事务成功！");
			//session.get()只能通过主键来查询
			EmployeeSupply s = (EmployeeSupply) session.get(EmployeeSupply.class,sid);
			session.delete(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeRestDAOImpl：用户业务逻辑接口中的删除方法对应的实现类有异常！");
			e.printStackTrace();
			tx.commit();
			return false;
			
			
		}finally{
			// 释放事务资源
						if (tx != null) {
							
							tx = null;
						}
		}
		
	}
	
	
}
