<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<form class="navbar-form navbar-left"
		action="<c:url value="/fila/addPacienteFila"/>" method="post">
		<label>Paciente</label> <input type="text"
			value="${pacinete.pk_paciente}" name="pkPaciente" disabled="disabled">
		<label>${paciente.nomePaciente}</label> <label>Medico</label> <input
			type="text" value="${medico.pkMedico}" name="pkMedico"
			disabled="disabled"> <label>${medico.nomeMedico}</label> <input
			type="submit" class="btn" value="Adicionar à Fila">
	</form>
</div>