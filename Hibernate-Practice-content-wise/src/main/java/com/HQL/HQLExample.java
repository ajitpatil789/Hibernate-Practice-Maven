package com.HQL;

import java.util.List;

import org.hibernate.query.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		// HQL Query Sysntx

		String query = "from Student as s WHERE s.city=:x and s.name =:n"; // projection
		// String query = "from Student WHERE city='Banglore'";
		Query q = session.createQuery(query);
		q.setParameter("x", "Banglore");
		q.setParameter("n", "John");

		// expecting single result from query--unique
		// q.uniqueResult();
		// expecting multiple result from query
		List<Student> list = q.list();
		for (Student student : list) {
			System.out.println(student.getName() + " : " + student.getCity() + " : " + student.getCerti().getCourse());

		}

		session.close();
		factory.close();
	}

}
