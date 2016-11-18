package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Students;
import service.StudentsDAO;

public class StudentsDAOImpl implements StudentsDAO {

	@Override
	public List<Students> queryAllStudents() {
	
		Transaction tx =null;
		List<Students> list=null;
		String hql="";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---��������ɹ���");

			hql = "from Students";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		} catch (Exception e) {
			System.out.println("��ӡStudentsDAOImpl���û�ҵ���߼��ӿ��е��������ϲ�ѯ������Ӧ��ʵ�������쳣��");
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
	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub

		Transaction tx =null;
		Students s=null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---��������ɹ���");
            s=(Students) session.get(Students.class,sid);
			
			tx.commit();
			return s;
			
		} catch (Exception e) {
			System.out.println("��ӡStudentsDAOImpl���û�ҵ���߼��ӿ��еĵ���ѧ�����ϲ�ѯ������Ӧ��ʵ�������쳣��");
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
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		//��������ѧ��û��������ţ�������Ҫ��ֵ
		s.setSid(getNewSid());
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---��������ɹ���");
			session.save(s);
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
	public boolean updateStudents(Students s) {
	
		Transaction tx =null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---��������ɹ���");
			session.update(s);
			tx.commit();
			return true;
			
			
		}  catch (Exception e) {
			System.out.println("��ӡStudentsDAOImpl���û�ҵ���߼��ӿ��еĸ������Ϸ�����Ӧ��ʵ�������쳣��");
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
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction tx =null;
		//String hql="";
		try {
			
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---��������ɹ���");
			//session.get()ֻ��ͨ����������ѯ
			Students s = (Students) session.get(Students.class,sid);
			session.delete(s);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			System.out.println("��ӡStudentsDAOImpl���û�ҵ���߼��ӿ��е�ɾ��������Ӧ��ʵ�������쳣��");
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
	
	private String getNewSid(){
		Transaction tx =null;
		String hql="";
		String sid="";
		
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			System.out.println("StudentsDAOImpl---��ȡsession�Ự�ɹ���");
			// ��������
			tx = session.beginTransaction();
			System.out.println("StudentsDAOImpl---��������ɹ���");
			hql="select max(sid) from Students";
		    Query query = session.createQuery(hql);
		    sid= (String) query.uniqueResult();//�÷������ص���object���ͣ���Ҫ����ת��
		    if (sid==null||"".equals(sid)) {
				//���Ϊ�գ���һ��Ĭ�ϵı��
		    	sid="S00000001";
			}else {
				
				//����ȡ���沿��ת��Ϊ���֣�����S0000005,ȡ���ֲ��ֱ�Ϊ5
				String temp = sid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				//�ٻ�ԭ���ַ�����'5'
				temp=String.valueOf(i);
				int len = temp.length();
				
				//�ճ���λ
				for (int j = 0; j <7-len; j++) {
					temp = "0"+temp;
				}
				sid="S"+temp;
				
			}
		    tx.commit();
		    return sid;
			
		}catch (Exception e) {
			System.out.println("��ӡStudentsDAOImpl���û�ҵ���߼��ӿ��еĻ�ȡ����Ŷ�Ӧ��ʵ�������쳣��");
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
