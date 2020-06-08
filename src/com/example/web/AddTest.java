package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddTest extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		String num1_ = req.getParameter("num1");
		String num2_ = req.getParameter("num2");
		
		PrintWriter out = res.getWriter();
		
		if(num1_ == null || num1_.equals("") && num2_ == null || num2_.equals("")) 
		{
			out.println("값을 입력해주세요");
			out.println("num1의 값: "+num1_);
			out.println("num2의 값: "+num2_);
		}
		else
		{
			int num1 = Integer.parseInt(num1_);
			int num2 = Integer.parseInt(num2_);
			
			out.println("덧셈:"+ (num1 + num2));
			out.println("뺄셈:"+ (num1 - num2));
			out.println("나눗셈:"+ (num1 / num2));
			out.println("곱셈:"+ (num1 * num2));
		}
	}

}
