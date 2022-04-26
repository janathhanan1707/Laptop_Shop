package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.DAO.LaptopDAO;
import com.web.model.LaptopDetail;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		List <LaptopDetail> rest = new ArrayList<LaptopDetail>();
		Gson gson = new Gson(); 
		String str = null;
		try {
			rest = LaptopDAO.viewLaptops();
			System.out.println(rest);
			str = gson.toJson(rest);	
		} catch (Exception e) {
			str = gson.toJson("unknown error occurred");	
			e.printStackTrace();
		}
		
		
		System.out.println(str);
		out.println(str);
		
		out.flush();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}



}
