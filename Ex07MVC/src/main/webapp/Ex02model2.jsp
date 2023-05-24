<%@page import="com.smhrd.model.FullStack"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 세션안에 저장되어있는 학생정보(3명) 테이블 출력 -->
	
	<%
		
	 ArrayList<FullStack> stlist = (ArrayList<FullStack>)session.getAttribute("stlist");
	
	%>
	<table border=1px solid black>
		<tr>
			<th>이름</th>
			<th>전공</th>
			<th>번호</th>
		
		</tr>
		
		
		<%
		for(int i = 0; i<stlist.size(); i++){%>
			<tr> <!-- getName, getMajor... -> VO에서 만든 이유, 가져오기 위함 -->
			<td><% out.println(stlist.get(i).getName());%></td>
			<td><% out.println(stlist.get(i).getMajor()); %></td>
			<td><% out.println(stlist.get(i).getPhone()); %></td>
			</tr>
		<%} %>
		
		
	
	</table>
</body>
</html>