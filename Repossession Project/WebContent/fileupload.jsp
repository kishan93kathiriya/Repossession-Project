<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/admin/assets/global/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/global/css/theme.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/global/css/ui.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/admin/layout1/css/layout.css" rel="stylesheet">
    
    <!-- BEGIN PAGE STYLE -->
    <link href="<%=request.getContextPath() %>/admin/assets/global/plugins/metrojs/metrojs.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/admin/assets/global/plugins/maps-amcharts/ammap/ammap.min.css" rel="stylesheet">
    <!-- END PAGE STYLE -->
<script type="text/javascript">
currentg1 = 2; // This is input files added by default.
maxg1 = 5;
ming1 = 1;

function g1_app_child(){
    if(currentg1<maxg1)
    {
        var div = document.createElement("div");
        div.id = 'divfiles'+currentg1;
        /*div.style.width = "100px";
        div.style.height = "100px";
        div.style.background = "red";
        div.style.color = "white";*/
        div.innerHTML = '<input type="file" name="files['+currentg1+']" id="file'+currentg1+'" value="" />';
        document.getElementById('outer_div').appendChild(div);
        currentg1++;
        return false;
    }
    else
    {
        alert('Maximum '+maxg1+' Files are Allowed.');
        return false;
    }
}

function g1_delchild()
{
    if(currentg1>ming1)
    {
        cnt = currentg1-1;
        element = document.getElementById('divfiles'+cnt);
        element.parentNode.removeChild(element);
        currentg1--;
        return false;
    }
    else
    {
        alert('Minimum '+ming1+' Files are Allowed.');
        return false;
    }
}
</script>

</head>
<body>
<form action="<%=request.getContextPath() %>/UploadServlet" method="post" enctype="multipart/form-data">
				<h2>Upload Excel File</h2>
				<hr>
				
				<div id="outer_div">
    				<div id="divfiles0"><input type="file" name="files[0]" id="file0" value="" class=""/></div>
   					
				</div>
				<br><br>
				
				<button type="submit" value="Upload File" class="btn btn-dark "><i class="icon-cloud-upload"></i>
				Upload</button>
	</form>
</body>
</html>