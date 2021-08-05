<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<script
	src="<c:url value="/resources/bootstrap/js/jquery-3.5.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

<link
	href="<c:url value="/resources/fontawesome/css/fontawesome.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fontawesome/css/brands.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fontawesome/css/solid.css" />"
	rel="stylesheet">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center text-danger font-weight-bold">Welcome to
				my page</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<c:set var="id" value="${book}" />
					<c:choose>
						<c:when test="${id != null || id != '' }">
							<div class="panel-title">Add book</div>
						</c:when>
						<c:otherwise>
							<div class="panel-title">Edit book</div>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="panel-body">
					<form:form action="saveBook" class="form-horizontal" method="post"
						modelAttribute="book" enctype="multipart/form-data">

						<!-- need to associate this data with customer id -->
						<form:hidden path="id" />
						<div class="form-group">
							<label for="name" class="col-md-3 control-label"> Name</label>
							<div class="col-md-9">
								<form:input path="name" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="category" class="col-md-3 control-label">Category</label>
							<div class="col-md-9">
								<form:input path="category" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="publisher" class="col-md-3 control-label">Publisher</label>
							<div class="col-md-9">
								<form:input path="publisher" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="addDay" class="col-md-3 control-label">Add
								day</label>
							<div class="col-md-9">
								<form:input path="addDay" class="form-control" type="date" />
							</div>
						</div>

						<div class="form-group">
							<label for="price" class="col-md-3 control-label">Price</label>
							<div class="col-md-9">
								<form:input path="price" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="bookImage">Book Image</label>
							<form:input path="bookImage" id="bookImage" type="file"
								class="form:input-large" />
						</div>
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button class="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>