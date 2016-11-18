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
			System.out.println("EmployeeTaxiSupplyDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("EmployeeTaxiSupplyDAOImpl---��������ɹ���");

			hql = "from EmployeeTaxiSupply";
			Query query = session.createQuery(hql);
			list1 = query.list();
			tx.commit();
			return list1;
			
		} catch (Exception e) {
			System.out.println("��ӡEmployeeOutDAOImpl���û�ҵ���߼��ӿ��е��������ϲ�ѯ������Ӧ��ʵ�������쳣��");
			e.printStackTrace();
			tx.commit();
			return list1;
			
			
		}finally{
			// �ͷ�������Դ
						if (tx != null) {
							
							tx = null;
						}
		}
		
		
	}

	
}
