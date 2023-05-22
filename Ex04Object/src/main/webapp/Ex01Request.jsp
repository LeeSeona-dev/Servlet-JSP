<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("UTF-8");%>
	
	
	<%
	String name = request.getParameter("name");
	int sc1 = Integer.parseInt(request.getParameter("java"));
	int sc2 = Integer.parseInt(request.getParameter("web"));
	int sc3 = Integer.parseInt(request.getParameter("iot"));
	int sc4 = Integer.parseInt(request.getParameter("and"));
	double  p = (sc1+sc2+sc3+sc4)/4.0 ;
	String h = "";
	

	
	
	if(p>=95 && p<=100){
		h = "A+";
	}else if(p>=90 && p<=94){
		h = "A";
	}else if(p>=85 && p<=89){
		h = "B+";
	}else if(p>=80 && p<=84){
		h = "B";
	}else {
		h = "F";
	}
	
	%>
	<fieldset>
		<legend>학점확인프로그램</legend>
		<table>
		<tr>
		<td>이름</td>
		<td><%=name %></td>
		</tr>
		<tr>
		<td>Java 점수 </td>
		<td><%=sc1 %></td>
		
		</tr>
		<tr>
		<td>Web 점수</td>
		<td><%=sc2 %></td>
		</tr>
		<tr>
		<td>IoT 점수</td>
		<td><%=sc3 %></td>
		</tr>
		<tr>
		<td>Android 점수</td>
		<td><%=sc4 %></td>
		</tr>
		<tr>
		<td>평균</td>
		<td><%=p %></td>
		</tr>
		<tr>
		<td>학점</td>
		<td><strong><%=h %></strong></td>
		</tr>
		</table>
		
	
	</fieldset>
	
	
</body>
</html>