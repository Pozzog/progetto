<%@ page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
		<title>Lista Ambienti</title>
	</head>
	<body>
		
		<jsp:include page = "_header.jsp"></jsp:include>
		<jsp:include page = "_menu.jsp"></jsp:include>
		
		
		
		<h3> Lista Ambienti</h3>
		
		<p style = "color:red;">${errorString}</p>
		
	
			<table border = "1" cellpadding = "5" cellspacing = "1">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Tipologia</th>
					<th>Ubicazione</th>
					<th>NumeroSensori</th>
					<th>Sensori</th>
					<th>Sintesi</th>
				</tr>
			
				<c:forEach items = "${ambientList}" var = "ambiente">
					<tr>
						<td>${ambiente.id}</td>
						<td>${ambiente.nome}</td>
						<td>${ambiente.tipo}</td>
						<td>${ambiente.ubicazione}</td>
						<td>${ambiente.numeroSensori}</td>
						<td>
							<a href = "sensorList?id = ${ambiente.id}">Sensori</a>
						</td>
						<td>
							<a href = "summary?id = ${ambiente.id}">Sintesi</a>
						</td>
					</tr>
				
				</c:forEach>
			</table>
		</form>	
			
		<jsp:include page = "_footer.jsp"></jsp:include>
		
	</body>
</html>