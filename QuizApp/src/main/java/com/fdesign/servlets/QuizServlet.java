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
import com.fdesign.models.Quizzes;

/**
 * @author venile
 * Servlet responsible for getting all quizzes and creating them
 */
public class QuizServlet extends HttpServlet{
	
	private QuizzesDao quizzesDao = QuizzesDao.currrentImplementation;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/QuizApp/quiz".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			List<Quizzes> quizzes = new ArrayList<>();
			quizzes = quizzesDao.retrieveAllQuizzes();
			
			String json = om.writeValueAsString(quizzes);
			
			resp.addHeader("content-type", "application/json");
			resp.getWriter().write(json);
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/QuizApp/quiz/create".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			Quizzes q = (Quizzes) om.readValue(req.getReader(), Quizzes.class);
			
			quizzesDao.createNewQuiz(q);
			
			String json = om.writeValueAsString(q);
			
			resp.getWriter().write(json);
			resp.setStatus(201);
			}
	}
}
