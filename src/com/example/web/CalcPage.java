package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc-page")
public class CalcPage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
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
		out.write("<form action=\"calculator\" method=\"post\">");
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
}
