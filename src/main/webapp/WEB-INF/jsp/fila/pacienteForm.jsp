<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table class="table table-hover">
	<thead>
		<th><strong>Nome</strong></th>
		<th><strong>CPF</strong></th>
	</thead>
	<tbody>
		<tr>
			<td>${paciente.nomePaciente}</td>
			<td>${paciente.cpfPaciente}</td>
		</tr>
	</tbody>
</table>
<c:import url="../include/erros.jsp"></c:import>
