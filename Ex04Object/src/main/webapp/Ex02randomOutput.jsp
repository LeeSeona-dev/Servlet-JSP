<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String p = request.getParameter("p");
		String[] menu = request.getParameterValues("menu");
	%>
	<h2>랜덤 당첨 게임</h2>
	<fieldset>
		<legend>랜덤뽑기결과</legend>
	<form action="Ex02createOutput.jsp">
	<table>
	 <tr><td><%=p %></td></tr>
	<% 
	Random rd = new Random();
	int s = rd.nextInt(menu.length);
	String m= menu[s];
	
	%>
	<tr><td><%=m %></td></tr>
	</table>
	</form>
		
	</fieldset>
</body>
</html>