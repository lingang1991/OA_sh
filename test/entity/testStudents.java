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
	
	// 添加测试数据
	public void testSaveStudents() {

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
		Students s1 = new Students("12150124", "张三", "男", new Date(), "三牌楼1");
		Students s2 = new Students("12150125", "李四", "男", new Date(), "三牌楼2");
		Students s3 = new Students("12150126", "王五", "女", new Date(), "三牌楼3");
		Students s4 = new Students("12150127", "张三", "男", new Date(), "三牌楼1");
		Students s5 = new Students("12150128", "李四", "男", new Date(), "三牌楼2");
		Students s6 = new Students("12150129", "王五", "女", new Date(), "三牌楼3");
		Students s7 = new Students("12150130", "张三", "男", new Date(), "三牌楼1");
		Students s8 = new Students("12150131", "李四", "男", new Date(), "三牌楼2");
		Students s9 = new Students("12150132", "王五", "女", new Date(), "三牌楼3");
		Students s10 = new Students("12150133", "张三", "男", new Date(), "三牌楼1");
		Students s11 = new Students("12150134", "李四", "男", new Date(), "三牌楼2");
		Students s12 = new Students("12150135", "王五", "女", new Date(), "三牌楼3");
		//保存学生对象
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
		//提交事务
		tx.commit();
		sessionFactory.close();
	}

}
