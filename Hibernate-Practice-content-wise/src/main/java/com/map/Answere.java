package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answere {
	@Id
	@Column(name = "Answere_Id")
	private int answereId;
	private String answere;
	
	@ManyToOne
	private Question question;

	public int getAnswereId() {
		return answereId;
	}

	public void setAnswereId(int answereId) {
		this.answereId = answereId;
	}

	public String getAnswere() {
		return answere;
	}

	public void setAnswere(String answere) {
		this.answere = answere;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answere() {
		super();
		
	}

	public Answere(int answereId, String answere, Question question) {
		super();
		this.answereId = answereId;
		this.answere = answere;
		this.question = question;
	}

	

}
