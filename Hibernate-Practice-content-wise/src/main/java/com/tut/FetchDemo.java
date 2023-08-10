package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// Create a configuration object
        Configuration configuration = new Configuration();
        
     // Load the Hibernate configuration file
        configuration.configure("hibernate.cfg.xml");
        

     // Create a SessionFactory object
        SessionFactory factory = configuration.buildSessionFactory();
        
     //Open a Session: Open a Session object using the SessionFactory object.
         Session session = factory.openSession();
         
     // get Student :102
         Student student = (Student) session.load(Student.class, 102);
         System.out.println(student);
         
     // Get Address :1
         Address address =(Address) session.get(Address.class, 1);
         System.out.println(address.getCity()+" : "+address.getStreet());
         
         session.close();
         factory.close();

	}

}
