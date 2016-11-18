package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {

	/*
	 * SessionFactory (org.hibernate.SessionFactory)
	 * 包含已经编译的映射(mappings)，是制造session的工厂，可能含有一些可以在各个事务(transaction)之间共享的数据
	 * (1)SessionFactory的缓存 可分为两类：内置缓存和外置缓存。
	 * SessionFactory的内置缓存中存放了Hibernate配置信息和映射元数据信息、同时也缓存了Hibernate自动生成的SQL语句等；
	 * SessionFactory的外置缓存是一个可配置的缓存插件，在默认情况下，SessionFactory不会启用这个缓存插件。外置缓存
	 * 能存放大量数据库数据的拷贝，外置缓存的物理介质可以是内存或者硬盘。 (2) 只有一个数据存储源，只需创建一个SessionFactory
	 * SessionFactory就是个重量级对象，如果应用只有一个数据存储源，只需创建一个SessionFactory实例，
	 * 因为随意地创建SessionFactory实例会占用大量内存空间。
	 * 但是当你的项目要操作多个数据库时，那你必须为每个数据库指定一个SessionFactory。 (3) Configuration的其他用法
	 * Configuration的configure
	 * ()方法还支持带参数的访问方式，你可以指定hbm.xml文件的位置，而不是使用默认的classpath
	 * 下面的hibernate.cfg.xml这种方式，例如： Configuration cfg = new
	 * Configuration().configure("myexample.xml");
	 */

	private static SessionFactory sessionFactory;// 会话工厂属性,是用来制造session的工厂，而session是用来存储用户信息的

	// 构造方法私有化，保证单例模式。单例模式确保一个类只有一个实例，自行提供
	// 这个实例并向整个系统提供这个实例
	private MyHibernateSessionFactory() {

	}

	// 公有的静态方法，获得会话工厂对象
	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			// 创建配置对象

			/*
			 * ★★→→Configuration
			 * Configuration是hibernate的入口，在新建一个Configuration的实例的时候
			 * ，hibernate会在classpath里面查找 hibernate.properties文件，如果该文件存在，
			 * 则将该文件的内容加载到一个Properties的实例GLOBAL_PROPERTIES里面
			 * ，如果不存在，将打印信息：hibernate.properties not found
			 * 然后是将所有系统环境变量（System.getProperties
			 * ()）也添加到GLOBAL_PROPERTIES里面。如果hibernate
			 * .properties文件存在，系统还会验证一下这个文件配置的有效性，对于一些已经不支持的配置参数，系统将打印警告信息。 (1)
			 * 作用---实现对Hibernate进行配置 ?
			 * Configuration接口的作用是对Hibernate进行配置，以及对它进行启动
			 * 在Hibernate的启动过程中，Configuration类的实例首先定位映射文档的位置
			 * ，读取这些配置，然后创建一个SessionFactory对象。 ?
			 * 根据Configuration对象创建一个SessionFactory对象
			 * 为了能创建一个SessionFactory对象，你必须在Hibernate初始化时创建一个Configuration类的实例
			 * ，并将已写好的映射文件交由它处理。
			 * 这样，Configuration对象就可以创建一个SessionFactory对象，当SessionFactory对象创建成功后
			 * ，Configuration对象就没有用了，你可以简单地抛弃它。 (2) 它是启动hibernate的对象
			 * 虽然Configuration接口在整个Hibernate项目中只扮演着一个很小的角色
			 * ，但它是启动hibernate时你所遇到的第一个对象。 (3) Configuration config = new
			 * Configuration(); config.addClass(Customer.class); sessionFactory
			 * = config.buildSessionFactory(); 或者： 使用方法链编程风格，可以改写为：
			 * sessionFactory = new
			 * Configuration().buildSessionFactory().addClass
			 * (Customer.class).buildSessionFactory(); 注意：
			 * 方法链编程风格能使应用程序代码更加简捷。在使用这种编程风格时
			 * ，最好把每个调用方法放在不同的行，否则在跟踪程序时，无法跳入每个调用方法中。
			 */
			Configuration config = new Configuration().configure();
			// 创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(config.getProperties())
					.buildServiceRegistry();
			// 创建sessionFactory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			return sessionFactory;

		} else {
			return sessionFactory;
		}

	}

}
