package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "Question_Id")
	private int questionId;
	private String question;
	@OneToMany(mappedBy = "question",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Answere> answere;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answere> getAnswere() {
		return answere;
	}
	public void setAnswere(List<Answere> answere) { 
		this.answere = answere;
	}
	public Question(int questionId, String question, List<Answere> answere) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answere = answere;
	}
	

}