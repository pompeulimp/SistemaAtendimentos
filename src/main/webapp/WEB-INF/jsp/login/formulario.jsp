<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formulário de Login</title>
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
</head>
<body>

	<form action="<c:url value='/login/autentica'/>" method="post">
		<h2 class="form-signin-heading">Faça login para acessar o Sistema de Atendimentos</h2>
		<input type="text" class="form-control" name="usuario.nomeUsuario" placeholder="Nome"/>
  		<input type="password" class="form-control" name="usuario.senha" placeholder="Senha"/>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
	
	</form>
	<c:if test="${not empty errors }">
		<div class="alert alert-danger">
			<c:forEach items="${errors }" var="erro">
				${erro.category } - ${erro.message }<br/>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>