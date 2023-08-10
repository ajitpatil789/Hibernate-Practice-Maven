package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answere;
import com.map.Question;

public class Cascade {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Question q12 = new Question();
		q12.setQuestionId(501);
		q12.setQuestion("What is Swing frameqwork");
		Answere a12 = new Answere(509,"It is enity fraamework",q12);
		Answere a22 = new Answere(510,"Swing is important concept",q12);
		Answere a33 = new Answere(511,"It is very important concept of hibernate",q12);
		
		List<Answere> list = new ArrayList<Answere>();
		list.add(a12);
		list.add(a22);
		list.add(a33);
		
		q12.setAnswere(list);
		Transaction tx= s.beginTransaction();
		s.save(q12);
		
		
		tx.commit();
		factory.close();
		s.close();

	}

}
