package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.database.SqlSessionManager;

//MyBatis DAO 정의
public class MyMemberDAO {
	//1. SqlSessionFactory 생성 : DB 관련 기능을 직접 사용 할 수 있는 세션(DB에서 사용하는 세션)을 생성
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	//회원가입
	public int join(MyMember member) { //static 없으면 사용할때 객체 먼저 생성!
		//Factory 사용해서 Session 생성
		//true : auto commit을 의미
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int cnt = 0;
		try {
			//insert(실제 실행 할 sql(namespace.id값(xml파일에따로)),sql실행할때 넘겨줄 값(?))
			//반환값 : sql 실행 성공(삽입 성공 -1/실패-0)
			cnt = sqlSession.insert("MyMemberDAO.insert",member); 
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close(); //자원 반환
		}
		
		return cnt;
	}
	
	//로그인
	public MyMember login(MyMember member) {
		MyMember member2 = null;
		//세션 생성
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			//전체회원을 가져오려면 selectList( namespace , 넘겨주어야할값)
			member2 = sqlSession.selectOne("MyMemberDAO.login",member);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return member2;
	}

}
