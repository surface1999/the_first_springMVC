<%@page import="admin.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<script
	src="<c:url value="/resources/bootstrap/js/jquery-3.5.1.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/book.js" />"></script>
<link
	href="<c:url value="/resources/fontawesome/css/fontawesome.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fontawesome/css/brands.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fontawesome/css/solid.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>List books</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="form-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="mt-5">
			<h2 style="text-align: center;" class="text-success">List
				Cusomer In Your Database</h2>
			<hr />
			<nav class="navbar navbar-light bg-none justify-content-between">
				<form class="form-inline">
					<a href="add" class="btn btn-dark btn-add">Add item</a>
				</form>
				<div class="tool">
					<form class="form-inline search" action="search" method="post">
						<input type="text" onkeydown="search(event)"
							placeholder="Input content to search..." name="q">
						<button type="submit">
							<i class="fas fa-search text-dark"></i>
						</button>
					</form>
			</nav>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Customer List</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered">
					<thead>
						<th>ID</th>
						<th>Avatar</th>
						<th>Name</th>
						<th>Category</th>
						<th>Publisher</th>
						<th>Price</th>
						<th>Add day</th>
						<th>Control</th>
					</thead>

					<tbody id="list-books"></tbody>

					<!-- older -->

					<%-- 	<c:forEach var="book" items="${list}">

							<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/book/updateBook">
							<c:param name="id" value="${book.id}" />
						</c:url>

						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/book/deleteBook">
							<c:param name="id" value="${book.id}"></c:param>
						</c:url>
						<tr>
							<td>${book.name}</td>
							<td>${book.category}</td>
							<td>${book.publisher}</td>
							<td>${book.price}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${book.addDay}" /></td>
							<td>${book.addDay}</td>
							<td><img
								src="<c:url value="/resources/images/${book.id}.png" />"
								alt="Italian Trulli" style="height: 100px; width: 100px"></td>


							<td>
								<!-- display the update link --> <a href="${updateLink}">Update</a>
								| <a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"><i
									class="fas fa-trash-alt text-danger"></i> Delete</a>
							</td>

						</tr>

						</c:forEach>
						
 --%>
				</table>

			</div>
		</div>
	</div>

	</div>
</body>
</html>