package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session-calc")
public class SessionCalcTest extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
		HttpSession session =  req.getSession();
		PrintWriter out = res.getWriter();
		
		String v_ = req.getParameter("value");
		String op_ = req.getParameter("op");
		
		int v = 0;
		if(!v_.equals("")) v = Integer.valueOf(v_);
		
		if(op_.equals("="))
		{
			int x = (Integer) session.getAttribute("value");
			int y = v;
					
			String operator = (String) session.getAttribute("op");
			if(operator.equals("+"))
				out.println(x + y);
			else if(operator.equals("-"))
				out.println(x - y);
				
			
		}else
		{
			session.setAttribute("value", v);
			session.setAttribute("op", op_);
		}
		
	}
}