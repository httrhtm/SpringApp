package com.example.campus.entity;

//entityクラス
public class Answer {

	private int id;
	private int questions_id;
	private String answer;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestions_id() {
		return questions_id;
	}
	public void setQuestions_id(int questions_id) {
		this.questions_id = questions_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}



}
