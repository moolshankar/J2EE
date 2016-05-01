<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String userName = request.getParameter("name"); %>

<!--  <b>The entered name is <%=userName %></b> -->
<%
if (userName != null){
	session.setAttribute("sessionUserName", userName);
	//application.setAttribute("applicationUserName", userName);
	pageContext.setAttribute("pageContextUserName", userName);
	pageContext.setAttribute("ContextUserName", userName, pageContext.APPLICATION_SCOPE);
}
%>
<br>
<b>The name in request object is <%=userName %></b>
<br>
<b>The name in session object is <%=session.getAttribute("sessionUserName") %></b>
<br>
<b>The name in application object is <%=application.getAttribute("ContextUserName") %></b>
<br>
<b>The name in page Context object is <%=pageContext.getAttribute("pageContextUserName") %></b>
<br>
</body>
</html>