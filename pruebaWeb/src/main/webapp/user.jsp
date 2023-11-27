<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User JSP</title>
	<link rel="stylesheet" href="styles.css">
</head>

<style>
	.welcome-text {
	    font-weight: bold;
	    font-size: 50px;
	}
</style>

	<div>
	    <%
	        String username = (String) session.getAttribute("username");
	        if (username == null) {
	            response.sendRedirect("signUp.jsp");
	        } else {
	            out.println("<span class='welcome-text'>Welcome, " + username + "</span>");
	        }
	    %>
	</div>
	
	<div>
	  <c:forEach var="user" items="${users}">
	    <div>
	      <form>
	        <h2>UserName: ${user.username}</h2>
	      </form>
	    </div>
	  </c:forEach>
	</div>
	
	<div>
		<a type="submit" class="btn" href="info?action=logout">Cerrar Sesion</a>
	</div>
</body>
</html>