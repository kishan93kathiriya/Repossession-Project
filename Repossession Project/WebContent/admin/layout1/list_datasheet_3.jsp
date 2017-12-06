<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript">

/*     function printDiv(divName) {
     
     var printContents = document.getElementById(divName).innerHTML;
     w=window.open();
     w.document.write(printContents);
     w.print();
     w.close();
    }
 */     function printDiv(divName) {
     var printContents = document.getElementById(divName).innerHTML;
     var originalContents = document.body.innerHTML;

     document.body.innerHTML = printContents;

     window.print();

     document.body.innerHTML = originalContents;
}
</script>
		<script type="application/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script type="application/javascript" src="js/tableExport.js"></script>
    <script type="application/javascript" src="js/jquery.base64.js"></script>
    <script type="application/javascript" src="js/jspdf/libs/sprintf.js"></script>
    <script type="application/javascript" src="js/jspdf/jspdf.js"></script>
    <script type="application/javascript" src="js/jspdf/libs/base64.js"></script>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>


<body>
<input type="button" class="btn btn-dark btn-embossed" onclick="printDiv('tab')" value="Generate PDF"/>
			   <ul class="dropdown-menu">
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'json',escape:'false'});">JSON</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'json',escape:'false',ignoreColumn:'[2,3]'});">JSON (ignoreColumn)</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'json',escape:'true'});">JSON (with Escape)</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'xml',escape:'false'});">XML</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'sql'});">SQL</a></li>
                                           <li><a href="#" onClick ="$('#customers2').tableExport({type:'csv',escape:'false'});">CSV</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'txt',escape:'false'});">TXT</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'excel',escape:'false'});">XLS</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'doc',escape:'false'});">Word</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'powerpoint',escape:'false'});">PowerPoint</a></li>
                                           <li><a href="#" onClick ="$('#customers2').tableExport({type:'png',escape:'false'});"> PNG</a></li>
                                            <li><a href="#" onClick ="$('#customers2').tableExport({type:'pdf',escape:'false'});">PDF</a></li>
                                        </ul>
<div id="tab">
 		<table style="float:left" id="customers2" class="table table-hover table-dynamic1">
                      		
                    	 <%
                    		List<String> list = (ArrayList<String>) session.getAttribute("aaa");
 						int i=(Integer)session.getAttribute("length");//126
 						int k=0;//1000
 						int j=44;//43
 						int p=j,l=j;
 						int h=1;
 						if(i>j)
 						{
 							k=(i/7)+1;//2	
 						}
 						else
 						{
 							k=i;
 						}
 						if(k<j)
 						{
 							j=k;
 						}
 						
 						int y=0;
 						int z=0;
 						for(int n=0;n<k;n++)//0 1
 						{
 							%><tr role="row"><% // -1
 									
 								if(n==(p*h))
 								{
 							//		System.out.println("n==(p*h)"+n+"      "+(p*h));
 									j=j+(l*6);
 								//	System.out.println("j="+j);
 									h++;
 								}
 									
 									
 									
 									
 								for(int x=0;x<=6;x++)
 								{
 								
 									if(n<=43)
 									{
 										y=(j*x)+n;
 									}
 									else
 									{
 										y=j+(l*x)+n-44;//44
 									}
 									//	System.out.println(y);
 								
 								
	 								if(y<i)
	 								{
	 									String s=list.get(y);
	 									if(!s.matches("[0-9]+") == false && s.length() > 2)
	 									{
	 										%><td width=105px style="color:#3C3C43font-size:15px"><%=s %><%
	 														
	 									}
	 									else if(s.length()>2)
	 									{					
	 										%><td width=105px style="font-weight:900;"><u><%=s %></u></td><%
	 												
	 									}
	 									else
	 									{
	 										%><td width=105px style="font-weight:900;"><%=s%></td><%
	 												
	 									}
	 									
 								}
 							}
 							%></tr><%
 							z++;
 							
 						}

						%>						


	 </table>

</div>
</body>
</html>