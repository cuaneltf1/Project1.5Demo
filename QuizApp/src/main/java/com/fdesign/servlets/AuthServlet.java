package com.fdesign.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdesign.daos.UserDao;
import com.fdesign.models.User;

/**
 * @author venile
 * Servlet responsible for authenticating application user
 */
public class AuthServlet extends HttpServlet{
	
	private UserDao userDao = UserDao.currentImplementation;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/QuizApp/auth/login".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			User credentials = (User) om.readValue(req.getReader(), User.class);
			User loggedInUser = userDao.loginAuthentication(credentials.getUsername(), credentials.getPassword());
			if (loggedInUser == null) {
				resp.setStatus(401);
				return;
			} else {
				if (loggedInUser.getAuthority() == 1) {
					resp.setStatus(200);
					req.getSession().setAttribute("user", loggedInUser);
					resp.getWriter().write(om.writeValueAsString(loggedInUser));
					return;
				} else {
					resp.setStatus(201);
					req.getSession().setAttribute("user", loggedInUser);
					resp.getWriter().write(om.writeValueAsString(loggedInUser));
					return;
				}
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/QuizApp/auth/session-user".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(req.getSession().getAttribute("user"));
			resp.getWriter().write(json);
		}
	}

}
