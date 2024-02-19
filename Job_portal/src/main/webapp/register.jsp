<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<%@include file="/components/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">

						<div class="text-center">
							<i class="fa-solid fa-user-plus"></i>
							<c:if test="${not empty msg}">
								<div class="alert alert-success">${msg }</div>
								<c:remove var="msg" />
							</c:if>
							
							<h5>Registration</h5>
						</div>

						<form action="register" method="post">

							<div class="form-group">
								<label>Enter Full Name</label> <input type="text" name="name"
									class="form-control">
							</div>

							<div class="form-group">
								<label>Enter Qualification</label> <input type="text"
									name="qual" class="form-control">
							</div>

							<div class="form-group">
								<label>Enter Email</label> <input type="email" name="email"
									class="form-control">
							</div>

							<div class="form-group">
								<label>Enter Password</label> <input type="text" name="password"
									class="form-control">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Submit</button>


						</form>

					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>