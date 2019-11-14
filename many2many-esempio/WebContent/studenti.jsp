<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Studenti</title>
<link rel="stylesheet" type="text/css" href="/many2many-esempio/css/courses.css">
</head>
<body>
	<h2>Studenti</h2>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Data di nascita</th>
				<th># Corsi frequentati</th>
				<th>Comandi</th>
			</tr>
			<c:forEach var="studente" items="${studenti}">
				<tr>
					<td>${studente.id}</td>
					<td>${studente.nome}</td>
					<td>${studente.cognome}</td>
					<td><fmt:formatDate pattern="dd MMMM yyyy" value="${studente.dataNascita}" /></td>
					<td>${fn:length(studente.corsi)}</td>
					<td>
						<div class="inline">
							<button onclick="window.location.href='./studente/corsi?id=${studente.id}'">Corsi</button>
							<button onclick="window.location.href='./studente?id=${studente.id}'">Modifica</button>
							<button onclick="elimina('${studente.id}')">Elimina</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="width: 50%;">
		<h2>Inserimento</h2>
		<form class="incol" action="./studenti" method="post">
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
		xhttp.open('delete', './studente?id=' + id, false); 
		xhttp.send();
		if (xhttp.status === 200)
			location.reload(true);
	}
</script>
</html>