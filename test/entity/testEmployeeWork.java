package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class testEmployeeWork {

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
		@SuppressWarnings("unused")
		Session session = sessionFactory.getCurrentSession();
		// 创建schemaExport对象
		SchemaExport export = new SchemaExport(config);
		// 生成表结构
		export.create(true, true);

	}
	
	
	// 添加测试数据
	public void testSaveEmployeeWork() {

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
//		EmployeeWork e1 = new EmployeeWork("001","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e2 = new EmployeeWork("002","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e3 = new EmployeeWork("003","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e4 = new EmployeeWork("004","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e5 = new EmployeeWork("005","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e6 = new EmployeeWork("006","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e7 = new EmployeeWork("007","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e8 = new EmployeeWork("008","69019","门秀丽",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		
//		EmployeeWork e9 = new EmployeeWork("009","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e10= new EmployeeWork("010","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e11 = new EmployeeWork("011","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e12 = new EmployeeWork("012","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e13 = new EmployeeWork("013","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e14 = new EmployeeWork("014","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e15 = new EmployeeWork("015","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e16 = new EmployeeWork("016","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e17 = new EmployeeWork("017","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e18 = new EmployeeWork("018","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e19= new EmployeeWork("019","71707","马国强",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e20 = new EmployeeWork("020","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e21 = new EmployeeWork("021","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e22 = new EmployeeWork("022","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e23 = new EmployeeWork("023","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e24 = new EmployeeWork("024","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e25 = new EmployeeWork("025","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e26 = new EmployeeWork("026","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e27 = new EmployeeWork("027","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e28 = new EmployeeWork("028","75489","张成",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e29 = new EmployeeWork("029","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e30 = new EmployeeWork("030","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e31= new EmployeeWork("031","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e32 = new EmployeeWork("032","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e33 = new EmployeeWork("033","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e34 = new EmployeeWork("034","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e35 = new EmployeeWork("035","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e36 = new EmployeeWork("036","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e37= new EmployeeWork("037","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e38 = new EmployeeWork("038","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e39 = new EmployeeWork("039","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e40 = new EmployeeWork("040","73360","朱新飞",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e41 = new EmployeeWork("041","68663","张靖南",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e42 = new EmployeeWork("042","68663","张靖南",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e43 = new EmployeeWork("043","68663","张靖南",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e44 = new EmployeeWork("044","68663","张靖南",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e45 = new EmployeeWork("045","68663","张靖南",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e46 = new EmployeeWork("046","68663","张靖南",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e47 = new EmployeeWork("047","68663","张靖南",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e48 = new EmployeeWork("048","73876","王乐",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e49 = new EmployeeWork("049","73876","王乐",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e50 = new EmployeeWork("050","73876","王乐",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e51 = new EmployeeWork("051","73876","王乐",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e52 = new EmployeeWork("052","73876","王乐",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		
//		EmployeeWork e53 = new EmployeeWork("053","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e54 = new EmployeeWork("054","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e55 = new EmployeeWork("055","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e56 = new EmployeeWork("056","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e57 = new EmployeeWork("057","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e58 = new EmployeeWork("058","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e59 = new EmployeeWork("059","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e60 = new EmployeeWork("060","75507","邵家松",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e61 = new EmployeeWork("061","75412","吴莉莉",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e62 = new EmployeeWork("062","75412","吴莉莉",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e63 = new EmployeeWork("063","75412","吴莉莉",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e64 = new EmployeeWork("064","75412","吴莉莉",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e65 = new EmployeeWork("065","75412","吴莉莉",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		
//		EmployeeWork e66 = new EmployeeWork("066","75413","徐业鑫",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e67 = new EmployeeWork("067","75413","徐业鑫",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e68 = new EmployeeWork("068","75413","徐业鑫",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e69 = new EmployeeWork("069","75413","徐业鑫",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e70 = new EmployeeWork("070","75413","徐业鑫",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e71 = new EmployeeWork("071","75413","徐业鑫",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e72= new EmployeeWork("072","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e73 = new EmployeeWork("073","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e74 = new EmployeeWork("074","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e75 = new EmployeeWork("075","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e76 = new EmployeeWork("076","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e77 = new EmployeeWork("077","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e78 = new EmployeeWork("078","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e79 = new EmployeeWork("079","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e80 = new EmployeeWork("080","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e81 = new EmployeeWork("081","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e82 = new EmployeeWork("082","69449","胡维达",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		
//		
//		EmployeeWork e83= new EmployeeWork("083","73263","李韧",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e84= new EmployeeWork("084","75264","林钢",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e85= new EmployeeWork("085","75264","林钢",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e86= new EmployeeWork("086","72829","王书同",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e87= new EmployeeWork("087","72829","王书同",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e88= new EmployeeWork("088","72829","王书同",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e89= new EmployeeWork("089","75513","张婷",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e90= new EmployeeWork("090","75513","张婷",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e91= new EmployeeWork("091","75513","张婷",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e92= new EmployeeWork("092","64715","朱健",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e93= new EmployeeWork("093","64715","朱健",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e94= new EmployeeWork("094","64715","朱健",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e95= new EmployeeWork("095","64715","朱健",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e96= new EmployeeWork("096","64715","朱健",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e97= new EmployeeWork("097","64715","朱健",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e98= new EmployeeWork("098","64715","朱健",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e99= new EmployeeWork("099","72475","徐雯",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e100= new EmployeeWork("100","72475","徐雯",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e101= new EmployeeWork("101","70990","张存存",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e102= new EmployeeWork("102","70990","张存存",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e103= new EmployeeWork("103","70990","张存存",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e104= new EmployeeWork("104","70990","张存存",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e105= new EmployeeWork("105","70990","张存存",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		EmployeeWork e106= new EmployeeWork("106","75599","高雅",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e107= new EmployeeWork("107","75599","高雅",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e108= new EmployeeWork("108","75599","高雅",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e109= new EmployeeWork("109","75599","高雅",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e110= new EmployeeWork("110","75599","高雅",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e111= new EmployeeWork("111","75599","高雅",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		EmployeeWork e112= new EmployeeWork("112","75599","高雅",new Date(),"18:30-21:00","2.5","南京","公司","平台开发");
//		
//		
//		
//		
//		
//	session.save(e1);
//		session.save(e2);
//		session.save(e3);
//		session.save(e4);
//		session.save(e5);
//		session.save(e6);
//		session.save(e7);
//		session.save(e8);
//		session.save(e9);
//		session.save(e10);
//		session.save(e11);
//		session.save(e12);
//		session.save(e13);
//		session.save(e14);
//		session.save(e15);
//		session.save(e16);
//		session.save(e17);
//		session.save(e18);
//		session.save(e19);
//		session.save(e20);
//		session.save(e21);
//		session.save(e22);
//		session.save(e23);
//		session.save(e24);
//		session.save(e25);
//		session.save(e26);
//		session.save(e27);
//		session.save(e28);
//		session.save(e29);
//		session.save(e30);
//		session.save(e31);
//		session.save(e32);
//		session.save(e33);
//		session.save(e34);
//		session.save(e35);
//		session.save(e36);
//		session.save(e37);
//		session.save(e38);
//		session.save(e39);
//		session.save(e40);
//		session.save(e41);
//		session.save(e42);
//		session.save(e43);
//		session.save(e44);
//		session.save(e45);
//		session.save(e46);
//		session.save(e47);
//		session.save(e48);
//		session.save(e49);
//		session.save(e50);
//		session.save(e51);
//		session.save(e52);
//		session.save(e53);
//		session.save(e54);
//		session.save(e55);
//		session.save(e56);
//		session.save(e57);
//		session.save(e58);
//		session.save(e59);
//		session.save(e60);
//		session.save(e61);
//		session.save(e62);
//		session.save(e63);
//		session.save(e64);
//		session.save(e65);
//		session.save(e66);
//		session.save(e67);
//		session.save(e68);
//		session.save(e69);
//		session.save(e70);
//		session.save(e71);
//		session.save(e72);
//		session.save(e73);
//		session.save(e74);
//		session.save(e75);
//		session.save(e76);
//		session.save(e77);
//		session.save(e78);
//		session.save(e79);
//		session.save(e80);
//		session.save(e81);
//		session.save(e82);
//		session.save(e83);
//		session.save(e84);
//		session.save(e85);
//		session.save(e86);
//		session.save(e87);
//		session.save(e88);
//		session.save(e89);
//		session.save(e90);
//		session.save(e91);
//		session.save(e92);
//		session.save(e93);
//		session.save(e94);
//		session.save(e95);
//		session.save(e96);
//		session.save(e97);
//		session.save(e98);
//		session.save(e99);
//		session.save(e100);
//		session.save(e101);
//		session.save(e102);
//		session.save(e103);
//		session.save(e104);
//		session.save(e105);
//		session.save(e106);
//		session.save(e107);
//		session.save(e108);
//		session.save(e109);
//		session.save(e110);
//		session.save(e111);
//		session.save(e112);
//		
		//提交事务
		tx.commit();
		sessionFactory.close();
	}

}
