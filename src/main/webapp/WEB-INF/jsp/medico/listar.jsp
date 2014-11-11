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
<title>Lista de Medicos</title>
</head>
<body>
	<c:if test="${not empty mensagem }">
		${mensagem}
	</c:if>
	<h3>Lista Pacientes</h3>
	<a href="formulario">Novo Medico</a>
	<c:forEach items="${medicoList}" var="medico">
		<div>${medico.nomeMedico}
			${medico.crm}
			${medico.telMedico}
			${medico.disponibilidade}
			<a href="${linkTo[MedicoController].editar}?pkKey=${medico.pkMedico}">Editar</a>		 
			<a href="${linkTo[MedicoController].deletar}?pkKey=${medico.pkMedico}">deletar</a>
		</div>
	</c:forEach>
</body>
</html>