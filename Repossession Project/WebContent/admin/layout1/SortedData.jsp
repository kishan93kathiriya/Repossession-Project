<%@page import="com.restfb.types.Page"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="TK-KK-HP">
    <meta name="author" content="TK-KK-HP">
    <link rel="shortcut icon" href="../assets/global/images/favicon.png" type="image/png">
    
    <title>Poniya Agency</title>
    
    <link href="../assets/global/css/style.css" rel="stylesheet">
    <link href="../assets/global/css/theme.css" rel="stylesheet">
    <link href="../assets/global/css/ui.css" rel="stylesheet">
    <link href="../assets/admin/layout1/css/layout.css" rel="stylesheet">
    
    <!-- BEGIN PAGE STYLE -->
    <link href="../assets/global/plugins/metrojs/metrojs.min.css" rel="stylesheet">
    <link href="../assets/global/plugins/maps-amcharts/ammap/ammap.min.css" rel="stylesheet">
    <!-- END PAGE STYLE -->
    
    <script src="../assets/global/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="../assets/global/js/pdf/jspdf.debug.js"></script>
        <script src="../assets/global/js/pdf/jquery-git.js"></script>
    
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <script type="text/javascript">

    /*     function printDiv(divName) {
    
    var printContents = document.getElementById(divName).innerHTML;
    w=window.open();
    w.document.write(printContents);
    w.print();
    w.close();
   }
*/    function printDiv(divName) {
       var printContents = document.getElementById(divName).innerHTML;
       var originalContents = document.body.innerHTML;

       document.body.innerHTML = printContents;

       window.print();

       document.body.innerHTML = originalContents;
  }

   
    
	</script>



</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>


<body class="fixed-topbar fixed-sidebar theme-sdtl color-default dashboard">
	
	<section>
    	<!-- BEGIN SIDEBAR -->
      		<%@ include file="a_menu.jsp" %>
        <!-- END SIDEBAR -->
      
      	<div class="main-content">
	        <!-- BEGIN TOPBAR -->
	        	<%@ include file="a_header.jsp" %>
	        <!-- END TOPBAR -->
        
        <!-- BEGIN PAGE CONTENT -->
        <div class="page-content">
          
          <div class="row">
            <div class="col-lg-12 portlets">
              <div>
                <div>
                  <h3>
                  	<i class="fa fa-table" style="font-size: 20px"></i> <strong style="font-size: 20px">Sorted Data </strong> 
					<input type="button" class="btn btn-dark btn-embossed" onclick="printDiv('course')" style="margin-left: 40px"value="Generate PDF"/>
                  </h3>
                  <h4><strong>Registration Number</strong></h4>
                </div>
                <div class="panel-content">
                 	
                 	<div id="course">
                    	<div>
                    		<table style="float:left" id="tab" >
                      		
                    	 <%
                    	 List<String> list = (ArrayList<String>) session.getAttribute("aaa");
                    	 int i=(Integer)session.getAttribute("length");//126
                    	 int k=0;//
                    	 
  						int pageX=(i/329);
                    	 System.out.println("Total Page ="+pageX);
  						String[][] val=new String[pageX][7];
  						val[0][0]=list.get(0);
  						for(int ix=0;ix<pageX;ix++)
  						{
  							int p=0;
  							for(int kx=(ix*7);kx<(ix*7)+7;kx++)
  							{
  								
  								String pp=null;
  								for(int jx=kx*48;jx<(kx*48)+48;jx++)
  								{
  									if(jx<i)
  									{
	  									if(!list.get(jx).matches("[0-9]+") == true && list.get(jx).length() > 2)
		 									{
		 										
	  												pp=list.get(jx);
		 														
		 									}
  									}
  								}
  								if(pp!=null && ix<pageX-1)
  								{

  									if(p==6 ){
  										val[ix+1][0]=pp;	
  									}
  									else
  									{
  										val[ix][p+1]=pp;
  									}
  								}
  								else if(ix<pageX-1)
  								{
  									if(p==6)
  									{
  										val[ix+1][0]=val[ix][6];
  									}
  									else
  									{
  										val[ix][p+1]=val[ix][p];
  									}
  								}
  								/* System.out.println(" val ["+ix+"]["+p+"]"+val[ix][p]); */
  								p++;
  							}
  						}
  						int p=48,l=48,j=48;// p=48 l=48
  						int h=1;
  						if(i>j)//1
  						{
  							k=(i/7)+1;//2	
  						}
  						else
  						{
  							k=i;//
  						}
  						if(k<j)
  						{
  							j=k;
  						}
  						
  						
  						int y=0;
  						int PageNo=0;
  						int zx=1;
  						int zp=0;
  						int pagexx=0;
  						int zpp=0;
  						for(int n=0;n<k;n++)//0 1
  						{
  							
  							%><tr role="row"><% // -1
  									
  								System.out.println(zpp);
  								if(n==48*zx-1)
  								{
  								%><td>&nbsp;&nbsp;&nbsp; </td><td>&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;</td><%	
  								zx++;
  								zp++;
  								n=n-1;
  								
  								}
  								else if(n==48*zpp)
								{
									System.out.println("N value is"+n);
									%>
									
									<td width=105px style="font-weight: 900;font-size: 14px"><u><%=val[pagexx][0] %></u></td>
									<td width=105px style="font-weight: 900;font-size: 14px"><u><%=val[pagexx][1] %></u></td>
									<td width=105px style="font-weight: 900;font-size: 14px"><u><%=val[pagexx][2] %></u></td>
									<td width=105px style="font-weight: 900;font-size: 14px"><u><%=val[pagexx][3] %></u></td>
									<td width=105px style="font-weight: 900;font-size: 14px"><u><%=val[pagexx][4] %></u></td>
									<td width=105px style="font-weight: 900;font-size: 14px"><u><%=val[pagexx][5] %></u></td>
									<td width=105px style="font-weight: 900;font-size: 14px"><u><%=val[pagexx][6] %></u></td><%
									pagexx++;
									zpp++;
									n--;
								}
							
  								else
  								{
  									System.out.println("n is ="+n);
 	 								if(n==(p*h))
 	 								{
 	 							//		System.out.println("n==(p*h)"+n+"      "+(p*h));
 	 									j=j+(l*6);
 	 								//	System.out.println("j="+j);
 	 									h++;
 	 								}
 	 									
 	 								PageNo =k-((l*(h-1))+1)+1;
 	 									
 	 								for(int x=0;x<=6;x++)
 	 								{
 	 								
 	 									if(n<=47)
 	 									{
 	 										y=(j*x)+n;
 	 									}
 	 									else if(PageNo<=48)
										{
 	 										y=j+(PageNo*x)+n-48;
										}
 	 									else
 	 									{
 	 										y=j+(l*x)+n-48;//44
 	 									}
 	 									//	System.out.println(y);
 	 								
 	 								
 	 							
 	 									if(y<i)
 		 								{
 		 									String s=list.get(y);
 		 									if(!s.matches("[0-9]+") == false && s.length() > 2)
 		 									{
 		 										%><td width=105px style="color:#484848; font-weight: 400"><%=s %><%
 		 														
 		 									}
 		 									else if(s.length()>2)
 		 									{					
 		 										%><td width=105px style="font-weight: 900;font-size: 14px"><u><%=s %></u></td><%
 		 												
 		 									}
 		 									else
 		 									{
 		 										%><td width=105px style="font-weight: 700;"><%=s%></td><%
 		 												
 		 									}
 		 									
 	 									}
 		 								
 	 								}
  								}
 	 							%></tr><%
  							
  						}

 						%>						


 	 </table>
 <h3 style="color: red;">KINDLY CHECK CHESIS NUMBER AND ENGINE NUMBERS OF THE VEHICLE</h3>	                 
	 </table>
	                 
                    	</div>
                  	</div>
                 	
                 	
                   <!-- hidden -->
                    	
                    	
                  	</div>
                  	<c:out value="${counter}"></c:out>
                </div>
              </div>
            </div>
          </div>
          
          
          <div class="footer">
            <div class="copyright">
              <p class="pull-left sm-pull-reset">
                <span>Copyright <span class="copyright">�</span> 2015 </span>
                <span>PONIYA AGENCY</span>.
                <span>All rights reserved. </span>
              </p>
              <!-- <p class="pull-right sm-pull-reset">
                <span><a href="#" class="m-r-10">Support</a> | <a href="#" class="m-l-10 m-r-10">Terms of use</a> | <a href="#" class="m-l-10">Privacy Policy</a></span>
              </p> -->
            </div>
          </div>
        </div>
        <!-- END PAGE CONTENT -->
      </div>
      <!-- END MAIN CONTENT -->
      
      
    </section>
    <!-- END PRELOADER -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/jquery/jquery-1.11.1.min.js"></script>
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/jquery/jquery-migrate-1.2.1.min.js"></script>
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/jquery-ui/jquery-ui-1.11.2.min.js"></script>
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/gsap/main-gsap.min.js"></script>
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/jquery-cookies/jquery.cookies.min.js"></script> <!-- Jquery Cookies, for theme -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/jquery-block-ui/jquery.blockUI.min.js"></script> <!-- simulate synchronous behavior when using AJAX -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/bootbox/bootbox.min.js"></script> <!-- Modal with Validation -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/mcustom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script> <!-- Custom Scrollbar sidebar -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/bootstrap-dropdown/bootstrap-hover-dropdown.min.js"></script> <!-- Show Dropdown on Mouseover -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/charts-sparkline/sparkline.min.js"></script> <!-- Charts Sparkline -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/retina/retina.min.js"></script> <!-- Retina Display -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/select2/select2.min.js"></script> <!-- Select Inputs -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/icheck/icheck.min.js"></script> <!-- Checkbox & Radio Inputs -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/backstretch/backstretch.min.js"></script> <!-- Background Image -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/bootstrap-progressbar/bootstrap-progressbar.min.js"></script> <!-- Animated Progress Bar -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/charts-chartjs/Chart.min.js"></script>
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/builder.js"></script> <!-- Theme Builder -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/sidebar_hover.js"></script> <!-- Sidebar on Hover -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/application.js"></script> <!-- Main Application Script -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/plugins.js"></script> <!-- Main Plugin Initialization Script -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/widgets/notes.js"></script> <!-- Notes Widget -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/quickview.js"></script> <!-- Chat Script -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/pages/search.js"></script> <!-- Search Script -->
    <!-- BEGIN PAGE SCRIPTS -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/datatables/jquery.dataTables.min.js"></script> <!-- Tables Filtering, Sorting & Editing -->
    <script src="<%=request.getContextPath() %>/admin/assets/global/js/pages/table_dynamic.js"></script>
    <!-- END PAGE SCRIPTS -->
        <script src="<%=request.getContextPath() %>/admin/assets/admin/layout1/js/layout.js"></script>

</body>
</html>