package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		//로그아웃 -> 세션 삭제만 하면 된다!
		
		try {
			//세션 삭제 (회원정보 지우기)
			HttpSession session = request.getSession();
			
			//두 방법중 하나만~~~
			
			//특정세션 하나만 지우기
			session.removeAttribute("member");
			//전부 지우기
			//session.invalidate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "index.jsp";
	}

}
