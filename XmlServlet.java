package com.tyagi.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XmlServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().println("Servlet Java Class called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println("Hello servlet");
		//http://localhost:8080/SimpleServletProject/XmlServletPath?userName=Shankar&id=123
		String userName = request.getParameter("userName");
		String userID = request.getParameter("id");
		HttpSession sesion = request.getSession(); // To allow a particular user to access data
		ServletContext cont = request.getServletContext(); // To allow all user to access session data
		if (userName != "" && userName != null){
			sesion.setAttribute("UserN", userName);
			cont.setAttribute("UserN", userName);
		}
		if (userID != "" && userID != null){
			sesion.setAttribute("UserI", userID);
			cont.setAttribute("UserI", userID);
		}
		out.println("Out of Session <br>");
		out.println("Hello "+(String)sesion.getAttribute("UserN"));
		out.println("Your id is "+(String)sesion.getAttribute("UserI")+"<br>");
		
		out.println("Out of Context <br>");
		out.println("Hello "+(String)cont.getAttribute("UserN"));
		out.println("Your id is "+(String)cont.getAttribute("UserI")+"<br>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello from Post <br>");
		String userName = request.getParameter("userName");
		String userID = request.getParameter("id");
		String userProf = request.getParameter("prof");
		String[] userLoc = request.getParameterValues("loc");
		out.println("Hello "+userName+"<BR>");
		out.println("Your id is "+userID+"<br>");
		out.println("Your Designation "+userProf+"<br>");
		out.println("Your loactions are <br>");
		int i =0;
		while (i<userLoc.length){
			out.println(userLoc[i]+"<br>");
			++i;
		}
	}

}
