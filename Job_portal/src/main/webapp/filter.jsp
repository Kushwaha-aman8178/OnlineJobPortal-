<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.Dao.JobDao"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.entity.job"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userObj }">

		<c:redirect url="login.jsp" />

	</c:if>

	<%@include file="/components/navbar.jsp"%>

	<%
	String location = request.getParameter("location");
	String category = request.getParameter("category");
	%>



	<div class="container">

		<div class="row">
			<div class="col-md-12">

				<h3 class="text-center text-primary md-2">All Jobs</h3>
				<%
				JobDao object = new JobDao(DBConnect.getConnection());

				List<job> obj = new ArrayList<job>();
				if (location.equals("Choose...") && !category.equals("Choose...")) {
					obj = object.getFilterJob1(category);
				} else if (!location.equals("Choose...") && category.equals("Choose...")) {
					obj = object.getFilterJob2(location);
				}

				else if (!location.equals("Choose...") && !category.equals("Choose...")) {
					obj = object.getFilterJob3(location, category);
				}

				if (obj.isEmpty()) {
				%>

				<h4 class="text-center text-danger">Not Job Available</h4>

				<%
				}

				for (job j : obj) {
				%>




				<div class="card mt-2">

					<div class="card-body">

						<div class="text-center">
							<i class="fa-solid fa-clipboard"></i>
						</div>


						<h5><%=j.getTitle()%></h5>
						<p><%=j.getDescription()%></p>
						<br>

						<div class="form-row">

							<div class="form-group col-md-3">

								<input class="form-control" type="text"
									value="Location:<%=j.getLocation()%>" readonly>
							</div>

							<div class="form-group col-md-3">

								<input class="form-control" type="text"
									value="Category:<%=j.getCategory()%>" readonly>
							</div>

						</div>

						<p><%=j.getPostdate()%></p>


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