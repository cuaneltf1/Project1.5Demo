package com.fdesign.models;

public class Q {
	private int user_id;
	private int quiz_id;
	private int question_id;
	
	public Q() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Q(int user_id, int quiz_id, int question_id) {
		super();
		this.user_id = user_id;
		this.quiz_id = quiz_id;
		this.question_id = question_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + question_id;
		result = prime * result + quiz_id;
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Q other = (Q) obj;
		if (question_id != other.question_id)
			return false;
		if (quiz_id != other.quiz_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Q [user_id=" + user_id + ", quiz_id=" + quiz_id + ", question_id=" + question_id + "]";
	}
	
}
