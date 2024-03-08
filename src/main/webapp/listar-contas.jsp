<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.inter.model.Conta"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/contas" var="listarContas" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banco inter</title>
</head>
<body>

	Listando contas cadastrados:
	<br />

	<ul>
		<c:forEach items="${contas}" var="conta">
			<li>
				${conta.numeroConta} - ${conta.nomeCliente}
				<a href="#">editar</a>
				<a href="#">remover</a>
			</li>
		</c:forEach>

	</ul>

</body>
</html>