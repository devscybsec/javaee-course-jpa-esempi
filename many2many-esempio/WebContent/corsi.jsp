<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Corsi</title>
<link rel="stylesheet" type="text/css" href="/many2many-esempio/css/courses.css">
</head>
<body>
	<h2>Corsi</h2>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Professore</th>
				<th># Studenti</th>
				<th>Comandi</th>
			</tr>
			<c:forEach var="corso" items="${corsi}">
				<tr>
					<td>${corso.id}</td>
					<td>${corso.nome}</td>
					<td>${corso.descrizione}</td>
					<td>${corso.professore.nome}${corso.professore.cognome}</td>
					<td>${fn:length(corso.studenti)}</td>
					<td>
						<div class="inline">
							<button onclick="window.location.href='./corso?id=${corso.id}'">Modifica</button>
							<button onclick="elimina('${corso.id}')">Elimina</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="width: 50%;">
		<h2>Inserimento</h2>
		<form class="incol" action="./corsi" method="post">
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome" />
			</div>
			<div class="inline">
				<label for="descrizione">Descrizione:</label>
				<textarea rows="10" cols="20" maxlength="255" name="descrizione"></textarea>
			</div>
			<div class="inline">
				<label for="professore">Professore:</label> <select
					name="professore">
					<c:forEach var="professore" items="${professori}">
						<option value="${professore.id}">${professore.nome}
							${professore.cognome}</option>
					</c:forEach>
				</select>
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
		xhttp.open('delete', './corso?id=' + id, false);
		xhttp.send();
		if (xhttp.status === 200)
			location.reload(true);
	}
</script>
</html>