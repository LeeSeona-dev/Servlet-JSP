package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원관리된 요청 받아줄 프론트 컨트롤러(회원가입, 로그인)
//요청 구분 -> 프론트 컨트롤러 : *.do (만약 login.do->로그인 요청/join.do->회원가입요청)

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,Command> list = null;
	//최초로 요청들어왔을때 딱 한번만 실행 
	public void init(ServletConfig config) throws ServletException {
		//여기로 들어올 수 있는 요청 경로를 미리 리스트로 만들어 놓기!
		//map(순서 없는 구조임) 사용(key-value 쌍으로 저장하기 위해)
		// -> (key(요청경로-join.do/login.do -> String)-value(그 기능을 수행해줄 컨트롤러 객체))
		list = new HashMap<>();
		list.put("/join.do", new JoinController());
		list.put("/login.do", new LoginController());
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String subUri = uri.substring(path.length());
		
		System.out.println(uri);
		System.out.println(path);
		System.out.println(subUri);
		
		//JoinController는 Command로 업캐스팅 가능->Command를 구현해야하므로 Command가 상위
		//->JoinController,LoginController에 따라 조건절 사용하지 않아도 된다.
		Command controller =  list.get(subUri);
		String des = controller.process(request, response);
		System.out.println(des);
		response.sendRedirect(des);
	
	}

}
