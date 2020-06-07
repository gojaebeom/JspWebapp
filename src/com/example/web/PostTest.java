package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post-test")
public class PostTest extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException 
	{
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		PrintWriter out =  res.getWriter();
		out.println(title);
		out.println(content);
	}
}
