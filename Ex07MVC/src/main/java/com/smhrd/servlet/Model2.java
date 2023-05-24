package com.smhrd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.FullStack;



@WebServlet("/Model2")
public class Model2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model2로 요청 먼저!
		//1.DB 연동
		//2. SQL 실행(FullStack 테이블안에 모든 값 가져오기)
		//3. 3명의 학생정보를 가져와 -> 세션에 저장하기
		// -> Ex02model2.jsp로 이동
		//ArrayList : 데이터 검색 용이
		//LinkedList : 중간 데이터 삭제, 추가 용이
		
		ArrayList<FullStack> stlist = new ArrayList<FullStack>();
		//List<FullStack> stlist = new ArrayList<FullStack>();
		//-> 앞에 List(import는 java.util)는 모든 list타입의 상위 타입이므로
		//이렇게 업캐스팅으로 사용하면 검색하려면 ArrayList로 다운캐스팅,
		//중간에 데이터를 삭제나 추가하려면 LinkedList로 다운캐스팅해서 쓸수있다!!!
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		FullStack fs = null;
		
		//세션 객체 생성
		HttpSession session = request.getSession();
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			//지정한 데이터베이스와 연결하기 위한 객체 (Connection) 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
		 	String user = "service";
		 	String password = "12345";
		 	
		 	conn = DriverManager.getConnection(url, user,password);
		 	
		 	String sql = "select * from fullstack";
		 	//sql 쿼리문을 다루기위한 객체(PreparedStatement) 생성
		 	ps = conn.prepareStatement(sql);
		 	
		 	//sql 실행
		 	rs = ps.executeQuery();
		 	
		 	while(rs.next()) {
				
				String name = rs.getString(1);
				String major = rs.getString(2);
				String phone = rs.getString(3);
				
	
			     session.setAttribute("name", name);
			     session.setAttribute("major", major);
			     session.setAttribute("phone", phone);
			     
			     //fs -> 학생 한명의 정보 객체 (하나씩 덮어쓰므로 가지고 온 학생 정보를 Arraylist 로 저장한다)
			     // FullStack 객체 생성 및 stlist에 추가
			     fs = new FullStack(name, major, phone);
			     stlist.add(fs);
			        
		 	
		 	}session.setAttribute("stlist", stlist);
	  }catch(ClassNotFoundException e){
			//OracleDriver 가지고 올때 경로가 잘못됐을 경우
			System.out.println("OracleDriver 클래스 못찾음!");
		} catch(SQLException e){
			System.out.println("sql 예외 발생!");
		} catch(Exception e){
			System.out.println("다른 예외 발생!");
			e.printStackTrace(); //원인, 발생하게 된 절차 콘솔창에 출력해준다.
		} finally{ //예외상황이 발생 하던지 / 하지 않던지 간에 무조건 실행한다!
			//사용한 자원 반환(생성한 순서 반대로!)
			try{
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e){
				System.out.println("finally 에서 예외상황 발생!");
				e.printStackTrace();
			}
			
		}
		//list -> session에 저장
		//HttpSession session = request.getSession();
		//session.setAttribute("stlist",stlist);
		response.sendRedirect("Ex02model2.jsp");
	}	
}
