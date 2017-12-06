<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String flag=(String)session.getAttribute("user");
if(flag.equals("client"))
{
	System.out.println("Redirecting to client");
	
	response.sendRedirect(request.getContextPath()+"/Login?flag=login_agent");
}
else if(flag.equals("admin"))
{
	System.out.println("Redirecting to admin");
	System.out.println(request.getContextPath()+"/admin/layout1/dashboard.jsp");
	response.sendRedirect(request.getContextPath()+"/admin/layout1/dashboard.jsp");
	
}
else if(flag.equals("WorngAuth"))
{
	System.out.println("Redirecting to Login");
	System.out.println(request.getContextPath()+"/admin/layout1/login.jsp");
	response.sendRedirect(request.getContextPath()+"/admin/layout1/login.jsp");
	
}


%>
</body>
</html>