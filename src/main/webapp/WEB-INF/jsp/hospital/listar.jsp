<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="../bootstrap/css/estilo.css"/>"
	rel="stylesheet" type="text/css" />
	
<link href="<c:url value="../bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
	
<script type="text/javascript"
	src="<c:url value="ootstrap/js/validacoesFomulario.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Unidades</title>
</head>
<body>
	<c:if test="${not empty mensagem }">
		${mensagem}
	</c:if>
	<h3>Lista Unidades</h3>
	<a href="formulario">Novo Hospital</a>
	<c:forEach items="${hospitalList}" var="hospital">
		<div>${hospital.razaosocial}
			${hospital.nomeFantasia}
			${hospital.cnpj}
			${hospital.enderecoHospital}
			${hospital.telefonehospital}
			<a href="${linkTo[hospitalController].editar}?pkKey=${hospital.pkHospital}">Editar</a>		 
			<a href="${linkTo[hospitalController].deletar}?pkKey=${hospital.pkHospital}">deletar</a>
		</div>
	</c:forEach>
</body>
</html>