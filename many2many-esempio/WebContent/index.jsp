<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Courses</title>
<link rel="stylesheet" type="text/css" href="/many2many-esempio/css/courses.css">
</head>
<body>
	<h2>Benvenuto in Courses!</h2>
	<p>Seleziona la vista da visualizzare:</p>
	<div class="incol">
		<button class="index-btn" onclick="window.location.href='./studenti'">Studenti</button>
		<button class="index-btn" onclick="window.location.href='./professori'">Professori</button>
		<button class="index-btn" onclick="window.location.href='./corsi'">Corsi</button>
	</div>
</body>
</html>