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
	out.print("<table border=1>");
	out.print("<tr>");
	for(int i = 1 ; i<=10; i++){
		
		out.print("<td>"+i+"</td>");
		
	}
	out.print("</tr>");
	out.print("</table>");
%>
<!-- 두번째 코드 -->
<table border=1>
	<tr>
	<%
		for(int i = 1; i<=10; i++){
			out.print("<td>"+i+"</td>");
		}
	%>
	</tr>
</table>
<!-- 세번째 방법 -->
<table border=1>
	<tr>
	<%for(int i = 1; i<=10; i++){%>
		<td><%=i %></td>
		<%} %>
	
	</tr>
</table>

</body>
</html>