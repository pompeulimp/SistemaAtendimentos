<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fila de Atendimentos</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:import url="../include/javascripts.jsp"></c:import>
<c:import url="../include/css.jsp"></c:import>
</head>
<body>
<c:import url="../include/menu.jsp"></c:import>
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<Legend>Fila de atendimento</Legend>
			</div>
			<div class="panel-body">
				<div>
					<table class="table table-hover">
						<thead>
							<td><strong>Ordem</strong></td>
							<td><strong>Medico</strong></td>
							<td><strong>Paciente </strong></td>
							<td><strong>Status </strong><br>
							<td><strong>Entrada </strong><br>
							<td><strong>Saida </strong><br>
						</thead>
						<!--Sql para buscar consultas na fila de antendimento no banco de dados-->
						<tbody>
							<tr>
								<c:forEach items="${filaList}" var="fila">
									<tr>
										<td>${fila.pkFila}</td>
										<td>${fila.pkPaciente}</td>
										<td>${fila.pkMedico}</td>
										<td>${fila.status}</td>
										<td><fmt:formatDate type="both" 
            							value="${fila.horaEntrada.time}" /></td>
            							<td><fmt:formatDate type="both" 
            							value="${fila.horaSaida.time}" /></td>
										<td><a href="${linkTo[FilaController].editar}?pkKey=${especialidade.pkEspecialidade}"><button
													type="submit" id="icnEditar" class="btn btn-default">
													<i class="glyphicon glyphicon-edit"></i>
												</button></a></td>
										<td><a
											href="${linkTo[FilaController].deletar}?pkKey=${especialidade.pkEspecialidade}">
												<button type="submit" id="icnCancelar"
													class="btn btn-danger">
													<i class="glyphicon glyphicon-remove"></i>
												</button>
										</a></td>
									</tr>
								</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>