<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.Dao.JobDao"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.entity.job"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
    <c:if test="${userObj.role ne 'user' }">
    
    <c:redirect url="login.jsp"/>
    
    </c:if>
	<%@include file="/components/navbar.jsp"%>
	<div class="container">

		<div class="row">

			<div class="col-md-12">

				<h5 class="text-center text-primary md-2">All Jobs</h5>
				<c:if test="${not empty msg }">
								<div class="alert alert-success">${msg }</div>
								<c:remove var="msg" />
							</c:if>

				<div class="card mt-2">

					<div class="card-body">


						<form class="form-inline" action="filter.jsp" method="post">

							<div class="form-group col-md-5 mt-1">
								<h5>Location</h5>

							</div>
							<div class="form-group col-md-5 mt-1">
								<h5>Category</h5>

							</div>


							<div class="form-group col-md-5">

								<select name="location" class="custom-select">
									<option>Choose...</option>
									<option value="delhi">Delhi</option>
									<option value="banglore">Banglore</option>
									<option value="gurugram">Gurugram</option>
									<option value="hyderabad">Hyderabad</option>
									<option value="pune">Pune</option>

								</select>

							</div>
							<div class="form-group col-md-5">

								<select name="category" class="custom-select">
									<option>Choose...</option>
									<option value="testing">Testing</option>
									<option value="developer">Developer</option>
									<option value="frontend">FrontEnd Developer</option>
									<option value="backend">Backend Developer</option>
									<option value="full-stack">Full Stack Developer</option>

								</select>

							</div>
							<button class="btn btn-success">Submit</button>


						</form>

					</div>
				</div>


				<%
				JobDao object = new JobDao(DBConnect.getConnection());
				List<job> obj = object.getJobUser();

				for (job j : obj) {
				%>

				<div class="card mt-2">

					<div class="card-body">

						<div class="text-center text-primary">
							<i class="fa-solid fa-clipboard"></i>
						</div>

						<h5><%=j.getTitle()%></h5>
						<p><%=j.getDescription()%></p>
						<br>

						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control"
									value="Location:<%=j.getLocation()%>" readonly>

							</div>

							<div class="form-group col-md-3">
								<input type="text" class="form-control"
									value="Category:<%=j.getCategory()%>" readonly>

							</div>

						</div>

						<p><%=j.getPostdate()%></p>
						<br>

					</div>



				</div>


				<%
				}
				%>



			</div>

		</div>



	</div>

</body>
</html>