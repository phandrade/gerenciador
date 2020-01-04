<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/aplicacao" var="linkAplicacao">
</c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Empresas</title>
</head>
<body>
<c:if test="${not empty empresa }">
	Empresa ${ empresa } cadastrada com sucesso!<br>
</c:if>
	<c:import url="info-usuario.jsp" />

	Lista de Empresas
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>
				${ empresa.nome }
				-
				<fmt:formatDate	value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />
				&nbsp;
				<a href="${linkAplicacao}?acao=EditarEmpresa&idEmpresa=${empresa.id}">editar</a>
				&nbsp;
				<a href="${linkAplicacao}?acao=RemoverEmpresa&idEmpresa=${empresa.id}">remover</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>