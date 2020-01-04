<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/aplicacao" var="linkNovaEmpresa" >
	<c:param name="indOperacao" value="fazerCadastro" />
	<c:param name="acao" value="NovaEmpresa" />
</c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar nova empresa</title>
</head>
<body>
	<c:import url="info-usuario.jsp" />
	<form action="${ linkNovaEmpresa }" method="POST">
		Nome: <input type="text" name="nome">
		<br/>
		<br/>
		Data: <input type="text" name="data">
		<br/>
		<br/>
		<input type="submit" value="Enviar">
	</form>

</body>
</html>