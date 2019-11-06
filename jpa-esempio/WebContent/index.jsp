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
	<h2>Benvenuto in Corporate!</h2>
	<p>Scegli la tabella da visualizzare:</p>
	<div class="incol">
		<button class="index-btn" onclick="window.location.href='./dipendenti'">Dipendenti</button>
		<button class="index-btn" onclick="window.location.href='./responsabili'">Responsabili</button>
		<button class="index-btn" onclick="window.location.href='./ruoli'">Ruoli</button>
		<button class="index-btn" onclick="window.location.href='./uffici'">Uffici</button>
	</div>
</body>
</html>