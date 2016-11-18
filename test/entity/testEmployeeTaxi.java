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

public class testEmployeeTaxi {

	
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
	public void testSaveEmployeeTaxi() {

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
		System.out.println("��ʼ��������뻺�棡");
		EmployeeTaxi e1 = new EmployeeTaxi("001","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e2 = new EmployeeTaxi("002","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e3 = new EmployeeTaxi("003","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e4 = new EmployeeTaxi("004","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e5 = new EmployeeTaxi("005","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e6 = new EmployeeTaxi("006","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e7 = new EmployeeTaxi("007","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e8 = new EmployeeTaxi("008","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e9 = new EmployeeTaxi("009","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e10 = new EmployeeTaxi("010","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e11 = new EmployeeTaxi("011","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e12 = new EmployeeTaxi("012","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e13 = new EmployeeTaxi("013","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e14 = new EmployeeTaxi("014","75264","����",new Date(),"�½ֿ�","45");
		EmployeeTaxi e15 = new EmployeeTaxi("015","75264","����",new Date(),"�½ֿ�","45");
		
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
