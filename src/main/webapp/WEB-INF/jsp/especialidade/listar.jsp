<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Especialidades</title>
</head>
<body>
<c:import url="../include/menu.jsp"></c:import>
	<c:if test="${not empty mensagem }">
		${mensagem}
		${especialidade.descricao}
	</c:if>

	<div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <Legend>Lista de Especialidades</Legend>
                     <div style="text-align: right;"> <a href="formulario"><button type="submit"  id="icnNovoPaciente" class="btn btn-default">Nova Especialidade</button></a></div>
                </div>
                    <div class="panel-body">
                    <div>
                      <table class="table table-hover">
                            <thead>
                            <td><strong>Descrição</strong></td>
                            <td><strong>Editar</strong></td>
                            <td><strong>Excluir</strong></td>
                            </thead>
                            <!--Sql para buscar consultas na fila de antendimento no banco de dados-->
                            <tbody> <c:forEach items="${especialidadeList}" var="especialidade">
                                <tr>
                                    <td>${especialidade.descricao}</td>
                                     <td>
                                        <a href="${linkTo[EspecialidadeController].editar}?pkKey=${especialidade.pkEspecialidade}"><button type="submit" id="icnEditar" class="btn btn-default"><i class="glyphicon glyphicon-edit"></i></button></a>
                                    </td>
                                    <td>
                                        <a href="${linkTo[EspecialidadeController].deletar}?pkKey=${especialidade.pkEspecialidade}"> <button type="submit" id="icnCancelar" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i></button></a>
                                    </td>
                                </tr>
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
	<a href="<c:url value="/"/>"></a>

</body>
</html>