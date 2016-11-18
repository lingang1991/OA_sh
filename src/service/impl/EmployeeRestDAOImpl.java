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
			System.out.println("EmployeeRestDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---��������ɹ���");

			hql = "from EmployeeRest";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeRestDAOImpl���û�ҵ���߼��ӿ��е����мӰ����ϲ�ѯ������Ӧ��ʵ�������쳣��");
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
	public EmployeeRest queryEmployeeRestByEid(String eid) {
		// TODO Auto-generated method stub

		Transaction tx =null;
		EmployeeRest s=null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeRestDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---��������ɹ���");
            s=(EmployeeRest) session.get(EmployeeRest.class,eid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeRestDAOImpl���û�ҵ���߼��ӿ��еĵ����Ӱ����ϲ�ѯ������Ӧ��ʵ�������쳣��");
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
	public boolean addEmployeeRest(EmployeeRest employeeRest) {
		// TODO Auto-generated method stub
		//��������ѧ��û��������ţ�������Ҫ��ֵ
		employeeRest.setEid(getNewEid());
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeRestDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---��������ɹ���");
			session.save(employeeRest);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("��ӡEmployeeRestDAOImpl���û�ҵ���߼��ӿ��е���ӼӰ���Ϣ������Ӧ��ʵ�������쳣��");
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
	public boolean updateEmployeeRest(EmployeeRest employeeRest) {
	
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeWorkDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---��������ɹ���");
			session.update(employeeRest);
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
	public boolean deleteEmployeeRest(String eid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		//String hql="";
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeRestDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeRestDAOImpl---��������ɹ���");
			//session.get()ֻ��ͨ����������ѯ
			EmployeeRest s = (EmployeeRest) session.get(EmployeeRest.class,eid);
			session.delete(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeRestDAOImpl���û�ҵ���߼��ӿ��е�ɾ��������Ӧ��ʵ�������쳣��");
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
			System.out.println("EmployeeWorkDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeWorkDAOImpl---��������ɹ���");
			hql="select max(eid) from EmployeeWork";
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
