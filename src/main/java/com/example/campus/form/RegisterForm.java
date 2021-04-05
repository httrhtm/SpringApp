package com.example.campus.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterForm {

	@NotBlank(message = "問題を入力してください")
	@Size(max = 500, message="問題は500文字以内で入力してください")
	private String question;

	@NotBlank(message = "答えを入力してください")
	@Size(max = 200, message="答えは200文字以内で入力してください")
	private String answer;

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}


}
