package com.fdesign.models;

public class QA {
	
	private String question_description;
	private String question_response_1;
	private String question_response_2;
	private String question_response_3;
	private String question_response_4;
	private String answer;
	
	public QA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QA(String question_description, String question_response_1, String question_response_2,
			String question_response_3, String question_response_4, String answer) {
		super();
		this.question_description = question_description;
		this.question_response_1 = question_response_1;
		this.question_response_2 = question_response_2;
		this.question_response_3 = question_response_3;
		this.question_response_4 = question_response_4;
		this.answer = answer;
	}

	public String getQuestion_description() {
		return question_description;
	}

	public void setQuestion_description(String question_description) {
		this.question_description = question_description;
	}

	public String getQuestion_response_1() {
		return question_response_1;
	}

	public void setQuestion_response_1(String question_response_1) {
		this.question_response_1 = question_response_1;
	}

	public String getQuestion_response_2() {
		return question_response_2;
	}

	public void setQuestion_response_2(String question_response_2) {
		this.question_response_2 = question_response_2;
	}

	public String getQuestion_response_3() {
		return question_response_3;
	}

	public void setQuestion_response_3(String question_response_3) {
		this.question_response_3 = question_response_3;
	}

	public String getQuestion_response_4() {
		return question_response_4;
	}

	public void setQuestion_response_4(String question_response_4) {
		this.question_response_4 = question_response_4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((question_description == null) ? 0 : question_description.hashCode());
		result = prime * result + ((question_response_1 == null) ? 0 : question_response_1.hashCode());
		result = prime * result + ((question_response_2 == null) ? 0 : question_response_2.hashCode());
		result = prime * result + ((question_response_3 == null) ? 0 : question_response_3.hashCode());
		result = prime * result + ((question_response_4 == null) ? 0 : question_response_4.hashCode());
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
		QA other = (QA) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (question_description == null) {
			if (other.question_description != null)
				return false;
		} else if (!question_description.equals(other.question_description))
			return false;
		if (question_response_1 == null) {
			if (other.question_response_1 != null)
				return false;
		} else if (!question_response_1.equals(other.question_response_1))
			return false;
		if (question_response_2 == null) {
			if (other.question_response_2 != null)
				return false;
		} else if (!question_response_2.equals(other.question_response_2))
			return false;
		if (question_response_3 == null) {
			if (other.question_response_3 != null)
				return false;
		} else if (!question_response_3.equals(other.question_response_3))
			return false;
		if (question_response_4 == null) {
			if (other.question_response_4 != null)
				return false;
		} else if (!question_response_4.equals(other.question_response_4))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QA [question_description=" + question_description + ", question_response_1=" + question_response_1
				+ ", question_response_2=" + question_response_2 + ", question_response_3=" + question_response_3
				+ ", question_response_4=" + question_response_4 + ", answer=" + answer + "]";
	}
	
}
