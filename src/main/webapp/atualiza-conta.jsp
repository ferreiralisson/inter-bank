<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/controlador?acao=AtualizarConta" var="atualizarConta" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualização de conta</title>
</head>
<body>

	<form action="${atualizarConta}" method="post">
		Nome do cliente: <input type="text" name="nome-cliente" value="${conta.nomeCliente}"/> <br><br> 
		<input type="hidden" name="numero-conta" value="${conta.numeroConta}" />
		<input type="submit" />
	</form>

</body>
</html>