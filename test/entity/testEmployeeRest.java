package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class testEmployeeRest {

	
	public void testSchemaExport() {

		/*
		 * ���һ��.---->��ȡSessionfactory���� Sessionfactory sf=new
		 * Configuration().configure().buildSessionFactory();
		 * ��ڶ���.---->����session���� Session session=sf.openSession();
		 * �������.---->��ȡ�����ݿ����ǰ��������� Transaction tx=session.beginTransaction();
		 * ����Ĳ�
		 * .---->����session�Ķ�������������ݲ���.����:session.save(ʵ��bean����);session.update
		 * (ʵ��bean����)��; ����岽.---->tx.commit();����־û����ݿ����; �� ������������.�����ѯ Query
		 * query
		 * =session.createQuery("from student where username='"+username"'")
		 * ;//studentΪһ��ʵ��bean����.������hbm.xml��Ӧ�ĺ����ݿ�ӳ���һ�� javabean.
		 */

		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// ����sessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// ����session����
		Session session = sessionFactory.getCurrentSession();
		// ����schemaExport����
		SchemaExport export = new SchemaExport(config);
		// ���ɱ�ṹ
		export.create(true, true);

	}
	
	@Test
	// ��Ӳ�������
	public void testSaveEmployeeOut() {

		// �������ö���
		Configuration config = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// ����sessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// ����session����
		Session session = sessionFactory.getCurrentSession();
		//��������
		Transaction tx = session.beginTransaction();
		//�Ƚ�������뻺���У���һ���ύ
		EmployeeRest e1 = new EmployeeRest("1","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e2 = new EmployeeRest("2","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e3 = new EmployeeRest("3","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e4 = new EmployeeRest("4","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e5 = new EmployeeRest("5","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e6 = new EmployeeRest("6","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e7 = new EmployeeRest("7","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e8 = new EmployeeRest("8","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e9 = new EmployeeRest("9","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e10 = new EmployeeRest("10","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e11 = new EmployeeRest("11","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e12 = new EmployeeRest("12","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e13 = new EmployeeRest("13","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e14 = new EmployeeRest("14","75264","����",new Date(),"8:30-11:30","3","����������","10");
		EmployeeRest e15 = new EmployeeRest("15","75264","����",new Date(),"8:30-11:30","3","����������","10");
		
		//����������
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		session.save(e6);
		session.save(e7);
		session.save(e8);
		session.save(e9);
		session.save(e10);
		session.save(e11);
		session.save(e12);
		session.save(e13);
		session.save(e14);
		session.save(e15);
		
		//�ύ����
		tx.commit();
		sessionFactory.close();
	}

}
