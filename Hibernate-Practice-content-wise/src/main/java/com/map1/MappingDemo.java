package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		// Create a configuration object
		Configuration configuration = new Configuration();
		
		// Load the Hibernate Configuration file
		configuration.configure("hibernate.cfg.xml");
		
		// Create Session Factory object
		SessionFactory factory = configuration.buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEmpid(34);
		e1.setName("Ram");
		
		e2.setEmpid(35);
		e2.setName("Shyam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(1241);
		p1.setProject("Libarary Management system");
		
		p2.setPid(1254);
		p2.setProject("Chat Bot");
		
		List<Emp> list1 = new ArrayList<>();
		List<Project> list2 = new ArrayList<>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		//
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		
		transaction.commit();
		session.close();
		factory.close();
	}

}
