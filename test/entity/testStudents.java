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

public class testStudents {

	@Test
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
	
	// ��Ӳ�������
	public void testSaveStudents() {

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
		Students s1 = new Students("12150124", "����", "��", new Date(), "����¥1");
		Students s2 = new Students("12150125", "����", "��", new Date(), "����¥2");
		Students s3 = new Students("12150126", "����", "Ů", new Date(), "����¥3");
		Students s4 = new Students("12150127", "����", "��", new Date(), "����¥1");
		Students s5 = new Students("12150128", "����", "��", new Date(), "����¥2");
		Students s6 = new Students("12150129", "����", "Ů", new Date(), "����¥3");
		Students s7 = new Students("12150130", "����", "��", new Date(), "����¥1");
		Students s8 = new Students("12150131", "����", "��", new Date(), "����¥2");
		Students s9 = new Students("12150132", "����", "Ů", new Date(), "����¥3");
		Students s10 = new Students("12150133", "����", "��", new Date(), "����¥1");
		Students s11 = new Students("12150134", "����", "��", new Date(), "����¥2");
		Students s12 = new Students("12150135", "����", "Ů", new Date(), "����¥3");
		//����ѧ������
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		session.save(s7);
		session.save(s8);
		session.save(s9);
		session.save(s10);
		session.save(s11);
		session.save(s12);
		//�ύ����
		tx.commit();
		sessionFactory.close();
	}

}
