package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDAO;

//�û�ҵ���߼��ӿڶ�Ӧ��ʵ����
public class UsersDAOImpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users u) {
		
		System.out.print("UsersDAOImpl implements UsersDAO���������ã�");
		// TODO Auto-generated method stub

		// �������
		Transaction tx = null;
		// ��ѯ��hql���
		String hql = "";

		try {

			// ��ûỰ����
			/*
			 * �������Session(org.hibernate.Session) 
			 * (1)���̵߳ģ��������Ķ��󣬴�����һ�λỰ�Ĺ��̡�
			 * ʵ�����ǰ�һ��JDBC Connection���
			 * �ˣ������԰���һЩ�־û�����Ļ��濴�����������������������һ���м�ӿ�.
			 * ��hibernate���������.���ǽ�session��������������������������һ���м�ӿڻ��������һ���־ö���Ļ�����
			 * hibernate�ܼ�⵽��Щ�־ö���ĸı�,����ʱˢ�����ݿ� 
			 * (2) ÿһ��Sessionʵ����һ�����ݿ������
			 * ͨ����ÿһ��Sessionʵ����һ�����ݴ���������
			 * ����˵,ÿִ��һ�����ݿ�����(����),��Ӧ���ȴ���һ���µ�Sessionʵ��. �������ִ���г����쳣,Ӧ�ó�������.
			 * ��������ִ�гɹ����,���Ӧ�õ���Session��close()����,�Ӷ��ͷ�Sessionʵ��ռ�õ���Դ. 
			 * (3)��λ��Session���� ���ȴ���SessionFactory����
			 * Ӧ�÷�����������ʶ������Դʱ,��Ӧ�ò������SessionFactory;
			 * ���ǽ���Ϊ�˷�����ĳ������ʱ,��Ҫ����һ���µ�SessionFactory
			 * ,��Ϊ����SessionFactory��Ҫ���Ĵ�������Դ. Ȼ�����SessionFactory�ٴ���Session����
			 */
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.print("UsersDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.print("UsersDAOImpl---��������ɹ���");

			hql = "from Users where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			
			//��Query����queryת���ɼ��ϣ����ҰѸü��ϸ�ֵ��һ���µļ��ϡ�
			List list = query.list();
			// �����ݿ��CURD�������ȱ��浽�������commit֮�����������ݿ�ִ��
			tx.commit();
			if (list.size() > 0) {
				System.out.print("�û�����������֤�ɹ���");
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ӡUsersDAOImpl���û�ҵ���߼��ӿڶ�Ӧ��ʵ�������쳣��");
			return false;
		} finally {

			// �ͷ�������Դ
			if (tx != null) {
				
				tx = null;
			}

		}

	}

}
