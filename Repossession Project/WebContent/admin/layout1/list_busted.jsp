<!DOCTYPE html>
<html lang="en">
	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="TK-KK-HP">
    <meta name="author" content="TK-KK-HP">
    <link rel="shortcut icon" href="<%=request.getContextPath() %>/admin/assets/global/images/favicon.png" type="image/png">
    
    <title>Poniya Agency</title>
    
    <link href="<%=request.getContextPath() %>/admin/assets/global/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/global/css/theme.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/global/css/ui.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/admin/layout1/css/layout.css" rel="stylesheet">
    
    <!-- BEGIN PAGE STYLE -->
    <link href="<%=request.getContextPath() %>/admin/assets/global/plugins/metrojs/metrojs.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/global/plugins/maps-amcharts/ammap/ammap.min.css" rel="stylesheet">
    <!-- END PAGE STYLE -->
    
    <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/js/pdf/jspdf.debug.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/js/pdf/jquery-git.js"></script>
        

</head>
<%@page import="java.sql.*" %>
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
         <div class="header col-lg-4">
            <h2><strong>Caught Vehicles List</strong></h2>
           </div>
           
            <div class="col-lg-4">
            <h2><b>Search Data from this table</b></h2>
            <form action="<%=request.getContextPath() %>/SpecificSearchController" method="get" class="form-inline">
            <input type="hidden" name="table" id="table" value="busted"/>
            <select name="option"><option>Registration No</option><option>Chasis No</option><option>Engine No</option>  <option>Loan No</option></select>
            <input type="text" class="form-control" width=100px name="keyword" id="keyword" placeholder="Enter The Number" />
            <input type="submit" class="btn btn-success" name="Search"/>
            </form>
            </div>
            <%int x=0; if(session.getAttribute("BpageIndex")!=null){ %>
           <strong> Currently Showing Page <b><%x=(Integer)session.getAttribute("BpageIndex");out.print(x); %></b> and data from <%=x*100 %> to <%=(x+1)*100 %></strong>  
		<%	}
		else
		{
		%>	<strong> Currently Showing Page <b>0</b> and data from 0 to 100</strong>
		
		<%} %>  
   
		</div>

			 <div class="row">
            <div class="col-lg-12 portlets">
              <div class="panel">
                 <div class="panel-content pagination2 table-responsive">
                  <table border=1>
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
						 <th style="font-size:14px;"><b>Action</b></th>
						 </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="${sessionScope.bustedlist}" var="i" >
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
                          
                          <c:set var="a" value="1"></c:set>
                         <c:choose>
   								<c:when test="${i.status!= 1}">
   									<c:set var="ans" value="No"/>
     							<td ><a class="label label-danger" href="#">${ans}</a></td>
    							</c:when>
    							<c:otherwise>
     							<c:set var="ans" value="Caught"></c:set>
    								<td >
    									<a class="label label-success" href="#">
    										<i class="fa fa-check"></i>
    										&nbsp;${ans}
    									</a>
    									</td><td>
    									<a class="label label-warning" href="<%=request.getContextPath()%>/datasheet?flag=caught_revert&loanNo=${i.loanNo}&reg=${i.reg_No}" onclick="if(!confirm('Are you sure want to undo the data?')){return false;}">
    										<i class="fa fa-undo"></i>
    										&nbsp;Undo
    									</a>
    									<a class="label label-danger" href="<%=request.getContextPath()%>/datasheet?flag=caught_delete&loanNo=${i.loanNo}&reg=${i.reg_No}" onclick="if(!confirm('Are you sure want to delete the data?')){return false;}">
    										<i class="fa fa-trash-o"></i>
    										&nbsp;Delete
    									</a>
    								</td>
    							</c:otherwise>
						   </c:choose>
                          
                	        </tr> 
            	      </c:forEach>
     		       </tbody>
                 </table>
                </div>
              </div>
            </div>
          </div>
          
          
           <div  class="col-lg-4">
                 <%if((x-1)>=0){%>
                	 <a href="<%=request.getContextPath()%>/BPaginationController?flag=search&RpageNo=<%=(x-1)%>">
                	 <h3 style="color:black; font-size: 20px">&lt;&lt;Previous Page</h3>
                	 </a>
                 <%
                 }%>
                  </div>
          <div class="col-lg-4" style="float:left">
          		Jump to page: 
          		<form action="<%=request.getContextPath() %>/BPaginationController" method="get">
          			<select name="BpageNo">
                	
                     <%
                     ResultSet rs;
                     int count=0;
                     if(request.getAttribute("countAll")!=null)
                     {
                    	 
                     }
                     else
                     {
                    	 Class.forName("com.mysql.jdbc.Driver");
                 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/poniyaag_bank","root","");
                 		Statement st=con.createStatement();
                 		rs=st.executeQuery("select count(id) AS count from list_vehicles where status='1'");
                 		rs.next();
                 		count=rs.getInt(1);
                 		
                     }
                    
                     double j=0;
                     if(count%100==0)
                     {
                    	 
                    	 j=(count/100);
                     }
                     else
                     {
                    	 
                    	 j=Math.ceil((float)count/100);	 
                     }
                     
                     int RpageNo=0;
                     
                   if(session.getAttribute("BpageIndex")!=null)
                   {

                	   RpageNo=(Integer)session.getAttribute("BpageIndex");
                	   
                   }
                    
                     for(int i=0;i<j;i++)
                     {
                    	 if(i==RpageNo)
                    	 {
                    		 %><option selected><%=i %></option><%	 
                    	 }
                    	 else
                    	 {
                    		 %><option><%=i %></option><%
                    	 }
                    	 
                     }
                     %>
                     
                     </select>
                    <input type="submit" name="go" value="Go"/>  
                 </form>
                 </div>
                 <div style="float:right" class="col-lg-3">
               <%
               
               
               if((x+1)<j){ %>  
                  <a href="<%=request.getContextPath()%>/BPaginationController?flag=search&RpageNo=<%=(x+1)%>">
                	 <h3 style="color:black; font-size: 20px">Next Page &gt;&gt;</h3>
                	 </a>
                	 <%} %>
                </div>
         
          
          
          
          
          
          <div class="footer">
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
      </div>
      <!-- END MAIN CONTENT -->
      
      
    </section>
    
    
    <!-- BEGIN SEARCH -->
    <div id="morphsearch" class="morphsearch">
      <form class="morphsearch-form">
        <input class="morphsearch-input" type="search" placeholder="Search..."/>
        <button class="morphsearch-submit" type="submit">Search</button>
      </form>
      <div class="morphsearch-content withScroll">
        <%-- <div class="dummy-column user-column">
          <h2>Users</h2>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/avatars/avatar1_big.png" alt="Avatar 1"/>
            <h3>John Smith</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/avatars/avatar2_big.png" alt="Avatar 2"/>
            <h3>Bod Dylan</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/avatars/avatar3_big.png" alt="Avatar 3"/>
            <h3>Jenny Finlan</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/avatars/avatar4_big.png" alt="Avatar 4"/>
            <h3>Harold Fox</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/avatars/avatar5_big.png" alt="Avatar 5"/>
            <h3>Martin Hendrix</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/avatars/avatar6_big.png" alt="Avatar 6"/>
            <h3>Paul Ferguson</h3>
          </a>
        </div>
        <div class="dummy-column">
          <h2>Articles</h2>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/1.jpg" alt="1"/>
            <h3>How to change webdesign?</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/2.jpg" alt="2"/>
            <h3>News From the sky</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/3.jpg" alt="3"/>
            <h3>Where is the cat?</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/4.jpg" alt="4"/>
            <h3>Just another funny story</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/5.jpg" alt="5"/>
            <h3>How many water we drink every day?</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/6.jpg" alt="6"/>
            <h3>Drag and drop tutorials</h3>
          </a>
        </div>
        <div class="dummy-column">
          <h2>Recent</h2>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/7.jpg" alt="7"/>
            <h3>Design Inspiration</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/8.jpg" alt="8"/>
            <h3>Animals drawing</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/9.jpg" alt="9"/>
            <h3>Cup of tea please</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/10.jpg" alt="10"/>
            <h3>New application arrive</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/11.jpg" alt="11"/>
            <h3>Notification prettify</h3>
          </a>
          <a class="dummy-media-object" href="#">
            <img src="<%=request.getContextPath() %>/admin/assets/global/images/gallery/12.jpg" alt="12"/>
            <h3>My article is the last recent</h3>
          </a>
        </div> --%>
      </div>
      <!-- /morphsearch-content -->
      <span class="morphsearch-close"></span>
    </div>
    <!-- END SEARCH -->
    <!-- BEGIN PRELOADER -->
    <div class="loader-overlay">
      <div class="spinner">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
      </div>
    </div>
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
