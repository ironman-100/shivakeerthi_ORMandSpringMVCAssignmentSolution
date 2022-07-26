<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRM App</title>
</head>
<body>
	<div class="main">
		<header>
			<h1>Customer Relationship Management</h1>
		</header>
		<div>
			<form action="${pageContext.request.contextPath}/customer/showaddform"
				method="get">
				<button class="btn-add">Add Customer</button>
			</form>
			<c:choose>
				<c:when test="${empty customers}">
					<p class="msg-no-record">No record found!</p>
				</c:when>
				<c:otherwise>
					<table>
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${customers}" var="customer">
								<tr>
									<td>${customer.firstName}</td>
									<td>${customer.lastName}</td>
									<td>${customer.email}</td>
									<td>
										<a href="${pageContext.request.contextPath}/customer/showupdateform?customer=${customer}">Update</a> | 
										<a href="${pageContext.request.contextPath}/customer/delete?customer=${customer}"
										onclick="return confirm('Are you sure you want to delete ${customer.firstName} ${customer.lastName}?')">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>