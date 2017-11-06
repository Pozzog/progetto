<%@ page language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset = "UTF-8">
		<title>Sintesi</title>
	</head>
	<body>
		
		<jsp:include page = "_header.jsp"></jsp:include>
		<jsp:include page = "_menu.jsp"></jsp:include>
		
		
		
		<h3>Sintesi</h3>
		
		<p style = "color:red;">${errorString}</p>
		
		<table border = "1" cellpadding = "5" cellspacing = "1">
			<tr>
				<th>CodSens</th>
				<th>Messaggio</th>
				<th>Descrizione</th>
			</tr>
			
			<c:forEach items = "${summaryList}" var = "summary">
				<tr>
					<td>${summary.codsens}</td>
					<td>${summary.messaggio}</ts>
					<td>${summary.descrizione}</td>
				</tr>
			</c:forEach>
		</table>
		
		<form>
			<table border = "0">
				<tr>
					<td colspan = "2">
						<input type = "button" value = "Salva" />
						<input type="button" onClick="window.print()" value="Print"/>
					</td>
				</tr>
			</table>
		</form>
		
		<jsp:include page = "_footer.jsp"></jsp:include>
		
	</body>
</html>