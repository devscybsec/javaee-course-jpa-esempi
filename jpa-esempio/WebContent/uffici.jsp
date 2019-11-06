<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Uffici</title>
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
	<h2>Uffici</h2>
	<table>
		<tbody>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dimensioni</th>
				<th>Comandi</th>
			</tr>
			<c:forEach var="ufficio" items="${uffici}">
				<tr>
					<td>${ufficio.id}</td>
					<td>${ufficio.nome}</td>
					<td>${ufficio.dimensioni}</td>
					<td>
						<div class="inline">
							<button onclick="window.location.href='./ufficio?id=${ufficio.id}'">Modifica</button>
							<button onclick="elimina('${ufficio.id}')">Elimina</button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="width: 50%;">
		<h2>Inserimento</h2>
		<form class="incol" action="./uffici" method="post">
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome" />
			</div>
			<div class="inline">
				<label for="dimensioni">Dimensioni:</label><input type="number"
					name="dimensioni" />
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
		xhttp.open('delete', './ufficio?id=' + id, false); 
		xhttp.send();
		if (xhttp.status === 200)
			location.reload(true);
	}
</script>
</html>