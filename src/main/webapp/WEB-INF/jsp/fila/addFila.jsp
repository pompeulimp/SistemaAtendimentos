<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset>
	<div>
		<form class="navbar-form navbar-left"
			action="<c:url value="/addPacienteFila"/>" method="post">
			
			<label><Strong>Nome Paciente :</Strong>${paciente.nomePaciente}</label>
			<input type="hidden"value="${paciente.pk_paciente}" name="pkPaciente">
			<br />
			<label><Strong>Nome Medico :</Strong>${medico.nomeMedico}</label>
			<input type="hidden" value="${medico.pkMedico}" name="pkMedico"><br/>
			<button class="btn btn-primary">Adicionar à Fila</button>		
		</form>
	</div>
</fieldset>