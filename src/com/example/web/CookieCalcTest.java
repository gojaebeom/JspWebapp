package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-calc")
public class CookieCalcTest extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
		Cookie[] cookies =  req.getCookies();
		
		PrintWriter out = res.getWriter();
		
		String v_ = req.getParameter("value");
		String op_ = req.getParameter("op");
		
		
		
		if(op_.equals("="))
		{
			int x = 0;
			int y = Integer.valueOf(v_);
			
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("value"))
				{
					x = Integer.valueOf(cookie.getValue());
					break;
				}
			}
			
			
			String op = "";
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("op"))
				{
					op = cookie.getValue();
					break;
				}
			}
			
			if(op.equals("+"))
				out.println(x + y);
			else if(op.equals("-"))
				out.println(x - y);
		}else
		{
			Cookie valueCookie = new Cookie("value", v_);
			Cookie opCookie = new Cookie("op", op_);
			res.addCookie(valueCookie);
			res.addCookie(opCookie);

		}
		
	}
}
