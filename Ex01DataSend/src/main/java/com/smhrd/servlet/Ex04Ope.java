package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex04Ope")
public class Ex04Ope extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int int_num1 = Integer.parseInt(request.getParameter("num1"));
		int int_num2 = Integer.parseInt( request.getParameter("num2"));
		String ope = request.getParameter("ope");
		
		System.out.println(ope);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out= response.getWriter();
		
		if(ope.equals("plus")) {
			out.print(int_num1+" + "+int_num2+" = "+(int_num1+int_num2));
		}else if(ope.equals("minus")) {
			out.print(int_num1+" - "+int_num2+" = "+(int_num1-int_num2));
		}else if(ope.equals("mul")) {
			out.print(int_num1+" * "+int_num2+" = "+(int_num1*int_num2));
		}else if(ope.equals("div")) {
			out.print(int_num1+" / "+int_num2+" = "+(int_num1/int_num2));
		}
		
		
	}

}
