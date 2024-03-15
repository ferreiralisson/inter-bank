<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/contas" var="listarContas" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta criada</title>
</head>

<script>
	function redirectToContas() {
		window.location.href = "${listarContas}";
	}
</script>

<body>

	<h1>
		Conta,
		<c:out value="${conta.numeroConta}" />
		do cliente
		<c:out value="${conta.nomeCliente}" />
		criado com sucesso!
	</h1>

	<button onclick="redirectToContas()" value="Contas">Contas</button>

</body>
</html>

