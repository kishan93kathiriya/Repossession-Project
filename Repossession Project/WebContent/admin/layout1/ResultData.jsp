<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
         <div class="header">
            <h2><strong>Vehicle List</strong></h2>
           
           <form action="<%=request.getContextPath() %>/ResultSortController" method="get" >
           
           <input type="submit" name="SortData" value="Sort Data" class="btn btn-success" style="margin-left: 880px"/>
           
           </form> 
           
            </div>
            
          <div class="row">
            <div class="col-lg-12 portlets">
              <div class="panel">
                 <div class="panel-content pagination2 table-responsive">
                  <table class="table table-hover table-dynamic">
                    <thead>
                      <tr >
                         <th style="font-size:14px;"><b>Loan No</b></th>
						 <th style="font-size:14px;"><b>Customer Name</b></th>
						 <th style="font-size:14px;"><b>Reg No</b></th>
						 <th style="font-size:14px;"><b>Model</b></th>
						 <th style="font-size:14px;"><b>Chasis No.</b></th>
						 <th style="font-size:14px;"><b>Engine No.</b></th>
						 <th style="font-size:14px;"><b>Contact</b></th>
						 <th style="font-size:14px;"><b>Bank</b></th>
						 <th style="font-size:14px;"><b>Date</b></th>
						 <th style="font-size:14px;"><b>Status</b></th>
                      
                      </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="${sessionScope.resultlist}" var="i" >
                          	<tr>
	                           <td >${i.loanNo }</td>
	                          <td >${i.customerName }</td>
	                          <td >${i.reg_No}</td>
	                      		<td >${i.model }</td>
	                          <td >${i.chasis_No }</td>
	                          <td width="100px;">${i.engine_No }</td>
	                          <td >${i.contact}</td>
	                       
	                          <td >${i.bank}</td>
	                          <td >${i.date}</td>
	                          
	                         <td><a class="delete btn btn-sm btn-danger" href="<%=request.getContextPath()%>/datasheet?flag=caught&loanNo=${i.loanNo}&reg=${i.reg_No}&chasis_No=${i.chasis_No }&engine_No=${i.engine_No}">Caught</a></td>
	                        </tr> 
	                    </c:forEach>
                    </tbody>
                  </table>
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
    
    <!-- BEGIN PRELOADER -->
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
