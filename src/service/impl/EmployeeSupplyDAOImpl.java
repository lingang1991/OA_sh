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
			System.out.println("EmployeeSupplyDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeSupplyDAOImpl---��������ɹ���");

			hql = "from EmployeeSupply";
			Query query = session.createQuery(hql);
			list2 = query.list();
			tx.commit();
			return list2;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeSupplyDAOImpl���û�ҵ���߼��ӿ��е����мӰ����ϲ�ѯ������Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return list2;
			
			
		}finally{
			// �ͷ�������Դ
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
			System.out.println("EmployeeSupplyDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeSupplyDAOImpl---��������ɹ���");
            s=(EmployeeSupply) session.get(EmployeeSupply.class,sid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeSupplyDAOImpl���û�ҵ���߼��ӿ��еĵ����Ӱ����ϲ�ѯ������Ӧ��ʵ�������쳣��");
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
	public boolean deleteEmployeeSupply(String sid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		//String hql="";
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("EmployeeSupplyDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeSupplyDAOImpl---��������ɹ���");
			//session.get()ֻ��ͨ����������ѯ
			EmployeeSupply s = (EmployeeSupply) session.get(EmployeeSupply.class,sid);
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
	
	
}
