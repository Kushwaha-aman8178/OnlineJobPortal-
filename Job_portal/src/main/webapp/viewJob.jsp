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

   <c:if test="${userObj.role ne 'admin' }">
    
    <c:redirect url="login.jsp"/>
    
    </c:if>

	<%@include file="/components/navbar.jsp"%>

	<div class="container">
		<div class="row">

			<div class="col-md-12">

				<h5 class="text-center text-primary md-2">All Jobs</h5>

				<c:if test="${not empty msg }">

					<div class="alert alert-success" role="alert">${msg}</div>
					<c:remove var="msg" />

				</c:if>


				<%
				JobDao obj = new JobDao(DBConnect.getConnection());
				List<job> jobs = obj.viewJob();

				for (job j : jobs) {
				%>

				<div class="card mt-2">

					<div class="card-body">

						<div class="text-center">
							<i class="fa-solid fa-clipboard"></i>
						</div>

						<h4><%=j.getTitle()%></h4>
						<p><%=j.getDescription()%></p>
						<br>

						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" value="location:<%=j.getLocation()%>"
									class="form-control" readonly>
							</div>

							<div class="form-group col-md-3">
								<input type="text" value="category:<%=j.getCategory()%>"
									class="form-control" readonly>
							</div>

							<div class="form-group col-md-3">
								<input type="text" value="status:<%=j.getStatus()%>"
									class="form-control" readonly>
							</div>

						</div>
						<h6>
							Publish Date:<%=j.getPostdate()%></h6>

						<div class="text-center">

							<a href="editJob.jsp?id=<%=j.getId()%>" class="btn btn-success">Edit</a>
							<a href="deleteServlet?id=<%=j.getId() %>" class="btn btn-danger">Delete</a>

						</div>

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