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
		 * ◎第一步.---->获取Sessionfactory对象 Sessionfactory sf=new
		 * Configuration().configure().buildSessionFactory();
		 * ◎第二步.---->创建session对象 Session session=sf.openSession();
		 * ◎第三步.---->获取对数据库操作前的事物对象 Transaction tx=session.beginTransaction();
		 * ◎第四步
		 * .---->利用session的多个方法进行数据操作.例如:session.save(实体bean对象);session.update
		 * (实体bean对象)等; ◎第五步.---->tx.commit();保存持久化数据库操作; ◎ 数据其他操作.比如查询 Query
		 * query
		 * =session.createQuery("from student where username='"+username"'")
		 * ;//student为一个实体bean对象.就是与hbm.xml对应的和数据库映射的一个 javabean.
		 */

		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建sessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// 创建session对象
		Session session = sessionFactory.getCurrentSession();
		// 创建schemaExport对象
		SchemaExport export = new SchemaExport(config);
		// 生成表结构
		export.create(true, true);

	}
	
	@Test
	// 添加测试数据
	public void testSaveEmployeeTaxi() {

		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建sessionFactory
		SessionFactory sessionFactory = config
				.buildSessionFactory(serviceRegistry);
		// 创建session对象
		Session session = sessionFactory.getCurrentSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//先将事务放入缓存中，再一起提交
		System.out.println("开始将事务存入缓存！");
		EmployeeTaxi e1 = new EmployeeTaxi("001","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e2 = new EmployeeTaxi("002","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e3 = new EmployeeTaxi("003","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e4 = new EmployeeTaxi("004","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e5 = new EmployeeTaxi("005","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e6 = new EmployeeTaxi("006","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e7 = new EmployeeTaxi("007","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e8 = new EmployeeTaxi("008","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e9 = new EmployeeTaxi("009","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e10 = new EmployeeTaxi("010","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e11 = new EmployeeTaxi("011","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e12 = new EmployeeTaxi("012","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e13 = new EmployeeTaxi("013","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e14 = new EmployeeTaxi("014","75264","张三",new Date(),"新街口","45");
		EmployeeTaxi e15 = new EmployeeTaxi("015","75264","张三",new Date(),"新街口","45");
		
		//保存出差对象
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
		
		//提交事务
		tx.commit();
		sessionFactory.close();
	}

}
