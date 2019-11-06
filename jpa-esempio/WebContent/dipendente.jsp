<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dipendente</title>
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
	<h2>Dipendente</h2>
	<div style="width: 50%;">
		<h2>Modifica</h2>
		<form class="incol" action="./dipendente" method="post">
			<input type="hidden" name="id" value="${dipendente.id}" />
			<div class="inline">
				<label for="nome">Nome:</label><input type="text" name="nome"
					value="${dipendente.nome}" />
			</div>
			<div class="inline">
				<label for="cognome">Cognome:</label><input type="text"
					name="cognome" value="${dipendente.cognome}" />
			</div>
			<div class="inline">
				<label for="settore">Ruolo:</label> <select name="ruolo">
					<c:forEach var="ruolo" items="${ruoli}">
						<c:choose>
							<c:when test="${ruolo.id == dipendente.ruolo.id}">
								<option value="${ruolo.id}" selected>${ruolo.nome}</option>
							</c:when>
							<c:otherwise>
								<option value="${ruolo.id}">${ruolo.nome}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="inline">
				<label for="settore">Ufficio:</label> <select name="ufficio">
					<c:forEach var="ufficio" items="${uffici}">
						<c:choose>
							<c:when test="${ufficio.id == dipendente.ufficio.id}">
								<option value="${ufficio.id}" selected>${ufficio.nome}</option>
							</c:when>
							<c:otherwise>
								<option value="${ufficio.id}">${ufficio.nome}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="inline">
				<label for="settore">Responsabile:</label> <select
					name="responsabile">
					<option value="">Nessuno</option>
					<c:forEach var="responsabile" items="${responsabili}">
						<c:choose>
							<c:when test="${responsabile.id == dipendente.responsabile.id}">
								<option value="${responsabile.id}" selected>${responsabile.nome}
									${responsabile.cognome}</option>
							</c:when>
							<c:otherwise>
								<option value="${responsabile.id}">${responsabile.nome}
									${responsabile.cognome}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			<div class="inline">
				<input type="submit" value="Modifica" />
			</div>
		</form>
	</div>
	<button onclick="window.location.href='./dipendenti'">Indietro</button>
</body>
</html>