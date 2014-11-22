<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	
<title>Lista Pacientes</title>
</head>
<body>
<c:import url="../include/menu.jsp"></c:import>	
	<c:if test="${not empty mensagem }">
		${mensagem}
	</c:if>
	<h3>Lista Pacientes</h3>
	<a href="formulario">Novo Paciente</a>
	<c:forEach items="${pacienteList}" var="paciente">
		<div>${paciente.nomePaciente}
			${paciente.cpfPaciente} ${paciente.enderecoPaciente}
			${paciente.telefonePaciente}
			<a href="${linkTo[PacienteController].editar}?pkKey=${paciente.pk_paciente}">Editar</a>		 
			<a href="${linkTo[PacienteController].deletar}?pkKey=${paciente.pk_paciente}">deletar</a>
		</div>
	</c:forEach>
	<a href="<c:url value="/"/>">Voltar</a>
</body>
</html>