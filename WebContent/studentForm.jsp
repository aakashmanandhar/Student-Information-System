<%@ include file="header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">Register Student</div>
				<div class="panel-body">
					<form role="Form" action="StudentController" method="post"
						enctype="multipart/form-data" accept-charset="UTF-8">
						<span> <input type="hidden" name="id" value="${student.id}">
						</span>
						<div class="form-group">
							<label for="fname">Student Name</label> <input type="text"
								id="fname" class="form-control" name="sname"
								value="${student.studentName}">
						</div>
						<div class="form-group">
							<label for="lname">College Name</label> <input type="text"
								id="lname" class="form-control" name="cname"
								value="${student.collegeName}">
						</div>
						<div class="form-group">
							<label for="emailaddr">Email Address</label> <input type="text"
								id="emailaddr" class="form-control" name="email"
								value="${student.email}">
						</div>
						<div class="form-group">
							<label for="emailaddr">Roll</label> <input type="number"
								id="emailaddr" class="form-control" name="roll"
								value="${student.roll}">
						</div>
						<div class="form-group">
							<label for="dob">Date of Birth</label> <input type="date"
								id="dob" class="form-control" name="dob" value="${student.dob}">
						</div>
						<div class="form-group">
							<label for="gender">Gender</label> <input type="radio"
								name="gender" value="Male"
								${student.gender=='Male'?'checked':''}>Male <input
								type="radio" name="gender" value="Female"
								${student.gender=='Female'?'checked':''}>Female
						</div>
						<div class="form-group">
							<label for="department">Departments</label> <select
								id="department" class="form-control" name="department">
								<option value="IT" ${student.department=='IT'?'selected':''}>IT</option>
								<option value="Computer"
									${student.department=='Computer'?'selected':''}>Computer</option>
							</select>
						</div>

						<div class="form-group">
							<label>Subject</label> <input type="checkbox" name="subject"
								value="Java"
								<c:if test="${fn:contains(student.subject, 'Java')}">checked</c:if>>Java
							<input type="checkbox" name="subject" value="PHP"
								<c:if test="${fn:contains(student.subject, 'PHP')}">checked</c:if>>PHP
						</div>
						<div class="form-group">
							<label>Upload</label> <input type="file" name="photo">
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