package com.fdesign.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdesign.daos.QuizzesDao;
import com.fdesign.models.QutoQ;

public class TestQuestServlet extends HttpServlet{
	
	private final Logger logger = LogManager.getLogger(getClass());
	
	QuizzesDao quizzesDao = QuizzesDao.currrentImplementation;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/QuizApp/testquest".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			List<QutoQ> qutoq = new ArrayList<>();
			qutoq = quizzesDao.retrieveAllQuestsAssignedtoQuizzes();
			
			String json = om.writeValueAsString(qutoq);
			
			resp.addHeader("content-type", "application/json");
			resp.getWriter().write(json);
			return;
		} else if ("/QuizApp/testquest/user".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			QutoQ q =  (QutoQ) om.readValue(req.getReader(), QutoQ.class);
			int qid = q.getQuiz_id();
			List<QutoQ> qutoq = new ArrayList<>();
			qutoq = quizzesDao.retrieveAllQuestsAssignedtoQuiz(qid);
			
			String json = om.writeValueAsString(qutoq);
			
			resp.addHeader("content-type", "application/json");
			resp.getWriter().write(json);
			return;
		}
	}

}
