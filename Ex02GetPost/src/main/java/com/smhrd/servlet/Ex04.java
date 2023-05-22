package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex04")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청인코딩
		request.setCharacterEncoding("UTF-8");
		
		//name가져오기
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String pwCheck = request.getParameter("passwordCheck");
		
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String birthday = request.getParameter("birthday");
		//취미 중복 선택 -> 배열로 가져오기
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String text = request.getParameter("text");
		
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("아이디 : "+id+"<br>");
		out.print("비밀번호 : "+pw+"<br>");
		if(!pw.equals(pwCheck)) {
			out.print("비밀번호가 일치하지 않습니다."+"<br>");
		}else {
			out.print("비밀번호가 일치합니다."+"<br>");
		}
		out.print("성별 : "+gender+"<br>");
		out.print("혈액형 : "+blood+"<br>");
		out.print("생일 : "+birthday+"<br>");
		
		for(int i= 0; i<hobby.length; i++) {
			out.print(hobby[i]+" ");
		}out.print("<br>");
		out.print("좋아하는 색 : "+color+"<br>");
		out.print("남기고싶은말 : "+text+"<br>");
		
		
		
	}

}
