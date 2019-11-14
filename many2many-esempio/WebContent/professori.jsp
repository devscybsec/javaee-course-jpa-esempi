<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Professori</title>
<link rel="stylesheet" type="text/css" href="/many2many-esempio/css/courses.css">
</head>
<body>
	<h2>Professori</h2>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Data di nascita</th>
				<th># Insegnamenti</th>
				<th>Comandi</th>
			</tr>
			<c:forEach var="professore" items="${professori}">
				<tr>
					<td>${professore.id}</td>
					<td>${professore.nome}</td>
					<td>${professore.cognome}</td>
					<td><fmt:formatDate pattern="dd MMMM yyyy" value="${professore.dataNascita}" /></td>
					<td>${fn:length(professore.corsi)}</td>
					<td>
						<div class="inline">
							<button onclick="window.location.href='./professore?id=${professore.id}'">Modifica</button>
							<button onclick="elimina('${professore.id}')">Elimina</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="width: 50%;">
		<h2>Inserimento</h2>
		<form class="incol" action="./professori" method="post">
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome" />
			</div>
			<div class="inline">
				<label for="cognome">Cognome:</label><input type="text"
					name="cognome" />
			</div>
			<div class="inline">
				<label for="datanascita">Data di nascita:</label><input type="date"
					name="datanascita" />
			</div>
			<div class="inline">
				<input type="submit" value="Inserisci" />
			</div>
		</form>
	</div>
	<button onclick="window.location.href='./'">Indietro</button>
</body>
<script>
	function elimina(id) {
		var xhttp = new XMLHttpRequest();
		xhttp.open('delete', './professore?id=' + id, false); 
		xhttp.send();
		if (xhttp.status === 200)
			location.reload(true);
	}
</script>
</html>