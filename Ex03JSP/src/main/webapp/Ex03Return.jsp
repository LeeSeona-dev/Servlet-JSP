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
	request.setCharacterEncoding("UTF-8");
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	String ope = request.getParameter("ope");
	
	int result;
	if(ope.equals("plus")){
		ope = "+";
		result = num1+num2;
	} else if(ope.equals("minus")){
		ope = "-";
		result = num1-num2;
	} else if(ope.equals("mul")){
		ope = "*";
		result = num1*num2;
	} else{
		ope = "/";
		result = num1/num2;
	}
	out.print(num1+ope+num2+"="+result);
	%>
	
	<%=num1+ope+num2+"="+result %>
	
</body>
</html>