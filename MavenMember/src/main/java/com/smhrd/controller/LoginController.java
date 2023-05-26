package com.smhrd.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class LoginController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		
		try {
			request.setCharacterEncoding("UTF-8");
			//email , pw로 로그인?
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			//String tel = request.getParameter("tel");
			//String address = request.getParameter("address");
			
			WebMember member = new WebMember(email,pw);
			
			WebMemberDAO dao = new WebMemberDAO();
			WebMember member2 = dao.login(member);
			
			if(member2!=null) {//로그인성공시
				//세션 회원정보 저장, index.jsp 이동
				//세션은 jsp만내장객체임!, 세션 객체 생성해줘야함~
				HttpSession session = request.getSession();
				session.setAttribute("member", member2);
				System.out.println("로그인 성공");
				url = "index.jsp";
				
			}else {
				System.out.println("로그인 성공");
				url = "index.jsp";
			}
			
		}catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 방식 잘못 지정함");
		}catch(IOException e) {
			System.out.println("리다이렉팅 경로 잘못 지정함");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
