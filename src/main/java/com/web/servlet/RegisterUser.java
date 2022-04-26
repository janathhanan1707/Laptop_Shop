package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.UserDAO;
import com.web.UserDetail;
import com.web.Validation;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name") ;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		String dob = request.getParameter("dob");
		String city = request.getParameter("city");
		String message = null;
		int a = Validation.validName(name);
		 int b = Validation.validEmail(email);
		 int c = Validation.validPasswor(password);
		 int d = Validation.validName(number);
		 int f = Validation.validAddress(city);
		 
		 int validation = 0;
		 int mailValidation = 0;
		 
		 UserDetail user = new UserDetail();
		 user.setName(name);
		 user.setEmail(email);
		 user.setPassword(password);
		 user.setMoblie_no(number);
		 user.setCity(city);
		 
		 if(a+b+c+d+f == 0) {
			 System.out.println("Validation passed");
			 validation = 1;
			 
		 }else if(a+b+c+d+f!=0) {
			 System.out.println("Validation Failed");
			 message="Give correct inputs";
			 validation = 0;
		 }
		 if (validation==1) {
			 
			 try {
				mailValidation = UserDAO.mailValidation(user.getEmail());
			} catch (Exception e) {
				message = e.getMessage();
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		 }
		 if (mailValidation==0){
			try {
				int z = UserDAO.addUser(user);
				if(z==1) {
					message = "succes";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message=e.getMessage();			} 
			 
		 }
		 PrintWriter out = response.getWriter();
		 out.println(message);
	
		 out.flush();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
