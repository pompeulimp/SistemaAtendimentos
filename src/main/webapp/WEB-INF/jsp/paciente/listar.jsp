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
	
	<div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <Legend>Lista de Pacientes</Legend>
                     <div style="text-align: right;"> <a href="formulario"><button type="submit"  id="icnNovoPaciente" class="btn btn-default">Novo Paciente</button></a></div>
                </div>
                    <div class="panel-body">
                    <div>
                      <table class="table table-hover">
                            <thead>
                            <td><strong>Nome</strong></td>
                            <td><strong>CPF</strong></td>
                            <td><strong>Endereço</strong></td>
                            <td><strong>Telefone</strong></td>
                            <td><strong>Editar</strong></td>
                            <td><strong>Excluir</strong></td>
                            </thead>
                            <!--Sql para buscar consultas na fila de antendimento no banco de dados-->
                            <tbody> <c:forEach items="${pacienteList}" var="paciente">
                                <tr>
                                    <td>${paciente.nomePaciente}</td>
                                    <td>${paciente.cpfPaciente}</td>
                                    <td>${paciente.enderecoPaciente}</td>
                                    <td>${paciente.telefonePaciente}</td>
                                     <td>
                                        <a href="${linkTo[PacienteController].editar}?pkKey=${paciente.pk_paciente}"><button type="submit" id="icnEditar" class="btn btn-default"><i class="glyphicon glyphicon-edit"></i></button></a>
                                    </td>
                                    <td>
                                        <a href="${linkTo[PacienteController].deletar}?pkKey=${paciente.pk_paciente}"> <button type="submit" id="icnCancelar" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i></button></a>
                                    </td>
                                </tr>
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

</body>
</html>