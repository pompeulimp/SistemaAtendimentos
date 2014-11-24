<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	
<script type="text/javascript"
	src="<c:url value="ootstrap/js/validacoesFomulario.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Medicos</title>
</head>
<body>
<c:import url="../include/menu.jsp"></c:import>
	<c:if test="${not empty mensagem }">
		${mensagem}
	</c:if>
<<<<<<< HEAD
	<h3>Lista Medicos</h3>
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
=======
	<div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Lista de Médicos
                     <div style="text-align: right;"> <a href="formulario"><button type="submit"  id="icnNovoPaciente" class="btn btn-default">Novo Médico</button></a></div>
                </div>
                    <div class="panel-body">
                    <div>
                      <table class="table table-hover">
                            <thead>
                            <td><strong>Nome</strong></td>
                            <td><strong>CRM</strong></td>
                            <td><strong>Telefone</strong></td>
                            <td><strong>Disponibilidade</strong></td>
                            <td><strong>Editar</strong></td>
                            <td><strong>Excluir</strong></td>
                            </thead>
                            <!--Sql para buscar consultas na fila de antendimento no banco de dados-->
                            <tbody> <c:forEach items="${medicoList}" var="medico">
                                <tr>
                                    <td>${medico.nomeMedico}</td>
                                    <td>${medico.crm}</td>
                                    <td>${medico.telMedico}</td>
                                    <td>${medico.disponibilidade}</td>
                                     <td>
                                        <a href="${linkTo[MedicoController].editar}?pkKey=${medico.pkMedico}"><button type="submit" id="icnEditar" class="btn btn-default"><i class="glyphicon glyphicon-edit"></i></button></a>
                                    </td>
                                    <td>
                                        <a href="${linkTo[MedicoController].deletar}?pkKey=${medico.pkMedico}"> <button type="submit" id="icnCancelar" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i></button></a>
                                    </td>
                                </tr>
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
>>>>>>> 89f0ef424a72a4ab8a905598caead897729c9eb0
	<a href="<c:url value="/"/>">
</body>
</html>