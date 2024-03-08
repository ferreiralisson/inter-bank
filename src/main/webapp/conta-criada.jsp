<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta criada</title>
</head>
<body>

	<h1>
		Conta, <c:out value="${conta.numeroConta}" /> do cliente <c:out value="${conta.nomeCliente}" />
		criado com sucesso!
	</h1>

</body>
</html>