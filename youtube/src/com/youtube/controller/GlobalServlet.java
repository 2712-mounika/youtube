package com.youtube.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youtube.entity.YoutubeEmployee;
import com.youtube.service.YoutubeService;
import com.youtube.service.YoutubeServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		String s=request.getParameter("ac");
		if(s.equals("login"))
		{
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			YoutubeEmployee ye=new YoutubeEmployee();
			ye.setName(name);
			ye.setEmail(email);
			ye.setPassword(password);
			YoutubeServiceInterface yi=YoutubeService.createServiceObject();
			int i=yi.createProfile(ye);
			if(i>0)
			{
				out.println("create profile");
			}
			else
			{
				out.println("do not create profile");
			}
			out.println("</body></html>");
			
		}
	}

}
