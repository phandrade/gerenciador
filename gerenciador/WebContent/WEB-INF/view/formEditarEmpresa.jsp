<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/aplicacao" var="linkEditarEmpresa">
	<c:param name="indOperacao" value="fazerAlteracao" />
	<c:param name="acao" value="EditarEmpresa" />
</c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar empresa</title>
</head>
<body>
	<c:import url="info-usuario.jsp" />
	<form action="${ linkEditarEmpresa }" method="POST">
		Nome: <input type="text" name="nome" value="${empresa.nome }">
		<br/>
		<br/>
		Data: <input type="text" name="data" value="<fmt:formatDate	value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />">
		<br/>
		<br/>
		<input type="hidden" name="idEmpresa" value="${empresa.id }">
		<input type="submit" value="Enviar">
	</form>

</body>
</html>