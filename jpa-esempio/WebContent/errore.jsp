<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Corporate</title>
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
	.index-btn {
		width: 200px;	
	}
</style>
</head>
<body>
	<h2>Errore!</h2>
	<p>${errore}</p>
	<button onclick="window.history.back()">Indietro</button>
</body>
</html>