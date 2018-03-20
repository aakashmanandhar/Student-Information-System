<%@ include file="header.jsp" %>

<a href="StudentController?actions=student_new">New Student</a>
<c:if test="">
	<table>
		<thead>
			<tr>
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
		<c:forEach items="" var="" varStatus="">
			<tr>
				<td></td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
</c:if>

<%@ include file="footer.jsp" %>