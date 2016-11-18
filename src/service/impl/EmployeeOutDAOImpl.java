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
			System.out.println("EmployeeOutDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---��������ɹ���");

			hql = "from EmployeeOut";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeOutDAOImpl���û�ҵ���߼��ӿ��е��������ϲ�ѯ������Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return list;
			
			
		}finally{
			// �ͷ�������Դ
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
			System.out.println("EmployeeOutDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---��������ɹ���");
            s=(EmployeeOut) session.get(EmployeeOut.class,eid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeOutDAOImpl���û�ҵ���߼��ӿ��еĵ����������ϲ�ѯ������Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return s;
			
			
		}finally{
			// �ͷ�������Դ
						if (tx != null) {
							
							tx = null;
						}
		}
		
		
	}

	@Override
	public boolean addEmployeeOut(EmployeeOut employeeOut) {
		// TODO Auto-generated method stub
		//��������ѧ��û��������ţ�������Ҫ��ֵ
		employeeOut.setEid(getNewEid());
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---��������ɹ���");
			session.save(employeeOut);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("��ӡStudentsDAOImpl���û�ҵ���߼��ӿ��е�������Ϸ�����Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return false;
			
			
			
		}finally{
			// �ͷ�������Դ
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
			System.out.println("EmployeeOutDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---��������ɹ���");
			session.update(employeeOut);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("��ӡEmployeeOutDAOImpl���û�ҵ���߼��ӿ��еĸ������Ϸ�����Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return false;
			
			
			
		}finally{
			// �ͷ�������Դ
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
			System.out.println("EmployeeOutDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---��������ɹ���");
			//session.get()ֻ��ͨ����������ѯ
			EmployeeOut s = (EmployeeOut) session.get(EmployeeOut.class,eid);
			session.delete(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeOutDAOImpl���û�ҵ���߼��ӿ��е�ɾ��������Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return false;
			
			
		}finally{
			// �ͷ�������Դ
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
			System.out.println("EmployeeOutDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeOutDAOImpl---��������ɹ���");
			hql="select max(eid) from EmployeeOut";
		    Query query = session.createQuery(hql);
		    eid= (String) query.uniqueResult();//�÷������ص���object���ͣ���Ҫ����ת��
		    if (eid==null||"".equals(eid)) {
				//���Ϊ�գ���һ��Ĭ�ϵı��
		    	eid="00001";
			}else {
				
				//����ȡ���沿��ת��Ϊ���֣�����S0000005,ȡ���ֲ��ֱ�Ϊ5
				//String temp = eid.substring(1);
				int i = Integer.parseInt(eid);
				i++;
				//�ٻ�ԭ���ַ�����'5'
				eid=String.valueOf(i);
				//int len = temp.length();
				
				//�ճ���λ
				//for (int j = 0; j <7-len; j++) {
				//	temp = "0"+temp;
				//}
				//sid="S"+temp;
				
				
			}
		    tx.commit();
		    return eid;
			
		}catch (Exception e) {
			System.out.println("��ӡemployeeOutDAOImpl���û�ҵ���߼��ӿ��еĻ�ȡ����Ŷ�Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return null;
		}finally{
			// �ͷ�������Դ
						if (tx != null) {	
							tx = null;
						}
		}
	}
}
