package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.EmployeeOut;
import entity.EmployeeRest;
import entity.EmployeeWork;
import service.EmployeeOutDAO;
import service.EmployeeRestDAO;
import service.EmployeeWorkDAO;

public class EmployeeRestDAOImpl implements EmployeeRestDAO{

	@Override
	public List<EmployeeRest> queryAllEmployeeRest() {
	
		Transaction tx =null;
		List<EmployeeRest> list=null;
		String hql="";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeRestDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---开启事务成功！");

			hql = "from EmployeeRest";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeRestDAOImpl：用户业务逻辑接口中的所有加班资料查询方法对应的实现类有异常！");
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
	public EmployeeRest queryEmployeeRestByEid(String eid) {
		// TODO Auto-generated method stub

		Transaction tx =null;
		EmployeeRest s=null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeRestDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---开启事务成功！");
            s=(EmployeeRest) session.get(EmployeeRest.class,eid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("打印EmployeeRestDAOImpl：用户业务逻辑接口中的单个加班资料查询方法对应的实现类有异常！");
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
	public boolean addEmployeeRest(EmployeeRest employeeRest) {
		// TODO Auto-generated method stub
		//传进来的学生没有主键编号，首先需要赋值
		employeeRest.setEid(getNewEid());
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeRestDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---开启事务成功！");
			session.save(employeeRest);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("打印EmployeeRestDAOImpl：用户业务逻辑接口中的添加加班信息方法对应的实现类有异常！");
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
	public boolean updateEmployeeRest(EmployeeRest employeeRest) {
	
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeWorkDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---开启事务成功！");
			session.update(employeeRest);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("打印EmployeeWorkDAOImpl：用户业务逻辑接口中的更新加班资料方法对应的实现类有异常！");
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
	public boolean deleteEmployeeRest(String eid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		//String hql="";
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeRestDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---开启事务成功！");
			//session.get()只能通过主键来查询
			EmployeeRest s = (EmployeeRest) session.get(EmployeeRest.class,eid);
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
	
	private String getNewEid(){
		Transaction tx =null;
		String hql="";
		String eid="";
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeWorkDAOImpl---获取session会话成功！");
			// 开启事务
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---开启事务成功！");
			hql="select max(eid) from EmployeeWork";
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
			System.out.println("打印EmployeeWorkDAOImpl：用户业务逻辑接口中的获取最大编号对应的实现类有异常！");
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
