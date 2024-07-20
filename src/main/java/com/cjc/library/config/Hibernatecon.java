package com.cjc.library.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.cjc.library.model.Book;
import com.cjc.library.model.Student;





public class Hibernatecon {
	private static SessionFactory factory;
	public static SessionFactory getSessionFactory()
	{
		if(factory==null)
		{
			Map<String,Object>settings=new HashMap<String,Object>();
			
			settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL,"jdbc:mysql://localhost:3306/cjc");
			settings.put(Environment.USER,"root");
			settings.put(Environment.PASS,"123456");
			settings.put(Environment.HBM2DDL_AUTO,"update");
			settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.SHOW_SQL,false);
			settings.put(Environment.FORMAT_SQL,true);
			
			
		StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(settings).build();
		MetadataSources mds =new MetadataSources(registry);
		mds.addAnnotatedClass(Student.class);
		mds.addAnnotatedClass(Book.class);
		Metadata md=mds.getMetadataBuilder().build();
		factory=md.getSessionFactoryBuilder().build();
		
		return factory;
	
		}
		return factory;
	}
}
