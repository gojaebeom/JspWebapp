package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add02")
public class AddTest02 extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		//연산자도 쿼리스트링으로 받아 연산하기
		String num1_ = req.getParameter("num1");
		String num2_ = req.getParameter("num2");
		
		int num1 = 0, num2 = 0;
		
		PrintWriter out = res.getWriter();
		
		if(!num1_.equals("") && !num2_.equals(""))
		{
			num1 = Integer.valueOf(num1_);
			num2 = Integer.valueOf(num2_);
		}
		
		String op_ = req.getParameter("op");
		
		if(op_.equals("+"))
			out.println(num1 + num2);
		else if(op_.equals("-"))
			out.println(num1 - num2);
		
	}
}
