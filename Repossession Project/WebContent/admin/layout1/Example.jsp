<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<%
List<String> list = (ArrayList<String>) session.getAttribute("aaa");
int i=(Integer)session.getAttribute("length");//263
int j=(i/6)+1;//43
out.println(j);
int y=0;
int z=0;
for(int n=0;n<j;n++)//0 1
{
	%><tr><%
	System.out.println(n);
	for(int x=0;x<=5;x++)// 0
	{
		System.out.println(x);
		if(x==0)// n n n n n n n
		{
			
			y=n;// 0
			System.out.println(x+" && "+n+" && "+y);
		}
		else
		{
			
			y=(j*x)+z;// 43 86 
			System.out.println(x+" && "+n+" && "+y);	
		}
		
		if(y<i)
		{
			String s=list.get(y);
			if(!s.matches("[0-9]+") == false && s.length() > 2)
			{
				System.out.print("hehe");
				%><td><%=list.get(y) %></td><%
								
			}
			else if(s.length()>2)		//first 4
			{					
				%><td><h3><u><%=list.get(y) %></u></h3></td><%
						
			}
			else
			{
				%><td><b><%=list.get(y) %></b></td><%
						
			}
			
		}
	}
	%></tr><%
	z++;
	
}
out.println(i);
%>
</table>
<%-- 
<table>

<tr>
<c:forEach items="${sessionScope.aaa }" var="x" varStatus="i">
<td>${x[${i.index}]}</td>
</c:forEach>

</tr>
</table>
 --%>

</body>
</html>