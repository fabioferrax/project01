<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.Utente"%>
	

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
@import url(Style/Style.css);
</style>
<title>Insert title here</title>
</head>
<body>
	<center>
		
		<%
			Utente utente = (Utente) session.getAttribute("Utente");
		%>
		<%
			if (utente == null) {
		%>
		<a href="<c:url value="/register.jsp"/>">Registrati</a> 
		<a	href="<c:url value="/login.jsp"/>">Login</a>

		<%
			} else {
		%>
		<%="ciao " + utente.getUsername()%>
		
			
			
		<form action="logoutUser" method="post">
			<input type="submit" value="logout">
		</form>
			
		<%
			}
		%>
	</center>
</body>
</html>