<%@ include file="header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">Register User</div>
				<div class="panel-body">
					<form role="Form" action="UserController" method="post"
						enctype="multipart/form-data" accept-charset="UTF-8">
						<span> <input type="hidden" name="id" value="${user.id}">
						</span>
						<div class="form-group">
							<label for="fname">Username</label> <input type="text" id="uname"
								class="form-control" name="uname" value="${user.userName}">
						</div>
						<div class="form-group">
							<label for="fname">Password</label> <input type="password"
								id="password" class="form-control" name="pass" value="${user.password}">
						</div>
						<div class="form-group">
							<label for="fname">E-Mail</label> <input type="email" id="email"
								class="form-control" name="email" value="${user.email}">
						</div>
						<div class="form-group">
							<label>Upload</label> <input type="file" name="photo"
								class="form-control">
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-primary btn-lg"
								id="submitbtn" name="submit">Save</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>