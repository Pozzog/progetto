<%@ page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
		<title>Lista Rilevazioni</title>
	</head>
	<body>
	 
		<jsp:include page = "_header.jsp"></jsp:include>
		<jsp:include page = "_menu.jsp"></jsp:include>
		
		<div>
		
		<h3>Lista Rivelazioni</h3><a href = "revelationList?id = ${rivelazione.id}">Indietro</a>
		
		</div>
		
		<p style = "color: red;">${errorString}</p>
		
		<form method = "POST" action = "${pageContext.request.contextPath}/relevationList">
		
			<input type="hidden" name="sensID" value="${sensore.id}" />
		
			<table border = "1" cellpadding = "5" cellspacing = "1" >
				<tr>
					<th>Id</th>
					<th>Messaggio</th>
					<th>Descrizione</th>
				</tr>
				<c:forEach items = "${relevationList}" var = "relevation" >
					<tr>
						<td>${relevation.id}</td>
						<td>${relevation.messaggio}</td>
						<td>${relevation.descrizione}</td>
					</tr>
				</c:forEach>	
			</table>
		</form>

		<jsp:include page = "_footer.jsp"></jsp:include>
		
	</body>
</html>