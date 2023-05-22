package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//404오류 -> 경로가 맞는지 살펴보기!
//***form 안의 action과 경로가 같아야함!!!!!!! -> url매핑값 확인후, action 경로 !
@WebServlet("/Ex02")
public class Ex02Number extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data =  request.getParameter("data"); //->input type name값
		response.setContentType("text/html; charset=UTF-8");
		
		//사용자가 입력한 값 그대로 html 문서로 만들어서 응답하기
		PrintWriter out= response.getWriter(); //텍스트 출력 스트림 만들기
		out.print("입력한 숫자는 <b>"+data+"</b> 입니다.");
	}

}
