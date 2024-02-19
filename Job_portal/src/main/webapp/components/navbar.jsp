<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav
	class="navbar navbar-expand-lg navbar-light bg-light navbar-background ">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="#">Job Portal</a>
			</li>
			<li class="nav-item"><a class="nav-link navbar-a" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>

			<c:if test="${userObj.role eq 'admin' }">
				<li class="nav-item"><a class="nav-link" href="addJob.jsp"><i
						class="fa-solid fa-plus"></i>Post Jobs</a></li>

				<li class="nav-item"><a class="nav-link" href="viewJob.jsp"><i
						class="fa-solid fa-eye"></i>View Jobs</a></li>
			</c:if>
			<c:if test="${userObj.role eq 'user' }">
				

				<li class="nav-item"><a class="nav-link" href="home.jsp"><i
						class="fa-solid fa-eye"></i>View Jobs</a></li>
			</c:if>

		</ul>
		<form class="form-inline my-2 my-lg-0">

			<c:if test="${userObj.role eq 'admin' }">

				<a href="#" class="btn btn-light mr-1"><i
					class="fa-solid fa-user-plus"></i>Admin</a>
				<a href="logout" class="btn btn-light"><i
					class="fa-solid fa-right-to-bracket"></i>Logout</a>

			</c:if>

			<c:if test="${userObj.role eq 'user' }">

                
				<a href="userProfile.jsp?userObj=${userObj.id }" class="btn btn-light mr-1"><i
					class="fa-solid fa-user-plus"></i>${userObj.name }</a>
				<a href="logout" class="btn btn-light"><i
					class="fa-solid fa-right-to-bracket"></i>Logout</a>

			</c:if>

			<c:if test="${empty userObj }">
				<a href="login.jsp" class="btn navb"><i
					class="fa-solid fa-right-to-bracket"></i>Login</a>
				<a href="register.jsp" class="btn navb"><i
					class="fa-solid fa-user-plus"></i>Sign Up</a>

			</c:if>

		</form>
	</div>
</nav>