<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Corso</title>
<link rel="stylesheet" type="text/css" href="/many2many-esempio/css/courses.css">
</head>
<body>
	<h2>Corso</h2>
	<div style="width: 50%;">
		<h2>Modifica</h2>
		<form class="incol" action="./corso" method="post">
			<input type="hidden" name="id" value="${corso.id}" />
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome"
					value="${corso.nome}" />
			</div>
			<div class="inline">
				<label for="descrizione">Descrizione:</label>
				<textarea rows="10" cols="20" maxlength="255" name="descrizione">${corso.descrizione}</textarea>
			</div>
			<div class="inline">
				<label for="professore">Professore:</label> <select
					name="professore">
					<c:forEach var="professore" items="${professori}">
						<c:choose>
							<c:when test="${professore.id == corso.professore.id}">
								<option value="${professore.id}" selected>${professore.nome}
									${professore.cognome}</option>
							</c:when>
							<c:otherwise>
								<option value="${professore.id}">${professore.nome}
									${professore.cognome}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="inline">
				<label>Studenti:</label>
				<ul>
					<c:forEach var="studente" items="${corso.studenti}">
						<li>${studente.nome}${studente.cognome}</li>
					</c:forEach>
				</ul>
			</div>
			<div class="inline">
				<input type="submit" value="Modifica" />
			</div>
		</form>
	</div>
	<button onclick="window.location.href='./corsi'">Indietro</button>
</body>
</html>