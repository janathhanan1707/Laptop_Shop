package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.DAO.UserDAO;
import com.web.model.UserDetail;
import com.web.validation.Validation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		get the login input
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String message = null;
//		login validation
		int x = Validation.validEmail(email);
		int y = Validation.validPasswor(password);

		if (x + y == 0) {

			try {
				message = UserDAO.loginValidation(email, password);

			} catch (Exception e) {
				
				// e.printStackTrace();
				message = e.getMessage();
			}
		} else {
			message = "wrong inputs";
		}
		PrintWriter out = response.getWriter();
		out.println(message);
		out.flush();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
