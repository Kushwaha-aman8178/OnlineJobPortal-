<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.Dao.UserDao" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.entity.user" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/components/css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">


	<%@include file="/components/navbar.jsp"%>

	<div class="card">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">

						<div class="text-center">
							<i class="fa-solid fa-user-plus"></i>


							<h4>EditProfile</h4>
						</div>
						
						<%  
						int id = Integer.parseInt(request.getParameter("id"));
						
						UserDao obj = new UserDao(DBConnect.getConnection());
						user object = obj.findUserDetails(id);
						
						%>
						
						
                           <form action="editProfile" method="post">
                           <input type="hidden" value="<%=id %>" name="id" />
                           
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text" name="name"
									class="form-control" value="<%=object.getName() %>" >
							</div>

							<div class="form-group">
								<label>Enter Qualification</label> <input type="text"
									name="qual" class="form-control" value="<%=object.getQual() %>" >
							</div>

							<div class="form-group">
								<label>Enter Email</label> <input type="email" name="email"
									class="form-control" value="<%=object.getEmail() %>" >
							</div>

							<div class="form-group">
								<label>Enter Password</label> <input type="text" name="password"
									class="form-control" value="<%=object.getPassword() %>">
							</div>

							<div class="text-center">

							<button class="btn btn-primary">Edit</button>

						</div>

						</form>
						
					</div>

				</div>
			</div>
		</div>
		</div>

</body>
</html>