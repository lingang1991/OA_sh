package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.EmployeeWorkDAO;
import db.MyHibernateSessionFactory;
import entity.EmployeeWork;

public class EmployeeWorkDAOImpl implements EmployeeWorkDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeWork> queryAllEmployeeWork() {
	
		Transaction tx =null;
		List<EmployeeWork> list=null;
		String hql="";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeWorkDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---��������ɹ���");

			hql = "from EmployeeWork";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeWorkDAOImpl���û�ҵ���߼��ӿ��е����мӰ����ϲ�ѯ������Ӧ��ʵ�������쳣��");
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
	public EmployeeWork queryEmployeeWorkByEid(String eid) {
		// TODO Auto-generated method stub

		Transaction tx =null;
		EmployeeWork s=null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeWorkDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---��������ɹ���");
            s=(EmployeeWork) session.get(EmployeeWork.class,eid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeWorkDAOImpl���û�ҵ���߼��ӿ��еĵ����Ӱ����ϲ�ѯ������Ӧ��ʵ�������쳣��");
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
	public boolean addEmployeeWork(EmployeeWork employeeWork) {
		// TODO Auto-generated method stub
		//��������ѧ��û��������ţ�������Ҫ��ֵ
		
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("employeeWorkDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("employeeWorkDAOImpl---��������ɹ���");
			session.save(employeeWork);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("��ӡemployeeWorkDAOImpl���û�ҵ���߼��ӿ��е���ӼӰ���Ϣ������Ӧ��ʵ�������쳣��");
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
	public boolean updateEmployeeWork(EmployeeWork employeeWork) {
	
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeWorkDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---��������ɹ���");
			session.update(employeeWork);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("��ӡEmployeeWorkDAOImpl���û�ҵ���߼��ӿ��еĸ��¼Ӱ����Ϸ�����Ӧ��ʵ�������쳣��");
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
	public boolean deleteEmployeeWork(String eid) {
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
			EmployeeWork s = (EmployeeWork) session.get(EmployeeWork.class,eid);
			session.delete(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeWorkDAOImpl���û�ҵ���߼��ӿ��е�ɾ��������Ӧ��ʵ�������쳣��");
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
		String eid=null;
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeWorkDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---��������ɹ���");
			hql="select max(eid) from EmployeeWork";
		    Query query = session.createQuery(hql);
		    eid=(String) query.uniqueResult();//�÷������ص���object���ͣ���Ҫ����ת��
		    if (eid==null||"".equals(eid)) {
				//���Ϊ�գ���һ��Ĭ�ϵı��
		    	eid="1";
			}else {
				
				//����ȡ���沿��ת��Ϊ���֣�����S0000005,ȡ���ֲ��ֱ�Ϊ5
				//String temp = eid.substring(1);
				int i = Integer.valueOf(eid);
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
			System.out.println("��ӡEmployeeWorkDAOImpl���û�ҵ���߼��ӿ��еĻ�ȡ����Ŷ�Ӧ��ʵ�������쳣��");
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
