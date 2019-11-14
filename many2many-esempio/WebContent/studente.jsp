<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Studente</title>
<link rel="stylesheet" type="text/css" href="/many2many-esempio/css/courses.css">
</head>
<body>
	<h2>Studente</h2>
	<div style="width: 50%;">
		<h2>Modifica</h2>
		<form class="incol" action="./studenti" method="post">
			<input type="hidden" name="id" value="${studente.id}" />
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome" value="${studente.nome}" />
			</div>
			<div class="inline">
				<label for="cognome">Cognome:</label><input type="text"
					name="cognome" value="${studente.cognome}" />
			</div>
			<div class="inline">
				<label for="datanascita">Data di nascita:</label><input type="date"
					name="datanascita" value="${studente.dataNascita}" />
			</div>
			<div class="inline">
				<input type="submit" value="Modifica" />
			</div>
		</form>
	</div>
	<button onclick="window.location.href='./studenti'">Indietro</button>
</body>
</html>