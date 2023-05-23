

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id.equals("test")&&pw.equals("12345")) {
			//로그인 성공
			//1. 세션 값 저장(ID)
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			//2. Main.jsp 이동
			// - forwarding: 데이터 포함해서 이동
			// - redirecting : 이동!
			// id 데이터는 세션에 저장 되어 있으므로 redirecting으로 이동
			response.sendRedirect("Ex08Main.jsp");
		}else {
			//로그인 실패
			response.sendRedirect("Ex08LoginForm.html");
		}
		
	}

}
