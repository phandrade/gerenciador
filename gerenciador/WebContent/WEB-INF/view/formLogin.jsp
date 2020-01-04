<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/aplicacao" var="linkLogin" >
	<c:param name="indOperacao" value="fazerLogin" />
	<c:param name="acao" value="Login" />
</c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar nova empresa</title>
</head>
<body>

	<c:if test="${ loginInvalido }">
		<h3>Login inválido!</h3>
	</c:if>

	<form action="${ linkLogin }" method="POST">
		Login: <input type="text" name="login">
		<br/>
		<br/>
		Senha: <input type="password" name="senha">
		<br/>
		<br/>
		<input type="submit" value="Enviar">
	</form>

</body>
</html>