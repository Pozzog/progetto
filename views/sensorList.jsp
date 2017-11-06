<%@ page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
		<title>Lista Sensori</title>
	</head>
	<body>
	 
		<jsp:include page = "_header.jsp"></jsp:include>
		<jsp:include page = "_menu.jsp"></jsp:include>
		
		<div>
		
		<h3>Lista Sensori</h3><a href = "ambientList?id = ${ambienti.id}">Indietro</a>
		
		</div>
		
		<p style = "color: red;">${errorString}</p>
		
		<form method = "POST" action = "${pageContext.request.contextPath}/sensorList">
		
			<input type="hidden" name="ambID" value="${ambiente.id}" />
			
			<table border = "1" cellpadding = "5" cellspacing = "1" >
				<tr>
					<th>Id</th>
					<th>Modello</th>
					<th>Marca</th>
					<th>Tipologia</th>
					<th>Anno</th>
					<th>Rilevazioni</th>
				</tr>
				<c:forEach items = "${sensorList}" var = "sensor" >
					<tr>
						<td>${sensor.id}</td>
						<td>${sensor.modello}</td>
						<td>${sensor.marca}</td>
						<td>${sensor.tipo}</td>
						<td>${sensor.anno}</td>
					<td>
							<a href = "relevList?id = ${sensore.id}">Rilevazione</a>
						</td>
					</tr>
				</c:forEach>	
			</table>
		</form>
		
		<jsp:include page = "_footer.jsp"></jsp:include>
		
	</body>
</html>