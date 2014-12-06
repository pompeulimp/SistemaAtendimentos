<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<table class="table table-hover">
		<thead>
			<td><strong>Nome</strong></td>
			<td><strong>CRM</strong></td>
		</thead>
		<tbody>
			<tr>
				<td>${medico.nomeMedico}</td>
				<td>${medico.crm}</td>
			</tr>
		</tbody>
	</table>
</div>


