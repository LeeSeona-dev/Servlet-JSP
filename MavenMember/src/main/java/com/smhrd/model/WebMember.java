package com.smhrd.model;

public class WebMember {
	//필드 -> db 테이블명과 똑같이 맞춰주는것이 좋음
	private String email;
	private String pw;
	private String tel;
	private String address;
	
	//한번에 묶어줄 생성자 생성
	public WebMember(String email, String pw, String tel, String address) {
		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;
	}
	//로그인 생성자 오버로딩(중복정의)
	public WebMember(String email, String pw) {
		this.email=email;
		this.pw = pw;
		this.address=null;
		this.tel=null;
	}

	public String getEmail() {
		return email;
	}

	public String getPw() {
		return pw;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}
	
	
}
