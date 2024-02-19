<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Dao.JobDao"%>
<%@ page import="com.db.DBConnect"%>
<%@ page import="com.entity.job"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
    <c:if test="${empty userObj }">
    
    <c:redirect url="login.jsp"/>
    
    </c:if>

	<%@include file="/components/navbar.jsp"%>
    
    <%
	int id = Integer.parseInt(request.getParameter("id"));
    
	JobDao obj = new JobDao(DBConnect.getConnection());
	job object = obj.editJob1(id);
	
	%>
	

	<div class="container p-2">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">

					<div class="text-center">
						<i class="fa-solid fa-square-plus"></i>



						<h5>Edit Jobs</h5>
						
					</div>


					<form action="editJob" method="post">
					    <input type="hidden" name="id" value="<%=id%>">

						<div class="form-group">
							<label>Enter Title</label> <input type="text" name="title" value="<%=object.getTitle() %>"
								class="form-control">

						</div>

						<div class="form-row">
							<div class="form-group col-md-4">

								<label>Location</label> <select name="location"
									class="custom-select">
									<option><%=object.getLocation() %></option>
									<option value="delhi">Delhi</option>
									<option value="banglore">Banglore</option>
									<option value="gurugram">Gurugram</option>
									<option value="hyderabad">Hyderabad</option>
									<option value="pune">Pune</option>

								</select>

							</div>


							<div class="form-group col-md-4">

								<label>Category</label> <select name="category"
									class="custom-select">
									<option><%=object.getCategory() %></option>
									<option value="testing">Testing</option>
									<option value="developer">Developer</option>
									<option value="frontend">FrontEnd Developer</option>
									<option value="backend">Backend Developer</option>
									<option value="full-stack">Full Stack Developer</option>

								</select>

							</div>

							<div class="form-group col-md-4">

								<label>Status</label> <select name="status"
									class="custom-select">
									<option><%=object.getStatus() %></option>
									<option value="active">Active</option>
									<option value="inactive">Inactive</option>

								</select>

							</div>

						</div>

						<div class="form-group">

							<label>Enter Description</label>
							<textarea rows="6" cols="" class="form-control" name="desc" placeholder="<%= object.getDescription()%>"></textarea>

						</div>

						<button class="btn btn-success">Edit</button>

					</form>
				</div>

			</div>
		</div>

	</div>



</body>
</html>