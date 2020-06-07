package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class ServletTest extends HttpServlet
{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		//서블릿 출력도구 HttpServletResponse 사용하여 출력하기
		PrintWriter out =  res.getWriter();
		
		//파라미터로 count 쿼리스트링 값 받기
		String count_ = req.getParameter("count");
		
		int count = 1;
		
		//count_ 값이 널이 아니고 빈문자열도 아닐 경우 count 변수에 정수형으로 변환하여 대입 (nullpont 오류 방지)
		if(count_ != null && !count_.equals(""))
			count = Integer.parseInt(count_);
		
			
		for(int i = 0; i < count; i++)
		{
			out.println("한글 출력해보기");
		}
	}
}
