package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app-calc")
public class AppCalcTest extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
		ServletContext application =  req.getServletContext();
		PrintWriter out = res.getWriter();
		
		String v_ = req.getParameter("value");
		String op_ = req.getParameter("op");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.valueOf(v_);
		
		if(op_.equals("="))
		{
			int x = (Integer)application.getAttribute("value");
			int y = v;
					
			String operator = (String)application.getAttribute("op");
			if(operator.equals("+"))
				out.println(x + y);
			else if(operator.equals("-"))
				out.println(x - y);
				
			
		}else
		{
			application.setAttribute("value", v);
			application.setAttribute("op", op_);
		}
		
	}
}
