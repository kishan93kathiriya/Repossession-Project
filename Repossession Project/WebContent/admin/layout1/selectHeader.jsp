<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="margin-top: 10%; margin-left: 30%;">

		<h1>Select and match File headers</h1>

		<form action="<%=request.getContextPath()%>/YourController"
			method="post">

			<table border="1px solid">
				<thead style="border: 1px solid">
					<tr>
						<td><b>No.</b></td>
						<td><b>Headers </b></td>
						<td><b>Select File Headers </b></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Loan No</td>
						<td>
							<select name="Loan_No">
								<c:forEach items="${sessionScope.sheetheaders}" var="myheader">
									<c:set var="s" value="${myheader.value}"></c:set>
									<c:set var="value" value="${fn:split(s, ' ,.') }"></c:set>
									<c:set var="finalValue" value="${fn:join(value, '') }"></c:set>
									<c:if test="${fn:containsIgnoreCase(finalValue, 'loanno') }">
										<option value="${myheader.key}" selected="selected">   
											${myheader.value}
										</option>
									</c:if>
									<c:if test="${! fn:containsIgnoreCase(finalValue, 'loanno') }">
										<option value="${myheader.key}">   
											${myheader.value}
										</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>Customer Name</td>
							<td>
							<select name="Customer_Name">
								<c:forEach items="${sessionScope.sheetheaders}" var="myheader">
									<c:set var="s" value="${myheader.value}"></c:set>
									<c:set var="value" value="${fn:split(s, ' ,.') }"></c:set>
									<c:set var="finalValue" value="${fn:join(value, '') }"></c:set>
									<c:if test="${fn:containsIgnoreCase(finalValue, 'customername') }">
										<option value="${myheader.key}" selected="selected">   
											${myheader.value}
										</option>
									</c:if>
									<c:if test="${! fn:containsIgnoreCase(finalValue, 'customername') }">
										<option value="${myheader.key}">   
											${myheader.value}
										</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>3</td>
						<td>Reg No</td>
							<td>
							<select name="Reg_No">
								<c:forEach items="${sessionScope.sheetheaders}" var="myheader">
									<c:set var="s" value="${myheader.value}"></c:set>
									<c:set var="value" value="${fn:split(s, ' ,.') }"></c:set>
									<c:set var="finalValue" value="${fn:join(value, '') }"></c:set>
									<c:if test="${fn:containsIgnoreCase(finalValue, 'regno') }">
										<option value="${myheader.key}" selected="selected">   
											${myheader.value}
										</option>
									</c:if>
									<c:if test="${! fn:containsIgnoreCase(finalValue, 'regno') }">
										<option value="${myheader.key}">   
											${myheader.value}
										</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>4</td>
						<td>Modal</td>
							<td>
							<select name="Modal">
								<c:forEach items="${sessionScope.sheetheaders}" var="myheader">
									<c:set var="s" value="${myheader.value}"></c:set>
									<c:set var="value" value="${fn:split(s, ' ,.') }"></c:set>
									<c:set var="finalValue" value="${fn:join(value, '') }"></c:set>
									<c:if test="${fn:containsIgnoreCase(finalValue, 'model') }">
										<option value="${myheader.key}" selected="selected">   
											${myheader.value}
										</option>
									</c:if>
									<c:if test="${! fn:containsIgnoreCase(finalValue, 'model') }">
										<option value="${myheader.key}">   
											${myheader.value}
										</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>5</td>
						<td>Chassis No</td>
							<td>
							<select name="Chasis_No">
								<c:forEach items="${sessionScope.sheetheaders}" var="myheader">
									<c:set var="s" value="${myheader.value}"></c:set>
									<c:set var="value" value="${fn:split(s, ' ,.') }"></c:set>
									<c:set var="finalValue" value="${fn:join(value, '') }"></c:set>
									<c:if test="${fn:containsIgnoreCase(finalValue, 'chassisno') }">
										<option value="${myheader.key}" selected="selected">   
											${myheader.value}
										</option>
									</c:if>
									<c:if test="${! fn:containsIgnoreCase(finalValue, 'chassisno') }">
										<option value="${myheader.key}">   
											${myheader.value}
										</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>6</td>
						<td>Engine No</td>
							<td>
							<select name="Engine_No">
								<c:forEach items="${sessionScope.sheetheaders}" var="myheader">
									<c:set var="s" value="${myheader.value}"></c:set>
									<c:set var="value" value="${fn:split(s, ' ,.') }"></c:set>
									<c:set var="finalValue" value="${fn:join(value, '') }"></c:set>
									<c:if test="${fn:containsIgnoreCase(finalValue, 'engineno') }">
										<option value="${myheader.key}" selected="selected">   
											${myheader.value}
										</option>
									</c:if>
									<c:if test="${! fn:containsIgnoreCase(finalValue, 'engineno') }">
										<option value="${myheader.key}">   
											${myheader.value}
										</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>7</td>
						<td>Contact</td>
							<td>
							<select name="Contact" multiple="multiple">
								<c:forEach items="${sessionScope.sheetheaders}" var="myheader">
									<c:set var="s" value="${myheader.value}"></c:set>
									<c:set var="value" value="${fn:split(s, ' ,.') }"></c:set>
									<c:set var="finalValue" value="${fn:join(value, '') }"></c:set>
									<c:if test="${fn:containsIgnoreCase(finalValue, 'contact') }">
										<option value="${myheader.key}" selected="selected">   
											${myheader.value}
										</option>
									</c:if>
									<c:if test="${! fn:containsIgnoreCase(finalValue, 'contact') }">
										<option value="${myheader.key}">   
											${myheader.value}
										</option>
									</c:if>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><input align="middle"
							type="submit" value="Submit"> <input align="middle"
							type="reset" value="Reset"></td>
					</tr>
				</tbody>
			</table>

			<input type="hidden" name="mode" value="22">

		</form>

	</div>

</body>
</html>