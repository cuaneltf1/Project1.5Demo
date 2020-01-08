package com.fdesign.daos;

import java.util.List;

import com.fdesign.models.QA;
import com.fdesign.models.QtoU;
import com.fdesign.models.Questions;
import com.fdesign.models.Quizzes;
import com.fdesign.models.QutoQ;

public interface QuizzesDao {
	
	QuizzesDao currrentImplementation = new QuizzesDaoSQL();
	
	int createNewQuiz(Quizzes q); // Works Implemented
	
	int createNewQuWithAns(QA qa); // Works Implemented
	
	Quizzes AssignQuestionsToQuiz(int quiz_id, int question_id); // Works
	
	Quizzes AssignQuizToUser(int user_id, int quiz_id); // Works
	
	void updateQuizResults(double results_grade, int user_id, int quiz_id); // Works doPut Implemented 
	
	List<Quizzes> retrieveAllQuizzes(); // Works doGet Implemented
	
	List<Questions> retrieveAllQuestions(); // Works doGet Implemented
	
	List<QtoU> retrieveAllQuizzesAssignedToUser(int user_id); // Works doGet Implemented
	
	List<QtoU> retrieveAllQuizzesAssignedToUsers();
	
	List<QutoQ> retrieveAllQuestsAssignedtoQuiz(int quiz_id); // Works doGet Implemented
	
	List<QutoQ> retrieveAllQuestsAssignedtoQuizzes(); // Works doGet Implemented

}
