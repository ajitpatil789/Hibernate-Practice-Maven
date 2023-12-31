package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, 1000);
		System.out.println(student);
		System.out.println("Working on something");
		
		Student student2 = session.get(Student.class, 1000);
		System.out.println(student2);
	
		session.close();
	}

}
