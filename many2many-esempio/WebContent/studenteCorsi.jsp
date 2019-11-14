<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Corsi studente</title>
<link rel="stylesheet" type="text/css" href="/many2many-esempio/css/courses.css">
</head>
<body>
	<h2>Corsi di ${studente.nome} ${studente.cognome}</h2>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Comandi</th>
			</tr>
			<c:forEach var="corso" items="${studente.corsi}">
				<tr>
					<td>${corso.id}</td>
					<td>${corso.nome}</td>
					<td>${corso.descrizione}</td>
					<td>
						<div class="inline">
							<button onclick="elimina('${studente.id}', '${corso.id}')">Elimina da studente</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="width: 50%;">
		<c:if test="${!corsi.isEmpty()}">
			<h2>Nuovo corso</h2>
			<form class="incol" action="../studente/corsi" method="post">
				<div class="inline">
					<input type="hidden" name="id" value="${studente.id}" />
					<label for="corso">Corso:</label> <select
						name="corso">
						<c:forEach var="corso" items="${corsi}">
							<option value="${corso.id}">${corso.nome} - ${corso.descrizione}</option>
						</c:forEach>
					</select>
				</div>
				<div class="inline">
					<input type="submit" value="Aggiungi a studente" />
				</div>
			</form>
		</c:if>
	</div>
	<button onclick="window.location.href='../studenti'">Indietro</button>
</body>
<script>
	function elimina(id,corso) {
		var xhttp = new XMLHttpRequest();
		xhttp.open('delete', '../studente/corsi?id=' + id + '&corso=' + corso, false);
		xhttp.send();
		if (xhttp.status === 200)
			location.reload(true);
	}
</script>
</html>