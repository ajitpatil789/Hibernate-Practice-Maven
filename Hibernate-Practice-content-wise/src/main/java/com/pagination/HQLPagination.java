package com.pagination;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLPagination {
	public static void main(String[] args) {
		
		
		  Configuration configuration=new Configuration();
		  configuration.configure("hibernate.cfg.xml"); SessionFactory
		  factory=configuration.buildSessionFactory();
		 
		//SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session session =factory.openSession();
		Query query= session.createQuery("from Student"); 
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<Student>list= query.list();
		for(Student st:list) {
			System.out.println(st.getName()+" : "+st.getCity());
		}
		 
		
		
		session.close();
		factory.close();
	}

}
