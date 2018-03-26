<%@ include file="header.jsp"%>
<div>
<a class="btn btn-primary pull-right" href="UserController?actions=user_new" role="button"><i class="glyphicon glyphicon-plus"></i></a>
</div><br>
<c:if test="${!empty users}">
	<table class="table table-striped">
		<thead>
			<tr class="bg-primary">
				<th>SN</th>
				<th>ID</th>
				<th>Username</th>
				<th>Password</th>
				<th>E-Mail</th>
				<th>Photo</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u" varStatus="d">
				<tr>
					<td><c:out value="${d.count}" /></td>
					<td><c:out value="${u.id}" /></td>
					<td><c:out value="${u.userName}" /></td>
					<td><c:out value="${u.password}" /></td>
					<td><c:out value="${u.email}" /></td>
					<td><img src="UserImageDisplayController?userId=${u.id}" alt="pic" width="50px" height="50px" /></td>
					<td>
						<a href="UserController?actions=user_edit&id=${u.id}"><i class="glyphicon glyphicon-edit"></i></a>
						&nbsp;&nbsp;&nbsp; 
						<a href="UserController?actions=user_delete&id=${u.id}"><i class="glyphicon glyphicon-trash"></i></a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</c:if>

<%@ include file="footer.jsp"%>