package com.fdesign.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdesign.daos.QuizzesDao;
import com.fdesign.models.Q;

public class AssignmentServlet extends HttpServlet{
	
	private final Logger logger = LogManager.getLogger(getClass());
	
	QuizzesDao quizzesDao = QuizzesDao.currrentImplementation;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(req.getRequestURI());
		ObjectMapper om = new ObjectMapper();
		Q q = (Q) om.readValue(req.getReader(), Q.class);
		int uid = q.getUser_id();
		int qid = q.getQuiz_id();
		int quid = q.getQuestion_id();
		if(quid == 0) {
			quizzesDao.AssignQuizToUser(uid, qid);
		} else if (uid == 0) {
			quizzesDao.AssignQuestionsToQuiz(qid, quid);
		} else {
			resp.setStatus(400);
		}
		
		resp.setStatus(201);
	}

}
