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
	<h2>Ufficio</h2>
	<div style="width: 50%;">
		<h2>Modifica</h2>
		<form class="incol" action="./ufficio" method="post">
			<input type="hidden" name="id" value="${ufficio.id}" />
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome"
					value="${ufficio.nome}" />
			</div>
			<div class="inline">
				<label for="dimensioni">Dimensioni:</label><input type="number"
					name="dimensioni" value="${ufficio.dimensioni}" />
			</div>
			<div class="inline">
				<input type="submit" value="Modifica" />
			</div>
		</form>
	</div>
	<button onclick="window.location.href='./uffici'">Indietro</button>
</body>
</html>