<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*" %>
    <%@page import="java.text.SimpleDateFormat"%>
<html lang="en">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
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
    <script type="text/javascript"  >  
   
    
	</script>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!-- BEGIN BODY -->
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
         <div class="header col-md-8">
         <% Date d = new Date();
SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
String s = ft.format(d);%>

                                         
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-transparent">
            <div class="panel-body">
                <div class="clearfix">
                    <div class="pull-left">
                        
                    </div>
                    <div align="center">
                        <h1 class="text-primary">
                            INVOICE
                           
                        </h1>
                    </div>
                </div>
   
                  
                <div class="row mb-xl">
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="panel-body no-padding">
                                <div class="table-responsive">
                                    <%
                                    
                                    String  loan=(String)request.getParameter("loanNo");
                                    String  reg=(String)request.getParameter("reg"); 
                                    String  model=(String)request.getParameter("model");
                                    String  bank=(String)request.getParameter("bank");
                                    session.setAttribute("loan", loan);
                                    session.setAttribute("bank", bank);
                                    session.setAttribute("reg", reg);
                                    session.setAttribute("model", model);
                                    %>
	
								<form action="<%=request.getContextPath() %>/InvoiceController" method="post">
										<input type="hidden" name="flag" id="flag" value="invoiceBill"/>
										<table class="table table-hover m-n">
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Loan No</td>
                                                <td><%=(String)request.getParameter("loanNo") %></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Hirer's Name</td>
                                                <td><input type="text" name="hirer" placeholder="Hirer's Name"/></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Vehicle No</td>
                                                <td><%=(String)request.getParameter("reg") %></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Make / Model</td>
                                                <td><%=(String)request.getParameter("model") %></td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Vehicle Repossessed On</td>
                                                <td><input type="text" name="repossesed" placeholder="Repossesed on"/></td>
                                            </tr>
                                            <tr>
                                                <td>6</td>
                                                <td>Place</td>
                                                <td><input type="text" name="place" placeholder="Place"/></td>
                                            </tr>
                                            
                                            <tr>
                                                <td>7</td>
                                                <td>Police Station</td>
                                                <td><input type="text" name="policestation" placeholder="Police Station"/></td>
                                            </tr>
                                            <tr>
                                                <td>8</td>
                                                <td>Parked At</td>
                                                <td><input type="text" name="parked" placeholder="Parked at"/></td>
                                            </tr>
                                            <tr>
                                                <td>9</td>
                                                <td>Repossession Charges</td>
                                                <td><input type="text" name="repcharge" placeholder="Repossesion Charge"/></td>
                                            </tr>
                                            <tr>
                                                <td>10</td>
                                                <td>Any Extra Charges (CRANE)</td>
                                                <td><input type="text" name="extracharge" placeholder="Extra Charge"/></td>
                                            </tr>
                                            <tr>
                                                <td>11</td>
                                                <td>Service Tax</td>
                                                <td><input type="text" name="tax" placeholder="Service Tax"/></td>
                                            </tr>
                                            <tr>
                                                <td>12</td>
                                                <td>Total Repossession Charges</td>
                                                <td><input type="text" name="total" placeholder="Total Charge"/></td>
                                            </tr>
                                            <tr>
                                                <td>13</td>
                                                <td>Rupees In Word</td>
                                                <td><input type="text" name="word" placeholder="Rupees In Words"/></td>
                                            </tr>
                                                                                    </tbody>
                                    </table>
                                    
				<input type="submit" name="submit" value="Submit" class="btn btn-primary" /> 
				</form>
                                </div>
                            </div>
                        </div>
                    </div>
				
	
                </div>
                    
              

            </div>

        </div>

    </div>

                            </div>  <div class="footer">
            <div class="copyright">
              <p class="pull-left sm-pull-reset">
                <span>Copyright <span class="copyright">©</span> 2015 </span>
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
      <!-- END MAIN CONTENT -->
      
      
    </section>
    
    <div class="loader-overlay">
      <div class="spinner">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
      </div>
    </div>
    <!-- END PRELOADER -->
    <script src="../assets/global/plugins/jquery/jquery-1.11.1.min.js"></script>
    <script src="../assets/global/plugins/jquery/jquery-migrate-1.2.1.min.js"></script>
    <script src="../assets/global/plugins/jquery-ui/jquery-ui-1.11.2.min.js"></script>
    <script src="../assets/global/plugins/gsap/main-gsap.min.js"></script>
    <script src="../assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../assets/global/plugins/jquery-cookies/jquery.cookies.min.js"></script> <!-- Jquery Cookies, for theme -->
    <script src="../assets/global/plugins/jquery-block-ui/jquery.blockUI.min.js"></script> <!-- simulate synchronous behavior when using AJAX -->
    <script src="../assets/global/plugins/bootbox/bootbox.min.js"></script> <!-- Modal with Validation -->
    <script src="../assets/global/plugins/mcustom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script> <!-- Custom Scrollbar sidebar -->
    <script src="../assets/global/plugins/bootstrap-dropdown/bootstrap-hover-dropdown.min.js"></script> <!-- Show Dropdown on Mouseover -->
    <script src="../assets/global/plugins/charts-sparkline/sparkline.min.js"></script> <!-- Charts Sparkline -->
    <script src="../assets/global/plugins/retina/retina.min.js"></script> <!-- Retina Display -->
    <script src="../assets/global/plugins/select2/select2.min.js"></script> <!-- Select Inputs -->
    <script src="../assets/global/plugins/icheck/icheck.min.js"></script> <!-- Checkbox & Radio Inputs -->
    <script src="../assets/global/plugins/backstretch/backstretch.min.js"></script> <!-- Background Image -->
    <script src="../assets/global/plugins/bootstrap-progressbar/bootstrap-progressbar.min.js"></script> <!-- Animated Progress Bar -->
    <script src="../assets/global/plugins/charts-chartjs/Chart.min.js"></script>
    <script src="../assets/global/js/builder.js"></script> <!-- Theme Builder -->
    <script src="../assets/global/js/sidebar_hover.js"></script> <!-- Sidebar on Hover -->
    <script src="../assets/global/js/application.js"></script> <!-- Main Application Script -->
    <script src="../assets/global/js/plugins.js"></script> <!-- Main Plugin Initialization Script -->
    <script src="../assets/global/js/widgets/notes.js"></script> <!-- Notes Widget -->
    <script src="../assets/global/js/quickview.js"></script> <!-- Chat Script -->
    <script src="../assets/global/js/pages/search.js"></script> <!-- Search Script -->
    <!-- BEGIN PAGE SCRIPTS -->
    <script src="../assets/global/plugins/datatables/jquery.dataTables.min.js"></script> <!-- Tables Filtering, Sorting & Editing -->
    <script src="../assets/global/js/pages/table_dynamic.js"></script>
    <!-- END PAGE SCRIPTS -->
        <script src="../assets/admin/layout1/js/layout.js"></script>
  </body>

</html>
