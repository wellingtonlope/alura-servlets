<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head lang="pt-br">
		<meta charset="UTF-8">
		<title>Busca Empresa</title>
	</head>
	<body>
		Resultado da busca:
		<ul>
		<c:forEach var="empresa" items="${empresas}">
			<li>${empresa.id}: ${empresa.nome}</li>
		</c:forEach>
		</ul>
	</body>
</html>
