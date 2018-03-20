<%@ include file="header.jsp"%>

<div>
	<form action="StudentController" method="post"
		enctype="multipart/form-data">
		<span> <input type="hidden" name="id" value="${student.id}">
		</span>
		<div>
			<label>Student Name</label> <input type="text" name="sname"
				value="${student.studentName}">
		</div>
		<div>
			<label>College Name</label> <input type="text" name="cname"
				value="${student.collegeName}">
		</div>
		<div>
			<label>E-Mail</label> <input type="email" name="email"
				value="${student.email}">
		</div>
		<div>
			<label>Roll No.</label> <input type="number" name="roll"
				value="${student.roll}">
		</div>
		<div>
			<label>DOB</label> <input type="date" name="dob"
				value="${student.dob}">
		</div>
		<div>
			<label>Gender</label> <input type="radio" name="gender" value="Male"
				${student.gender=='Male'?'checked':''}>Male <input
				type="radio" name="gender" value="Female"
				${student.gender=='Female'?'checked':''}>Female
		</div>
		<div>
			<label>Departments</label> <select name="department">
				<option value="IT" ${student.department=='IT'?'selected':''}>IT</option>
				<option value="Computer"
					${student.department=='Computer'?'selected':''}>Computer</option>
			</select>
		</div>
		<div>
			<label>Subject</label> <input type="checkbox" name="subject"
				value="Java"
				<c:if test="${fn:contains(student.subject, 'Java')}">checked</c:if>>Java
			<input type="checkbox" name="subject" value="PHP"
				<c:if test="${fn:contains(student.subject, 'PHP')}">checked</c:if>>PHP
		</div>
		<div>
			<label>Upload</label> <input type="file" name="photo">
		</div>
		<div>
			<input type="submit" value="submit">
		</div>
	</form>
</div>

<%@ include file="footer.jsp"%>