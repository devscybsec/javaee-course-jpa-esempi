<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Responsabili</title>
<style>
table {
	border-spacing: 0;
}

td, th {
	padding: 4px;
	border: 1px solid black;
}

.inline {
	display: flex;
	justify-content: space-between;
	padding: 4px;
}

.incol {
	display: flex;
	flex-direction: column;
}

button {
	cursor: pointer;
}
</style>
</head>
<body>
	<h2>Responsabili</h2>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Ruolo</th>
				<th>Ufficio</th>
			</tr>
			<c:forEach var="responsabile" items="${requestScope.responsabili}">
				<tr>
					<td>${responsabile.id}</td>
					<td>${responsabile.nome}</td>
					<td>${responsabile.cognome}</td>
					<td>${responsabile.ruolo.nome}</td>
					<td>${responsabile.ufficio.nome}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="window.history.back()">Indietro</button>
</body>
</html>