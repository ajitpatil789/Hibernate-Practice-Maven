package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hibernate Project Started....." );
      //  SessionFactory factory = new Configuration().configure().buildSessionFactory();
     // Create a configuration object
        Configuration configuration = new Configuration();
        
     // Load the Hibernate configuration file
        configuration.configure("hibernate.cfg.xml");
        

     // Create a SessionFactory object
        SessionFactory factory = configuration.buildSessionFactory();
        
      
        
        //create object ofstudent
        Student student = new Student();
        student.setId(102);
        student.setName("Vihaan");
        student.setCity("Vakare");
        System.out.println(student);
        
        //Creating object of Address
        Address address = new Address();
        address.setStreet("Base Galli");
        address.setCity("Kolhapur"); 
        address.setOpen(true);
        address.setX(120.25);
        address.setAddedDate(new Date());
       
        // Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/JDK.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);
        
        
        
        
        Session session =factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        session.save(address);
        transaction.commit();
        fis.close();
        session.close();
        System.out.println("Done.........");
        
    }
}
