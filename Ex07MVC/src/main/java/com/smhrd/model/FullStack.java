package com.smhrd.model;

//Full Stack 테이블에서 가지고 온 학생 데이터를 하나로 묶어주는 작업
//하나의 객체 -> 학생 한명의 데이터를 의미-> VO (Value Object)
//VO : 필드 이름은 테이블 컬럼이름과 같게한다. 생성자 필요함 , getter(private이므로 getter필요)
public class FullStack {
	private String name;
	private String major;
	private String phone;
	
	//생성자
	public FullStack(String name, String major, String phone) {//DB에서 가지고온 값을 매개변수로 넣어준다
		//생성된 FullStack 객체의 필드를 DB에서 가지고 온 값으로 초기화해주는 작업이 필요
		this.name = name; //this.필드(객체안에 있는) = 매개인자값으로 초기화!!
		this.major = major;
		this.phone = phone;
		
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public String getPhone() {
		return phone;
	}
	
}
