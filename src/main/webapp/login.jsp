<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Harjoitustyö</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h1>Kirjaudu</h1>

	<form method="get" action="login">
		<table>
			<tr>
				<td>PIN koodi (vinkki: 42)</td>
				<td><input type="number" name="salasana"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-success" action="kirjaudu"
					value="Login"></td>
			</tr>
		</table>
	</form>




</body>
</html>