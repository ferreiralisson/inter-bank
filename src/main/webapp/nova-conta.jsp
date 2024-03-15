<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/inter?acao=CriarConta" var="novaConta"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de conta</title>
</head>
<body>

	<form action="${novaConta}" method="post">

		Numero da conta: <input type="text" name="numero-conta"  /> <br> <br>
		Nome do cliente: <input type="text" name="nome-cliente">
		<input type="submit" />
	</form>

</body>
</html>