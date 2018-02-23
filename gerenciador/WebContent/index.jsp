<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		Bem vindo ao nosso gerenciador de empresas!<br/>

		<c:if test="${not empty usuarioLogado}">
			Logado como ${usuarioLogado.email}
		</c:if>

		<form action="novaEmpresa" method="post">
			<label>
				Nome:
				<input type="text" name="nome"/>
			</label>
			<input type="submit" value="Enviar"/>
		</form>

		<form action="login" method="post">
			<label>
				Email:
				<input type="email" name="email"/>
			</label>
			<label>
				Senha:
				<input type="password" name="senha"/>
			</label>
			<input type="submit" value="Enviar"/>
		</form>

		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="Logout">
			<input type="submit" value="Deslogar"/>
		</form>
	</body>
</html>