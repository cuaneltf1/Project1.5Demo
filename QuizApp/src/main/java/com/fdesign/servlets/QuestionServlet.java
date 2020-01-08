package com.fdesign.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdesign.daos.QuizzesDao;
import com.fdesign.models.QA;
import com.fdesign.models.Questions;
import com.fdesign.models.Quizzes;

/**
 * @author venile
 * Servlet responsible of getting all questions and creating them along with its answer
 */
public class QuestionServlet extends HttpServlet{
	
	QuizzesDao quizzesDao = QuizzesDao.currrentImplementation;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/QuizApp/question".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			List<Questions> questions = new ArrayList<>();
			questions = quizzesDao.retrieveAllQuestions();
			
			String json = om.writeValueAsString(questions);

			resp.addHeader("content-type", "application/json");
			resp.getWriter().write(json);
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/QuizApp/question/create".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			QA qa = (QA) om.readValue(req.getReader(), QA.class);
			
			quizzesDao.createNewQuWithAns(qa);
			
			String json = om.writeValueAsString(qa);
			
			resp.getWriter().write(json);
			resp.setStatus(201);
			}
	}

}
