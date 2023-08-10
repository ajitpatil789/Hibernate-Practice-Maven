package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;
import com.tut.certificate;

public class StatesDemo {

	public static void main(String[] args) {
		//Hibernate object states: Transient, persistant, Detached, Removed
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		//creating student object
		Student st = new Student();
		st.setId(10);
		st.setName("Roman");
		st.setCity("Banglore");
		st.setCerti(new certificate("Java Course","2 month"));
		// Transient state: Student 
		
		Session session = factory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		session.save(st);
		//Student: persistent state associated with session and database
		
		st.setName("John");
		 transaction.commit();
		st.setName("Sachin");
		//Student: Detached State
		System.out.println(st);
		 
		 
		 session.close();
		factory.close();

	}

}
