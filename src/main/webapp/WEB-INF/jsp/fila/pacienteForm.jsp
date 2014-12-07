<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table class="table table-hover">
	<thead>
		<th><strong>codigo</strong></th>
		<th><strong>Nome</strong></th>
		<th><strong>CPF</strong></th>
	</thead>
	<tbody>
		<tr>
			<td>${paciente.pk_paciente}</td>
			<td>${paciente.nomePaciente}</td>
			<td>${paciente.cpfPaciente}</td>
		</tr>
	</tbody>
</table>
<c:import url="../fila/medicoSearch.jsp"></c:import>
<c:import url="../include/erros.jsp"></c:import>

