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
import com.fdesign.models.QutoQ;

/**
 * @author venile
 * Retrieves all questions assigned to a quiz by its id
 */
public class TestServlet extends HttpServlet{
	
	private QuizzesDao quizzesDao = QuizzesDao.currrentImplementation;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		String quiz = req.getParameter("quiz_id");
		List<QutoQ> qutoq = new ArrayList<>();
		if(quiz != null) {
			int test = Integer.parseInt(quiz);
			qutoq = quizzesDao.retrieveAllQuestsAssignedtoQuiz(test);
		}
		
		String json = om.writeValueAsString(qutoq);
		
		resp.addHeader("content-type", "application/json");
		resp.getWriter().write(json);
	}

}
