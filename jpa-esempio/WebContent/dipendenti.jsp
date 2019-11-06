<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dipendenti</title>
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
	<h2>Dipendenti</h2>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Ruolo</th>
				<th>Ufficio</th>
				<th>Nome responsabile</th>
				<th>Cognome responsabile</th>
				<th>Ufficio responsabile</th>
				<th>Comandi</th>
			</tr>
			<c:forEach var="dipendente" items="${dipendenti}">
				<tr>
					<td>${dipendente.id}</td>
					<td>${dipendente.nome}</td>
					<td>${dipendente.cognome}</td>
					<td>${dipendente.ruolo.nome}</td>
					<td>${dipendente.ufficio.nome}</td>
					<td>${dipendente.responsabile.nome}</td>
					<td>${dipendente.responsabile.cognome}</td>
					<td>${dipendente.responsabile.ufficio.nome}</td>
					<td>
						<div class="inline">
							<button onclick="window.location.href='./dipendente?id=${dipendente.id}'">Modifica</button>
							<button onclick="elimina('${dipendente.id}')">Elimina</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="width: 50%;">
		<h2>Inserimento</h2>
		<form class="incol" action="./dipendenti" method="post">
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome" />
			</div>
			<div class="inline">
				<label for="cognome">Cognome:</label><input type="text"
					name="cognome" />
			</div>
			<div class="inline">
				<label for="settore">Ruolo:</label> <select name="ruolo">
					<c:forEach var="ruolo" items="${ruoli}">
						<option value="${ruolo.id}">${ruolo.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="inline">
				<label for="settore">Ufficio:</label> <select name="ufficio">
					<c:forEach var="ufficio" items="${uffici}">
						<option value="${ufficio.id}">${ufficio.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="inline">
				<label for="settore">Responsabile:</label> <select
					name="responsabile">
						<option value="">Nessuno</option>
					<c:forEach var="responsabile" items="${responsabili}">
						<option value="${responsabile.id}">${responsabile.nome}
							${responsabile.cognome}</option>
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
		xhttp.open('delete', './dipendente?id=' + id, false); 
		xhttp.send();
		if (xhttp.status === 200)
			location.reload(true);
	}
</script>
</html>