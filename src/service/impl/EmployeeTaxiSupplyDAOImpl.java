package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.EmployeeOut;
import entity.EmployeeTaxiSupply;
import service.EmployeeOutDAO;
import service.EmployeeTaxiSupplyDAO;

public class EmployeeTaxiSupplyDAOImpl implements EmployeeTaxiSupplyDAO{

	@Override
	public List<EmployeeTaxiSupply> queryAllEmployeeTaxiSupply() {
	
		Transaction tx =null;
		List<EmployeeTaxiSupply> list1=null;
		String hql="";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeTaxiSupplyDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeTaxiSupplyDAOImpl---开启事务成功！");

			hql = "from EmployeeTaxiSupply";
			Query query = session.createQuery(hql);
			list1 = query.list();
			tx.commit();
			return list1;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeOutDAOImpl：用户业务逻辑接口中的所有资料查询方法对应的实现类有异常！");
			e.printStackTrace();
			tx.commit();
			return list1;
			
			
		}finally{
			// 释放事务资源
						if (tx != null) {
							
							tx = null;
						}
		}
		
		
	}

	
}
