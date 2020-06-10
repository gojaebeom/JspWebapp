package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException 
	{
		Cookie[] cookies =  req.getCookies();
		
		String exp = "0";
		
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("exp"))
				{
					exp = cookie.getValue();
					break;
				}
			}
		}
		
		PrintWriter out = res.getWriter();
		 
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<style>");
		out.write("input");
		out.write("{");
		out.write("width:50px;");
		out.write("height:50px;");
		out.write("margin:5px;");
		out.write("}");
		out.write("</style>");
		out.write("<body>");
		out.printf("<span>%s</span>", exp);
		out.write("<form method=\"post\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"7\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"8\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"9\">");
		out.write("<input type=\"submit\" name=\"operator\" value=\"*\">");
		out.write("<br>");
		out.write("<input type=\"submit\" name=\"value\" value=\"4\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"5\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"6\">");
		out.write("<input type=\"submit\" name=\"operator\" value=\"-\">");
		out.write("<br>");
		out.write("<input type=\"submit\" name=\"value\" value=\"1\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"2\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"3\">");
		out.write("<input type=\"submit\" name=\"operator\" value=\"+\">");
		out.write("<br>");
		out.write("<input type=\"submit\" name=\"operator\" value=\"C\">");
		out.write("<input type=\"submit\" name=\"value\" value=\"0\">");
		out.write("<input type=\"submit\" name=\"operator\" value=\"=\">");
		out.write("<input type=\"submit\" name=\"operator\" value=\"/\">");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		String operator = req.getParameter("operator");
		String value_ = req.getParameter("value");
		
		Cookie[] cookies =  req.getCookies();
		
		String exp = "";
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(cookie.getName().equals("exp"))
				{
					exp = cookie.getValue();
					break;
				}
			}
		}
		
		if(operator != null && operator.equals("=")) 
		{
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else 
		{
			exp += (value_ == null) ? "" : value_;
			exp += (operator == null) ? "" : operator;
		} 
	
		Cookie expCookie = new Cookie("exp", exp);
		
		System.out.println(operator);
		if(operator != null && operator.equals("C"))
			expCookie.setMaxAge(0);
		
		System.out.println(expCookie);
		
		expCookie.setPath("/");
		
		res.addCookie(expCookie);
		res.sendRedirect("calculator");
	}
}
