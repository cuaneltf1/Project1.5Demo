package com.fdesign.models;

public class Quizzes {
	
	private int quiz_id;
	private String quiz_title;
	private String quiz_description;
	
	public Quizzes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quizzes(int quiz_id, String quiz_title, String quiz_description) {
		super();
		this.quiz_id = quiz_id;
		this.quiz_title = quiz_title;
		this.quiz_description = quiz_description;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getQuiz_title() {
		return quiz_title;
	}
	public void setQuiz_title(String quiz_title) {
		this.quiz_title = quiz_title;
	}
	public String getQuiz_description() {
		return quiz_description;
	}
	public void setQuiz_description(String quiz_description) {
		this.quiz_description = quiz_description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quiz_description == null) ? 0 : quiz_description.hashCode());
		result = prime * result + quiz_id;
		result = prime * result + ((quiz_title == null) ? 0 : quiz_title.hashCode());
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
		Quizzes other = (Quizzes) obj;
		if (quiz_description == null) {
			if (other.quiz_description != null)
				return false;
		} else if (!quiz_description.equals(other.quiz_description))
			return false;
		if (quiz_id != other.quiz_id)
			return false;
		if (quiz_title == null) {
			if (other.quiz_title != null)
				return false;
		} else if (!quiz_title.equals(other.quiz_title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Quizzes [quiz_id=" + quiz_id + ", quiz_title=" + quiz_title + ", quiz_description=" + quiz_description
				+ "]";
	}

}
