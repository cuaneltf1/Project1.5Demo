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
import com.fdesign.models.QtoU;

/**
 * @author venile
 * Retrieves all quizes assigned to a user and updates their grade to the db 
 */
public class UserQuizServlet extends HttpServlet{
	
	private QuizzesDao quizzesDao = QuizzesDao.currrentImplementation;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		String use = req.getParameter("user_id");
		List<QtoU> qtou = new ArrayList<>();
		if(use != null ) {
			int user = Integer.parseInt(use);
			qtou = quizzesDao.retrieveAllQuizzesAssignedToUser(user);
		} else {
			qtou = quizzesDao.retrieveAllQuizzesAssignedToUsers();
		}
		
		String json = om.writeValueAsString(qtou);
		
		resp.addHeader("content-type", "application/json");
		resp.getWriter().write(json);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		QtoU result = (QtoU) om.readValue(req.getReader(), QtoU.class);
		
		quizzesDao.updateQuizResults(result.getResults_grade(), result.getUser_id(), result.getQuiz_id());
		
		String json = om.writeValueAsString(result);
		resp.getWriter().write(json);
		resp.setStatus(201);
	}

}
