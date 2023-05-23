<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("nickname","풀스택" );
		String nick = (String)request.getAttribute("nickname");
		
		//pageContext.setAttribute("nickname","풀스택22");
		//String nick1 = (String)pageContext.getAttribute("nickname");
	%>
	<%=nick %><br>
	${nickname } 
	<!-- 2개 이상의 영역에서 같은 name 값을 사용하면 더 좁은 영역에 값을 가지고 옴
	page 값을 가지고 온다! 가지고오고싶은 값을 지정해주면 된다.
	 -->
	 ${requestScope.nickname }
	 <a href="Ex02request2.jsp">2로이동</a>
</body>
</html>