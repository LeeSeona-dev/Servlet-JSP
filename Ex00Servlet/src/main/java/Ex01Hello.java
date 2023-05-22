

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01Hello")
public class Ex01Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//요청을 처리하고 응답을 해주는 역할 ->service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트에서 /Ex01Hello 경로로 요청
		//서버주소/context-root(path라고도 함, 프로젝트이름과 다름,
		//					확인은 서버 안에 모듈 ->path)->Ex00
		//localhost:8081/Ex00/Ex01Hello
		
		//서버 -> 정적 리소스(HTML) : "Hello Servlet" 문자가 출력 -> 클라이언트
		//화면에 Hello Servlet 이라고 출력하기
		// -> 서버가 클라이언트한테 응답해주는 문서가 문자열이 작성되어있는 html 문서
		
		//response : 서버 -> 클라이언트
		//getWriter() : 서버로부터 클라이언트로 데이터를 보내기 위한 통로(스트림->PrintWriter) 생성
		PrintWriter out= response.getWriter();
		//PrintWriter : 데이터(텍스트)를 보내기 위한 통로
		
		//print(String) : 스트림을 통해서 텍스트 출력
		out.print("<b>Hello Servlet!</b>"); //응답할 html 문서 만드는 작업
		
		
	}

}
