package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {

	/*
	 * SessionFactory (org.hibernate.SessionFactory)
	 * �����Ѿ������ӳ��(mappings)��������session�Ĺ��������ܺ���һЩ�����ڸ�������(transaction)֮�乲�������
	 * (1)SessionFactory�Ļ��� �ɷ�Ϊ���ࣺ���û�������û��档
	 * SessionFactory�����û����д����Hibernate������Ϣ��ӳ��Ԫ������Ϣ��ͬʱҲ������Hibernate�Զ����ɵ�SQL���ȣ�
	 * SessionFactory�����û�����һ�������õĻ���������Ĭ������£�SessionFactory����������������������û���
	 * �ܴ�Ŵ������ݿ����ݵĿ��������û����������ʿ������ڴ����Ӳ�̡� (2) ֻ��һ�����ݴ洢Դ��ֻ�贴��һ��SessionFactory
	 * SessionFactory���Ǹ��������������Ӧ��ֻ��һ�����ݴ洢Դ��ֻ�贴��һ��SessionFactoryʵ����
	 * ��Ϊ����ش���SessionFactoryʵ����ռ�ô����ڴ�ռ䡣
	 * ���ǵ������ĿҪ����������ݿ�ʱ���������Ϊÿ�����ݿ�ָ��һ��SessionFactory�� (3) Configuration�������÷�
	 * Configuration��configure
	 * ()������֧�ִ������ķ��ʷ�ʽ�������ָ��hbm.xml�ļ���λ�ã�������ʹ��Ĭ�ϵ�classpath
	 * �����hibernate.cfg.xml���ַ�ʽ�����磺 Configuration cfg = new
	 * Configuration().configure("myexample.xml");
	 */

	private static SessionFactory sessionFactory;// �Ự��������,����������session�Ĺ�������session�������洢�û���Ϣ��

	// ���췽��˽�л�����֤����ģʽ������ģʽȷ��һ����ֻ��һ��ʵ���������ṩ
	// ���ʵ����������ϵͳ�ṩ���ʵ��
	private MyHibernateSessionFactory() {

	}

	// ���еľ�̬��������ûỰ��������
	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			// �������ö���

			/*
			 * ������Configuration
			 * Configuration��hibernate����ڣ����½�һ��Configuration��ʵ����ʱ��
			 * ��hibernate����classpath������� hibernate.properties�ļ���������ļ����ڣ�
			 * �򽫸��ļ������ݼ��ص�һ��Properties��ʵ��GLOBAL_PROPERTIES����
			 * ����������ڣ�����ӡ��Ϣ��hibernate.properties not found
			 * Ȼ���ǽ�����ϵͳ����������System.getProperties
			 * ()��Ҳ��ӵ�GLOBAL_PROPERTIES���档���hibernate
			 * .properties�ļ����ڣ�ϵͳ������֤һ������ļ����õ���Ч�ԣ�����һЩ�Ѿ���֧�ֵ����ò�����ϵͳ����ӡ������Ϣ�� (1)
			 * ����---ʵ�ֶ�Hibernate�������� ?
			 * Configuration�ӿڵ������Ƕ�Hibernate�������ã��Լ�������������
			 * ��Hibernate�����������У�Configuration���ʵ�����ȶ�λӳ���ĵ���λ��
			 * ����ȡ��Щ���ã�Ȼ�󴴽�һ��SessionFactory���� ?
			 * ����Configuration���󴴽�һ��SessionFactory����
			 * Ϊ���ܴ���һ��SessionFactory�����������Hibernate��ʼ��ʱ����һ��Configuration���ʵ��
			 * ��������д�õ�ӳ���ļ�����������
			 * ������Configuration����Ϳ��Դ���һ��SessionFactory���󣬵�SessionFactory���󴴽��ɹ���
			 * ��Configuration�����û�����ˣ�����Լ򵥵��������� (2) ��������hibernate�Ķ���
			 * ��ȻConfiguration�ӿ�������Hibernate��Ŀ��ֻ������һ����С�Ľ�ɫ
			 * ������������hibernateʱ���������ĵ�һ������ (3) Configuration config = new
			 * Configuration(); config.addClass(Customer.class); sessionFactory
			 * = config.buildSessionFactory(); ���ߣ� ʹ�÷�������̷�񣬿��Ը�дΪ��
			 * sessionFactory = new
			 * Configuration().buildSessionFactory().addClass
			 * (Customer.class).buildSessionFactory(); ע�⣺
			 * ��������̷����ʹӦ�ó��������Ӽ�ݡ���ʹ�����ֱ�̷��ʱ
			 * ����ð�ÿ�����÷������ڲ�ͬ���У������ڸ��ٳ���ʱ���޷�����ÿ�����÷����С�
			 */
			Configuration config = new Configuration().configure();
			// ��������ע�����
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(config.getProperties())
					.buildServiceRegistry();
			// ����sessionFactory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			return sessionFactory;

		} else {
			return sessionFactory;
		}

	}

}
