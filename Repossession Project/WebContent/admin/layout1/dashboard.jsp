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
    <style>.aaa{background:#ffffff;}</style>
  <%-- <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/modernizr/modernizr-2.6.2-respond-1.1.0.min.js"></script> --%>
   
    <script type="text/javascript">

    function x(){
    	
    		var x=document.getElementById("b_name").value;
    	
    	//	alert("hehehi"+x+"kk");
    		
    	if(x === null || x == "")
    		{
    	 alert("Please enter correct bank name");
    	}
    	else
    		{
    		document.forms["upload"].submit();
    		}
    	
    }
    function filter() {
     
    	var value = document.getElementById("filterlist").value;
    	
    	
    	if(value=="byDate")
    	{
    		var div1 = document.getElementById("date");
    		div1.style.display = "";
        	var div = document.getElementById("bank");
        	div.style.display = "none";
    	}
    	if(value=="byBank")
    	{
    		var div = document.getElementById("bank");
    		div.style.display = "";
        	var div1 = document.getElementById("date");
        	div1.style.display = "none";
    	}
    	if(value=="byBoth")
    	{
    		var div1 = document.getElementById("date");
    		div1.style.display = "";
        	var div = document.getElementById("bank");
        	div.style.display = "";
    	}
    	
    }
    function filterX() {
     
    	var value = document.getElementById("deletelist").value;
    	
    	if(value=="byBank")
    	{
    		var div = document.getElementById("delbank");
    		div.style.display = "";
        	var div1 = document.getElementById("deldate");
        	div1.style.display = "none";
    	}
    	if(value=="byBoth")
    	{
    		var div1 = document.getElementById("deldate");
    		div1.style.display = "";
        	var div = document.getElementById("delbank");
        	div.style.display = "";
    	}
    	
    }
    
    function add_replace(){
    	var x=document.getElementsById("sex").value;
    	alert(x);
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
        		<div class="row">
            		<div class="col-lg-12 portlets">
              			<div class="panel">
                			<div class="panel-header panel-controls">
                  				<h2>Dash<strong>Board</strong></h2>
                			</div>
                			<div class="panel-content">
                				<div class="row">
		        					<div class="col-md-6">
		        						<form id="upload" action="<%=request.getContextPath() %>/YourController" method="post" >
											<p style="color:gray;font-size:16px;">*Choose file > Click on Upload > Enter Bank Name > Click on Submit.</p>
											<iframe class="aaa" src="fileupload.jsp" width="100%" height="200" style="border:0;background:#fff;" scrolling="no" allowtransparency="true"> </iframe>
											<div style="clear:left">
											<br>
											<input type="radio" name="option" id="option" value="add" checked><b>Add this file to existing file</b><br>
											<input type="radio" name="option" id="option" value="replace"><b>Replace/Delete all the previous data from this bank and add this new file</b><br><br>
												Enter Bank Name:
												<br/>
												<select id="b_name" name="bankName" style="width:450px;border:none; border-bottom:2px solid #28aacc;" >
															<option value="none">----Select Bank Name----</option>
															<option value="SUNDARAM FINANCE">SUNDARAM FINANCE</option>
															<option value="Kotak Mahindra Bank L T D">Kotak Mahindra Bank L T D</option>
															<option value="HDB FINANCIAL SERVICES">HDB FINANCIAL SERVICES</option>
															<option value="HINDUJA LEYLAND FINANCE">HINDUJA LEYLAND FINANCE</option>
															<option value="MAGMA FINCORP LTD.">MAGMA FINCORP LTD.</option>
															<option value="EQUITAS FINANCE PVT LTD">EQUITAS FINANCE PVT LTD</option>
															<option value="MANAN FINANCEAL SERVICE PVT. LTD.">MANAN FINANCEAL SERVICE PVT. LTD.</option>
															<option value="L & T FINANCE LIMITED">L & T FINANCE LIMITED</option>
															<option value="RELIANCE CAPITAL  LTD.">RELIANCE CAPITAL  LTD.</option>
															<option value="CHOLAMANDALAM INVESTMENT & FINANCE LTD.">CHOLAMANDALAM INVESTMENT & FINANCE LTD.</option>
															<option value="INDIAN INFO LINE FINANCE LTD.">INDIAN INFO LINE FINANCE LTD.</option>
															<option value="CITI CORP. FINANCE INDIA LTD.">CITI CORP. FINANCE INDIA LTD.</option>
															<option value="DCB BANK">DCB BANK</option>
															<option value="INDUSIND BANK L T D">INDUSIND BANK L T D</option>
															<option value="RELIGARE FINVEST LIMITED">RELIGARE FINVEST LIMITED</option>
															<option value="I  K  F  FINANCE">I  K  F  FINANCE</option>
															<option value="SHRIRAM FINANCE">SHRIRAM FINANCE</option>
															<option value="AU FINANCE">AU FINANCE</option>
															<option value="Fullerton India Credit Co Ltd">Fullerton India Credit Co Ltd</option>
															<option value="MAHINDRA & MAHINDRA FINANCE">MAHINDRA & MAHINDRA FINANCE</option>
															<option value="MAS FINANCIAL SERVICES LTD.">MAS FINANCIAL SERVICES LTD.</option>
															<option value="TVS CREDIT SERVICE LIMITED">TVS CREDIT SERVICE LIMITED</option>
															<option value="INDIABULLS COMMERCIAL CREDIT LTD.">INDIABULLS COMMERCIAL CREDIT LTD./<option>
														</select>
													<br/>	
												<input type="button" value="Submit" class="btn btn-primary btn-rounded" onclick="x()"/>
												
											</div>
											<%-- <%@ include file="fileupload.jsp" %> --%>
<!-- 											<input type="hidden" name="mode" value="1"/>  -->
												<input type="hidden" name="mode" value="11"/> 
										</form>
									</div>
									<div class="col-md-6">
		        						<form action="<%=request.getContextPath() %>/SearchController" method="post" >
											<p style="color:green;font-size:16px;"></p>
											<div  style="border:0;background-color:#eaeaea;padding: 5px;">
												<h2 style="color:green;"><b>Search Data</b></h2>
												<hr><p>
												<strong>Select Table Name:</strong>
													<select name="tablename" style="width: 200px" id="tablename">
														<option value="-1">Total Vehicles List</option>
														<option value="0">Remaining Vehicles List</option>
														<option value="1">Busted Vehicles List</option>
													</select>
												</p>
												<p>
													<strong>Search Data by :</strong>
													<select name="filterlist" style="width: 200px" id="filterlist">
														<option value="byBank">By Bank</option>
														<option value="byDate">By Date</option>
														<option value="byBoth">By Bank and Date</option>
													</select>
													<button type="button" style="margin-left: 10px" onclick="filter()">go</button>
													<br/>
												</p>
												<div id="bank" style="display: none;" class="row">
												<input type="hidden" name="flag" id="flag" />
												
													<div class="col-md-12">
														<div class="col-md-3">Bank Name :</div>
														<div class="col-md-8">
														<select name="bank" style="width:361px">
															<option value="none">----Select Bank Name----</option>
															
															<option value="SUNDARAM FINANCE">SUNDARAM FINANCE</option>
															<option value="Kotak Mahindra Bank L T D">Kotak Mahindra Bank L T D</option>
															<option value="HDB FINANCIAL SERVICES">HDB FINANCIAL SERVICES</option>
															<option value="HINDUJA LEYLAND FINANCE">HINDUJA LEYLAND FINANCE</option>
															<option value="MAGMA FINCORP LTD.">MAGMA FINCORP LTD.</option>
															<option value="EQUITAS FINANCE PVT LTD">EQUITAS FINANCE PVT LTD</option>
															<option value="MANAN FINANCEAL SERVICE PVT. LTD.">MANAN FINANCEAL SERVICE PVT. LTD.</option>
															<option value="L & T FINANCE LIMITED">L & T FINANCE LIMITED</option>
															<option value="RELIANCE CAPITAL  LTD.">RELIANCE CAPITAL  LTD.</option>
															<option value="CHOLAMANDALAM INVESTMENT & FINANCE LTD.">CHOLAMANDALAM INVESTMENT & FINANCE LTD.</option>
															<option value="INDIAN INFO LINE FINANCE LTD.">INDIAN INFO LINE FINANCE LTD.</option>
															<option value="CITI CORP. FINANCE INDIA LTD.">CITI CORP. FINANCE INDIA LTD.</option>
															<option value="DCB BANK">DCB BANK</option>
															<option value="INDUSIND BANK L T D">INDUSIND BANK L T D</option>
															<option value="RELIGARE FINVEST LIMITED">RELIGARE FINVEST LIMITED</option>
															<option value="I  K  F  FINANCE">I  K  F  FINANCE</option>
															<option value="SHRIRAM FINANCE">SHRIRAM FINANCE</option>
															<option value="AU FINANCE">AU FINANCE</option>
															<option value="Fullerton India Credit Co Ltd">Fullerton India Credit Co Ltd</option>
															<option value="MAHINDRA & MAHINDRA FINANCE">MAHINDRA & MAHINDRA FINANCE</option>
															<option value="MAS FINANCIAL SERVICES LTD.">MAS FINANCIAL SERVICES LTD.</option>
															<option value="TVS CREDIT SERVICE LIMITED">TVS CREDIT SERVICE LIMITED</option>
															<option value="INDIABULLS COMMERCIAL CREDIT LTD.">INDIABULLS COMMERCIAL CREDIT LTD./<option>
														</select>
														</div>
													</div>
												</div>
												<div id="date" style="display: none;" class="row">
													<div class="col-md-12">
														<div class="col-md-3">From :</div> 
														<div class="col-md-8"><input type="date" class="date-picker form-control hasDatepicker" name="fromDate"></div>
													</div>
													<div class="col-md-12">
														<div class="col-md-3"> To :</div>
														<div class="col-md-8"><input type="date" class="date-picker form-control hasDatepicker" name="toDate"></div>
													</div>
												</div><br/><br/>
												<button type="submit" value="Upload File" class="btn btn-dark ">
													Search
												</button>
											</div>
										</form>
									</div>
								
								
								<div class="col-md-6">
		        						<form action="<%=request.getContextPath() %>/deleteController" method="post" >
											<p style="color:red;font-size:16px;"></p>
											<div  style="border:0;background-color:#eaeaea;padding: 5px;">
												<h2 style="color:red;"><b>Delete Data</b></h2>
												<hr>
												<p>
													<strong>Delete Data by :</strong>
													<select name="deleteList" style="width: 200px" id="deletelist">
														<option value="byBank">By Bank</option>
													<option value="byBoth">By Bank and Date</option>
													</select>
													<button type="button" style="margin-left: 10px" onclick="filterX()">go</button>
													<br/>
												</p>
												<div id="delbank" style="display: none;" class="row">
												<input type="hidden" name="flag" id="flag" />
												
													<div class="col-md-12">
														<div class="col-md-3">Bank Name :</div>
														<div class="col-md-8">
														
															<select name="bank" style="width:361px">
															<option value="none">----Select Bank Name----</option>
															
															<option value="SUNDARAM FINANCE">SUNDARAM FINANCE</option>
															<option value="Kotak Mahindra Bank L T D">Kotak Mahindra Bank L T D</option>
															<option value="HDB FINANCIAL SERVICES">HDB FINANCIAL SERVICES</option>
															<option value="HINDUJA LEYLAND FINANCE">HINDUJA LEYLAND FINANCE</option>
															<option value="MAGMA FINCORP LTD.">MAGMA FINCORP LTD.</option>
															<option value="EQUITAS FINANCE PVT LTD">EQUITAS FINANCE PVT LTD</option>
															<option value="MANAN FINANCEAL SERVICE PVT. LTD.">MANAN FINANCEAL SERVICE PVT. LTD.</option>
															<option value="L & T FINANCE LIMITED">L & T FINANCE LIMITED</option>
															<option value="RELIANCE CAPITAL  LTD.">RELIANCE CAPITAL  LTD.</option>
															<option value="CHOLAMANDALAM INVESTMENT & FINANCE LTD.">CHOLAMANDALAM INVESTMENT & FINANCE LTD.</option>
															<option value="INDIAN INFO LINE FINANCE LTD.">INDIAN INFO LINE FINANCE LTD.</option>
															<option value="CITI CORP. FINANCE INDIA LTD.">CITI CORP. FINANCE INDIA LTD.</option>
															<option value="DCB BANK">DCB BANK</option>
															<option value="INDUSIND BANK L T D">INDUSIND BANK L T D</option>
															<option value="RELIGARE FINVEST LIMITED">RELIGARE FINVEST LIMITED</option>
															<option value="I  K  F  FINANCE">I  K  F  FINANCE</option>
															<option value="SHRIRAM FINANCE">SHRIRAM FINANCE</option>
															<option value="AU FINANCE">AU FINANCE</option>
															<option value="Fullerton India Credit Co Ltd">Fullerton India Credit Co Ltd</option>
															<option value="MAHINDRA & MAHINDRA FINANCE">MAHINDRA & MAHINDRA FINANCE</option>
															<option value="MAS FINANCIAL SERVICES LTD.">MAS FINANCIAL SERVICES LTD.</option>
															<option value="TVS CREDIT SERVICE LIMITED">TVS CREDIT SERVICE LIMITED</option>
															<option value="INDIABULLS COMMERCIAL CREDIT LTD.">INDIABULLS COMMERCIAL CREDIT LTD./<option>
														</select>
														
														</div>
													</div>
												</div>
												<div id="deldate" style="display: none;" class="row">
													<div class="col-md-12">
														<div class="col-md-3">Date :</div> 
														<div class="col-md-8">
														<input type="date" class="date-picker form-control hasDatepicker" name="date"></div>
													</div>
													
												</div><br/><br/>
												<button type="submit" value="Delete File" class="btn btn-dark ">
													Delete
												</button>
											</div>
										</form>
									</div>
								
								<div class="col-md-6">
									<div  style="border:0;background-color:#eaeaea;padding: 5px;">
										<h2 style="color:green;"><b>Export Vehicle List To EXCEL</b></h2>
										<form action="<%=request.getContextPath() %>/YourController" method="post" >
											<input type="hidden" name="mode" value="exportToExcel" />
											<button type="submit" class="btn btn-dark ">
												Export
											</button>
										</form>
									</div>
								</div>

								<div class="col-md-6">
									<div  style="border:0;background-color:#eaeaea;padding: 5px;">
										<h2 style="color:green;"><b>Export Vehicle List To PDF</b></h2>
										<form action="<%=request.getContextPath() %>/YourController" method="post" >
											<input type="hidden" name="mode" value="exportToPDF" />
											<button type="submit" class="btn btn-dark ">
												Export
											</button>
										</form>
									</div>
								</div>
								
								</div>
                  			</div>
			     		</div>
			     	</div>
			   	 
			        <div class="footer">
			            <div class="copyright">
			              	<p class="pull-left sm-pull-reset">
			                	<span>Copyright <span class="copyright">©</span> 2015 </span>
			                	<span>PONIYA AGENCY</span>.
			                	<span>All rights reserved. </span>
			              	</p>
			              <!-- 	<p class="pull-right sm-pull-reset">
			                	<span><a href="#" class="m-r-10">Support</a> | <a href="#" class="m-l-10 m-r-10">Terms of use</a> | <a href="#" class="m-l-10">Privacy Policy</a></span>
			              	</p> -->
			            </div>
					</div>
				</div>	
	        </div>
	        <!-- END PAGE CONTENT -->
      	</div>
      	<!-- END MAIN CONTENT -->
	</section>
    
    <!-- BEGIN SEARCH -->
    	<%@ include file="a_popup.jsp" %>
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
    
    <a href="#" class="scrollup"><i class="fa fa-angle-up"></i></a> 
    <!-- SCRIPT -->
    	<%@ include file="a_script.jsp" %>
    	
    <!-- END SCRIPT -->

</body>
</html>

