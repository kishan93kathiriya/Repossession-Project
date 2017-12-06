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
					SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
					String s = ft.format(d);
					
					String loan=(String) session.getAttribute("loan");
					String bank=(String) session.getAttribute("bank");
					String reg=(String) session.getAttribute("reg");    
					String model=(String) session.getAttribute("model");
					String hirer= (String) request.getParameter("hirer");
					String repossesed= (String) request.getParameter("repossesed");
					String place= (String) request.getParameter("place");
					String policestation= (String) request.getParameter("policestation");
					String parked= (String) request.getParameter("parked");
					String repcharge= (String) request.getParameter("repcharge");
					String extracharge= (String) request.getParameter("extracharge");
					String tax= (String) request.getParameter("tax");
					String total=(String) request.getParameter("total");
					String word= (String) request.getParameter("word");
					

               	 Class.forName("com.mysql.jdbc.Driver");
            		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
            		Statement st=con.createStatement();
            		ResultSet rs=st.executeQuery("SELECT MAX(bill_No) AS COUNT FROM bill_list");
            		rs.next();
            		int count=rs.getInt(1);
					

%>

<input type="button" class="btn btn-primary" onclick="printDiv('invoice')" name="Print" Value="Print"/>
                        
                                         
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-transparent">
            <div class="panel-body" id="invoice">
                <div class="row mb-xl">
                    <div class="col-md-12">
                        <div class="pull-left">
                            <h4>&nbsp;&nbsp;&nbsp;To,</h4>
                            <address>
                                
                                <strong>RELIANCE CAPITAL LTD.</strong><br/> 	
								570, Rectifier House, 3rd Floor,<br/>	
								Naigaum Cross Road, Next to 	<br/>
								Royal Industrial Estate,	<br/>
								Wadala, Mumbai-400031	<br/>
							</address>
                        </div>
                        <div class="pull-right">
                            <h3>Info</h3>
                            <ul class="text-left list-unstyled">
                                <li style="font: bold;"><strong>Bill No: </strong>&nbsp;&nbsp;<%=count %></li>
                                <li><strong>Date:  </strong><%=s %></li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
              
                
                <div class="row mb-xl">
                    <div class="col-md-12">
                        <div class="panel">
                            <div >
                                <div class="table-responsive">
                                    
	
										<table class="table table-hover">
                                        <th colspan="3">
              									    &nbsp;&nbsp;&nbsp;&nbsp;Dear Sir,<br/>		
													&nbsp;&nbsp;&nbsp;&nbsp;With reference to your order dated we have repossessed the under mentioned
													&nbsp;&nbsp;&nbsp;&nbsp;vehicle. The details are as under.		                              
                							</th>	
                                          <tr>
                                                <td>1</td>
                                                <td>Loan No</td>
                                                <td><%=loan%></td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Hirer's Name</td>
                                                <td><%=hirer %></td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Vehicle No</td>
                                                <td><%=reg%></td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Make / Model</td>
                                                <td><%=model%></td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Vehicle Repossessed On</td>
                                                <td><%=repossesed %></td>
                                            </tr>
                                            <tr>
                                                <td>6</td>
                                                <td>Place</td>
                                                <td><%=place %></td>
                                            </tr>
                                            
                                            <tr>
                                                <td>7</td>
                                                <td>Police Station</td>
                                                <td><%=policestation %></td>
                                            </tr>
                                            <tr>
                                                <td>8</td>
                                                <td>Parked At</td>
                                                <td><%=parked %></td>
                                            </tr>
                                            <tr>
                                                <td>9</td>
                                                <td>Repossession Charges</td>
                                                <td><%=repcharge %></td>
                                            </tr>
                                            <tr>
                                                <td>10</td>
                                                <td>Any Extra Charges (CRANE)</td>
                                                <td><%=extracharge %></td>
                                            </tr>
                                            <tr>
                                                <td>11</td>
                                                <td>Service Tax</td>
                                                <td><%=tax %></td>
                                            </tr>
                                            <tr>
                                                <td>12</td>
                                                <td>Total Repossession Charges</td>
                                                <td><%=total %></td>
                                            </tr>
                                            <tr>
                                                <td>13</td>
                                                <td>Rupees In Word</td>
                                                <td><%=word %></td>
                                            </tr>
                                		
                                    </table>
                              </div>
                            </div>
                        </div>
                    </div>
				
		<div class="pull-left">
                            <address>
                                <strong>Kindly release our payment at the earliest</strong><br/>
                                			PAN NO: ASPPP2617K<br/>
                                			STC: ASPPP2617KSD001<br/>	
                                			<br/>
                                			Thanking You,<br/>	
											For Poniya Agency<br/><br/>
											<strong>Mr. Tejveersingh K. Poniya	</strong><br/>
											<strong>(Proprietor)</strong>
                            </address>
                        </div>

                </div>
                    
                <div class="row">
                    <div class="col-md-12">
                        <div class="pull-right">
                            
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
