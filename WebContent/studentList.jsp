<%@ include file="header.jsp"%>
<div>
<a class="btn btn-primary pull-right" href="StudentController?actions=student_new" role="button"><i class="glyphicon glyphicon-plus"></i></a>
</div><br>
<c:if test="${!empty students}">
	<table class="table table-striped">
		<thead>
			<tr class="bg-primary">
				<th>SN</th>
				<th>ID</th>
				<th>Student Name</th>
				<th>College name</th>
				<th>E-Mail</th>
				<th>DOB</th>
				<th>Gender</th>
				<th>Department</th>
				<th>Subject</th>
				<th>Roll</th>
				<th>Photo</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="s" varStatus="d">
				<tr>
					<td><c:out value="${d.count}" /></td>
					<td><c:out value="${s.id}" /></td>
					<td><c:out value="${s.studentName}" /></td>
					<td><c:out value="${s.collegeName}" /></td>
					<td><c:out value="${s.email}" /></td>
					<td><c:out value="${s.dob}" /></td>
					<td><c:out value="${s.gender}" /></td>
					<td><c:out value="${s.department}" /></td>
					<td><c:out value="${s.subject}" /></td>
					<td><c:out value="${s.roll}" /></td>
					<td><img src="" alt="pic" width="50px" height="50px" /></td>
					<td>
						<a href="StudentController?actions=student_edit&id=${s.id}"><i class="glyphicon glyphicon-edit"></i></a>
						&nbsp;&nbsp;&nbsp; 
						<a href="StudentController?actions=student_delete&id=${s.id}"><i class="glyphicon glyphicon-trash"></i></a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</c:if>

<%@ include file="footer.jsp"%>