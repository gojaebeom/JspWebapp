package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add03")
public class AddTest03 extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
		String[] nums_ = req.getParameterValues("num");
		System.out.println(nums_[0]);
		
		PrintWriter out = res.getWriter();
		
		for(int i = 0; i < nums_.length; i++)
		{
			int num =  Integer.valueOf(nums_[i]);
			out.println(num);
		}
	}
}
