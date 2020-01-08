package com.fdesign.driver;

import com.fdesign.daos.QuizzesDao;
import com.fdesign.daos.UserDao;
import com.fdesign.models.Questions;
import com.fdesign.models.Quizzes;

public class TestDriver {
	
	public static void main(String[] args) {
		
		UserDao userDao = UserDao.currentImplementation;
		
		QuizzesDao quizzesDao = QuizzesDao.currrentImplementation;
		
		System.out.println("Behold, a man");
		
		quizzesDao.retrieveAllQuizzesAssignedToUsers().forEach(qtou -> {
			System.out.println(qtou);
		});
		
//		quizzesDao.updateQuizResults(93.35, 101, 1); //Works
//		
//		quizzesDao.retrieveAllQuestsAssignedtoQuiz(1).forEach(qu ->{
//			System.out.println(qu);
//		});
		
//		System.out.println(quizzesDao.AssignQuizToUser(101, 23)); //Works
		
//		System.out.println(quizzesDao.AssignQuestionsToQuiz(1, 21)); //Works
		
//		Questions qu = new Questions(7, "How am I supposed to do", "The only thing", "Ill ever know", "I hope you do", "Turn into you");
//		System.out.println(quizzesDao.createNewQuWithAns(qu, "Turn into you")); //Works
		
//		Quizzes q = new Quizzes(42, "Project Basics", "Testing limits and exceeding boundries on what projects should be");
//		System.out.println(quizzesDao.createNewQuiz("A Test for Quiz Id S", "I hope they pass it")); //Works 
		//except for the sequence
		
		//with creating a new quiz object but id starts at 21, strange
		
//		System.out.println(userDao.findRegularUsers()); //Works
		
//		System.out.println(userDao.loginAuthentication("fcuanelt", "pass")); //Works
		
//		System.out.println(quizzesDao.retrieveAllQuizzes()); //Works
//		quizzesDao.retrieveAllQuizzes().forEach(quiz ->{
//			System.out.println(quiz);
//		});
		
//		System.out.println(quizzesDao.retrieveAllQuestions()); //Works
////		quizzesDao.retrieveAllQuestions().forEach(question ->{
//			System.out.println(question);
//		}); //Works and prints out data in new line
		
//		quizzesDao.retrieveAllQuizzesAssignedToUser(101).forEach(qtou ->{
//			System.out.println(qtou); //Works
//		});
		
	}

}
