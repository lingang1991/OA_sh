package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.EmployeeOut;
import service.EmployeeOutDAO;

public class EmployeeOutDAOImpl implements EmployeeOutDAO{

	@Override
	public List<EmployeeOut> queryAllEmployeeOut() {
	
		Transaction tx =null;
		List<EmployeeOut> list=null;
		String hql="";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeOutDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---开启事务成功！");

			hql = "from EmployeeOut";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeOutDAOImpl：用户业务逻辑接口中的所有资料查询方法对应的实现类有异常！");
			e.printStackTrace();
			tx.commit();
			return list;
			
			
		}finally{
			// 释放事务资源
						if (tx != null) {
							
							tx = null;
						}
		}
		
		
	}

	@Override
	public EmployeeOut queryEmployeeOutByEid(String eid) {
		// TODO Auto-generated method stub

		Transaction tx =null;
		EmployeeOut s=null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeOutDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---开启事务成功！");
            s=(EmployeeOut) session.get(EmployeeOut.class,eid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeOutDAOImpl：用户业务逻辑接口中的单个出差资料查询方法对应的实现类有异常！");
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
	public boolean addEmployeeOut(EmployeeOut employeeOut) {
		// TODO Auto-generated method stub
		//传进来的学生没有主键编号，首先需要赋值
		employeeOut.setEid(getNewEid());
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---开启事务成功！");
			session.save(employeeOut);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("打印StudentsDAOImpl：用户业务逻辑接口中的添加资料方法对应的实现类有异常！");
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

	@Override
	public boolean updateEmployeeOut(EmployeeOut employeeOut) {
	
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeOutDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---开启事务成功！");
			session.update(employeeOut);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("打印EmployeeOutDAOImpl：用户业务逻辑接口中的更新资料方法对应的实现类有异常！");
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

	@Override
	public boolean deleteEmployeeOut(String eid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		//String hql="";
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeOutDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---开启事务成功！");
			//session.get()只能通过主键来查询
			EmployeeOut s = (EmployeeOut) session.get(EmployeeOut.class,eid);
			session.delete(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeOutDAOImpl：用户业务逻辑接口中的删除方法对应的实现类有异常！");
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
	
	private String getNewEid(){
		Transaction tx =null;
		String hql="";
		String eid="";
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeOutDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---开启事务成功！");
			hql="select max(eid) from EmployeeOut";
		    Query query = session.createQuery(hql);
		    eid= (String) query.uniqueResult();//该方法返回的是object类型，需要类型转换
		    if (eid==null||"".equals(eid)) {
				//如果为空，给一个默认的编号
		    	eid="00001";
			}else {
				
				//这里取后面部分转换为数字，例如S0000005,取数字部分变为5
				//String temp = eid.substring(1);
				int i = Integer.parseInt(eid);
				i++;
				//再还原成字符类型'5'
				eid=String.valueOf(i);
				//int len = temp.length();
				
				//凑成七位
				//for (int j = 0; j <7-len; j++) {
				//	temp = "0"+temp;
				//}
				//sid="S"+temp;
				
				
			}
		    tx.commit();
		    return eid;
			
		}catch (Exception e) {
			System.out.println("打印employeeOutDAOImpl：用户业务逻辑接口中的获取最大编号对应的实现类有异常！");
			e.printStackTrace();
			tx.commit();
			return null;
		}finally{
			// 释放事务资源
						if (tx != null) {	
							tx = null;
						}
		}
	}
}
