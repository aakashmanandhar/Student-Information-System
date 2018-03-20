<%@ include file="header.jsp"%>

<div>
	<form action="StudentController" method="post" enctype="multipart/form-data">
		<span style="color: red">${loginFail}</span> <span style="color: blue">${loggedOut}</span>
		<div>
			<label>Student Name</label> <input type="text" name="sname" value="">
		</div>
		<div>
			<label>College Name</label> <input type="text" name="cname">
		</div>
		<div>
			<label>E-Mail</label> <input type="email" name="email">
		</div>
		<div>
			<label>Roll No.</label> <input type="number" name="roll">
		</div>
		<div>
			<label>DOB</label> <input type="date" name="dob">
		</div>
		<div>
			<label>Gender</label> <input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female
		</div>
		<div>
			<label>Departments</label> <select name="department">
				<option value="IT">IT</option>
				<option value="Computer">Computer</option>
			</select>
		</div>
		<div>
			<label>Subject</label> <input type="checkbox" name="subject" value="Java">Java
			<input type="checkbox" name="subject" value="PHP">PHP
		</div>
		<div>
			<label>Upload</label>
			<input type="file" name="photo">
		</div>
		<div>
			<input type="submit" value="submit">
		</div>
	</form>
</div>

<%@ include file="footer.jsp"%>