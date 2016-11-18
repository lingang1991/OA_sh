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

public class testEmployeeSupply {

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
EmployeeSupply e1 = new EmployeeSupply("001",300,10,1,"��","64715��68663��73360��69019��71707��73471��69449��73389��72829��73263","�콡���ž��ϡ����·ɡ������������ǿ������贡���ά�ðΰΰ������ͬ������",new Date(),"��","��Ʒ�з��Ӱ�");
		
		
		//����������
	session.save(e1);
		
		//�ύ����
		tx.commit();
		sessionFactory.close();
	}
}
