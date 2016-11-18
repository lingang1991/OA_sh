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
	public void testSaveEmployeeOut() {

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
		EmployeeOut e1 = new EmployeeOut("001","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e2 = new EmployeeOut("002","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e3 = new EmployeeOut("003","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e4 = new EmployeeOut("004","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e5 = new EmployeeOut("005","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e6 = new EmployeeOut("006","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e7 = new EmployeeOut("007","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e8 = new EmployeeOut("008","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e9 = new EmployeeOut("009","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e10 = new EmployeeOut("010","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e11 = new EmployeeOut("011","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e12 = new EmployeeOut("012","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e13 = new EmployeeOut("013","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e14 = new EmployeeOut("014","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e15 = new EmployeeOut("015","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		
		EmployeeOut e16 = new EmployeeOut("016","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e17 = new EmployeeOut("017","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e18 = new EmployeeOut("018","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e19 = new EmployeeOut("019","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e20 = new EmployeeOut("020","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e21 = new EmployeeOut("021","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e22 = new EmployeeOut("022","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e23 = new EmployeeOut("023","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e24 = new EmployeeOut("024","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e25 = new EmployeeOut("025","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e26 = new EmployeeOut("026","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e27 = new EmployeeOut("027","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e28 = new EmployeeOut("028","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e29 = new EmployeeOut("029","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
		EmployeeOut e30 = new EmployeeOut("030","75264","张三","北京",new Date(),new Date(),"7","1","设备维护");
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
		//提交事务
		tx.commit();
		sessionFactory.close();
	}

}
