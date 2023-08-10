package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// Create a configuration object
		Configuration configuration = new Configuration();
		// Load the Hibernate Configuration file
		configuration.configure("hibernate.cfg.xml");
		// Create Session Factory object
		SessionFactory factory = configuration.buildSessionFactory();

		 /* // create Question object 1

		Question question = new Question();
		question.setQuestionId(100);
		question.setQuestion("What is mean by Java");

		// create Answere object 1
		Answere answere = new Answere();
		answere.setAnswereId(200);
		answere.setAnswere("Java Is Programming Language");
		answere.setQuestion(question);

		// create answere object 2
		Answere answere1 = new Answere();
		answere1.setAnswereId(201);
		answere1.setAnswere("With the help of java we can create software");
		answere1.setQuestion(question);

		// create answere object 2
		Answere answere2 = new Answere();
		answere2.setAnswereId(202);
		answere2.setAnswere("Java is a secure language");
		answere2.setQuestion(question);

		// adding 3 Answeres into list
		List<Answere> list = new ArrayList<Answere>();
		list.add(answere);
		list.add(answere1);
		list.add(answere2);

		// ADDING ANSWERE LIST INTO QUESTION SO ONE QUESTIONS
		// CAN HAVE MANY ANSWERE
		question.setAnswere(list);  */

		// create session object to save object

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		/* // save
		session.save(question);
		session.save(answere);
		session.save(answere1);
		session.save(answere2); */

		Question q = (Question) session.get(Question.class, 100);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswere().size());
		
		
		/*
		System.out.println(q.getQuestion());
		for (Answere a : q.getAnswere()) {
			System.out.println(a.getAnswere());
		} */

		transaction.commit();
		/* // fetching..........
		Question newQ = (Question) session.load(Question.class, 100);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswere().getAnswere());  */

		session.close();
		factory.close();
	}

}
