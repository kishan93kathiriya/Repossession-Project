<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<head>
	<meta charset="utf-8">
	<title>Poniya Agency</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta content="b2a" name="TK-KK-HP" />

	<link rel="shortcut icon" href="<%=request.getContextPath() %>/admin/assets/global/images/favicon.png">
	
	<link href="<%=request.getContextPath() %>/admin/assets/global/css/style.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/admin/assets/global/css/ui.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/admin/assets/global/plugins/bootstrap-loading/lada.min.css" rel="stylesheet">
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<body class="account separate-inputs" data-page="login">

        <!-- BEGIN LOGIN BOX -->
        <div class="container" id="login-block">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <div class="account-wall">
                        <i class="user-img icons-faces-users-03"></i>
                       
                        
                        <form class="form-signin" role="form" action="<%=request.getContextPath() %>/Filter" method="post">
                        	
                        	<input type="hidden" name="flag" value="login">
                            <div class="append-icon">
                                <input type="text" name="un" id="name" class="form-control form-white username" placeholder="Username" required>
                                <i class="icon-user"></i>
                            </div>
                            <div class="append-icon m-b-20">
                                <input type="password" name="pw" class="form-control form-white password" placeholder="Password" required>
                                <i class="icon-lock"></i>
                            </div>
                           
                            <%-- <c:set var="error1" scope="session" value="<%out.print(e);%>"/>
                        	<c:set var="error2" scope="session" value="no"/>
                        	<c:choose>
                        		<c:when test="${error2.equals(error1)}">Error</c:when>
                            	<c:otherwise>Please enter Valid Username Or Password</c:otherwise>
                            </c:choose> --%>
                           <% session.invalidate(); %>
                            <button type="submit" class="btn btn-lg btn-danger btn-block ladda-button">Sign In</button>
                            <!-- <button type="submit" id="submit-form" class="btn btn-lg btn-danger btn-block ladda-button" data-style="expand-left">Sign In</button> -->
                            <div class="clearfix">
                                <!-- <p class="pull-left m-t-20"><a id="password" href="#">Forgot password?</a></p>
                                 --><!-- <p class="pull-right m-t-20"><a href="user-signup-v1.html">New here? Sign up</a></p> -->
                            </div>
                        </form><%-- 
                        <form class="form-password" role="form" action="<%=request.getContextPath() %>/Login" method="post">
                            <div class="append-icon m-b-20">
                                <input type="password" name="password" class="form-control form-white password" placeholder="Password" required>
                                <i class="icon-lock"></i>
                            </div>
                            <button type="submit" id="submit-password" class="btn btn-lg btn-danger btn-block ladda-button" data-style="expand-left">Send Password Reset Link</button>
                            <!-- <div class="clearfix">
                                <p class="pull-left m-t-20"><a id="login" href="#">Already got an account? Sign In</a></p>
                                <p class="pull-right m-t-20"><a href="user-signup-v1.html">New here? Sign up</a></p>
                            </div> -->
                        </form>
                   --%>  </div>
                </div>
            </div>
            <p class="account-copyright">
                <span>Copyright  2015 </span><span>PONIYA AGENCY</span>.<span>All rights reserved.</span>
            </p>
            
        </div>
        <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/jquery/jquery-1.11.1.min.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/jquery/jquery-migrate-1.2.1.min.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/gsap/main-gsap.min.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/backstretch/backstretch.min.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/plugins/bootstrap-loading/lada.min.js"></script>
        <script src="<%=request.getContextPath() %>/admin/assets/global/js/pages/login-v1.js"></script>
    </body>


</html>