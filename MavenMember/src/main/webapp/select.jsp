
<%@page import="com.smhrd.model.WebMember"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.WebMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<%
		//회원정보 불러오기 (DB)
		WebMemberDAO dao=  new WebMemberDAO();
		//여러명의 정보를 가져오기 위해 리스트타입으로(어레이리스트의 상위버전)
		List<WebMember> list = dao.select();
		System.out.print(list.size());
		
	
	%>
	
	<body style="text-align: center;">
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>							
							</tr>
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
							<%
							for(WebMember w:list){
								out.print("<tr>");
								out.print("<td>"+w.getEmail()+"</td>");
								out.print("<td>"+w.getTel()+"</td>");
								out.print("<td>"+w.getAddress()+"</td>");
								out.print("<td><a href='delete.do?email="+w.getEmail()+"'>삭제</a></td>");
								
								out.print("</tr>");
							}
							
							
							%>
						
						</table>
					</nav>		
					<a href="index.jsp" class="button next scrolly">되돌아가기</a>	
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>
