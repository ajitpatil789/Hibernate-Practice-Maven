package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		// Create a configuration object
		Configuration configuration = new Configuration();

		// Load the Hibernate configuration file
		configuration.configure("hibernate.cfg.xml");

		// Create a SessionFactory object
		SessionFactory factory = configuration.buildSessionFactory();

		// 1st Student Details
		Student student = new Student();
		student.setId(1000);
		student.setName("Ajit Patil");
		student.setCity("Banglore");

		certificate certificate = new certificate();
		certificate.setCourse("Hibernate");
		certificate.setDuration("1 month");
		student.setCerti(certificate);

		// 2st Student Details
		Student student1 = new Student();
		student1.setId(2000);
		student1.setName("Vihaan Patil");
		student1.setCity("Kolhapur");

		certificate certificate1 = new certificate();
		certificate1.setCourse("Spring");
		certificate1.setDuration("2 month");
		student1.setCerti(certificate1);

		// 3st Student Details
		Student student2 = new Student();
		student2.setId(2011);
		student2.setName("Sneha");
		student2.setCity("Vakare");

		certificate certificate2 = new certificate();
		certificate2.setCourse("Java");
		certificate2.setDuration("3 month");
		student2.setCerti(certificate2);

		// 4st Student Details
		Student student3 = new Student();
		student3.setId(2021);
		student3.setName("Roman");
		student3.setCity("Amashi");

		certificate certificate3 = new certificate();
		certificate3.setCourse("Kafaka");
		certificate3.setDuration("3 month");
		student3.setCerti(certificate3);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// objects save
		session.save(student);
		session.save(student1);
		session.save(student2);
		session.save(student3);

		transaction.commit();
		session.close();
		factory.close();

	}

}
