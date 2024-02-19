<%@ page import="com.db.DBConnect" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/components/css.jsp"%>
<style type="text/css">
.background-img {
	background: url(img/img2.png);
	width: 100%;
	height: 100vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>

	<%@include file="/components/navbar.jsp"%>

    
	<div class="background-img">

		<div class="text-center">

			<h1 class="main-head">Online Job Portal</h1>
		</div>

	</div>

	<%@include file="/components/footer.jsp"%>

</body>
</html>