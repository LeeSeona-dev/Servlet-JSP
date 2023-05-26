package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//~.do 요청을 모두 받아줄 컨트롤러(프론트 컨트롤러)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String,Command> list = null;
	
	public void init(ServletConfig config) throws ServletException {
		// 
		list = new HashMap<>();
		list.put("/join.do", new JoinController());
		list.put("/login.do", new LoginController());
		list.put("/logout.do", new LogoutController());
		list.put("/update.do", new UpdateController());
		list.put("/delete.do", new DeleteController());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 구분해야함 , url에서 path만 빼서 ~~~
		String reqUri = request.getRequestURI(); //요청 경로 가지고 옴
		String contextPath=	request.getContextPath(); //Contextpath : 서버에서 프로젝트를 구별하기 위해 쓰는 경로
		String key = reqUri.substring(contextPath.length()); //contextPath값만 잘라줌, /join.do , /login.do이런 값 가지고 있음
		
		//JoinController는 Command로 업캐스팅 가능->Command를 구현해야하므로 Command가 상위
		//->JoinController,LoginController에 따라 조건절 사용하지 않아도 된다.
		Command controller =  list.get(key);
		String des = controller.process(request, response);
		if(des.equals("joinSeuccess.jsp")) {
			//forwarding
			RequestDispatcher rd = request.getRequestDispatcher("joinSuccess.jsp");
			rd.forward(request, response);
		}else {
			//redirecting
			response.sendRedirect(des);
		}
		//System.out.println(des);
		//response.sendRedirect(des);
	}

}
