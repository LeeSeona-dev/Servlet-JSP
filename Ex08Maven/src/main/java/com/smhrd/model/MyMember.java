package com.smhrd.model;

public class MyMember {
	//필드 정의
	private String id;
	private String pw;
	private String nick;
	
	//생성자 생성
	public MyMember(String id, String pw, String nick) {//필드와 매개변수는 다름!
		//매개변수의 이름이 다르다면 this 쓰지 않아도 된다! 서로 다름!
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		
	}
	
	//로그인할때 id,pw만 담을 수 있는 생성자~~
	public MyMember(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	//VO 자체가 값이 바뀌지 않음 , 무결성 유지, 보통은 getter만 사용!
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getNick() {
		return nick;
	}
	
}
