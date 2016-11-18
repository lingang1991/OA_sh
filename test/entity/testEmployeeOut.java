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

public class testEmployeeOut {

	
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
		EmployeeOut e1 = new EmployeeOut("001","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e2 = new EmployeeOut("002","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e3 = new EmployeeOut("003","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e4 = new EmployeeOut("004","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e5 = new EmployeeOut("005","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e6 = new EmployeeOut("006","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e7 = new EmployeeOut("007","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e8 = new EmployeeOut("008","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e9 = new EmployeeOut("009","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e10 = new EmployeeOut("010","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e11 = new EmployeeOut("011","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e12 = new EmployeeOut("012","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e13 = new EmployeeOut("013","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e14 = new EmployeeOut("014","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e15 = new EmployeeOut("015","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		
		EmployeeOut e16 = new EmployeeOut("016","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e17 = new EmployeeOut("017","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e18 = new EmployeeOut("018","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e19 = new EmployeeOut("019","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e20 = new EmployeeOut("020","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e21 = new EmployeeOut("021","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e22 = new EmployeeOut("022","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e23 = new EmployeeOut("023","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e24 = new EmployeeOut("024","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e25 = new EmployeeOut("025","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e26 = new EmployeeOut("026","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e27 = new EmployeeOut("027","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e28 = new EmployeeOut("028","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e29 = new EmployeeOut("029","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
		EmployeeOut e30 = new EmployeeOut("030","75264","����","����",new Date(),new Date(),"7","1","�豸ά��");
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
		session.save(e16);
		session.save(e17);
		session.save(e18);
		session.save(e19);
		session.save(e20);
		session.save(e21);
		session.save(e22);
		session.save(e23);
		session.save(e24);
		session.save(e25);
		session.save(e26);
		session.save(e27);
		session.save(e28);
		session.save(e29);
		session.save(e30);
		//�ύ����
		tx.commit();
		sessionFactory.close();
	}

}
