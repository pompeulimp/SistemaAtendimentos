<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	
<title>Colocar Paciente na Fila</title>
</head>

<body>
<c:import url="../include/menu.jsp"></c:import>
 	
	 
<div class="container">
<div class="row" id="main-content">
<div class="well" align="center">
<div class="span4" id="sidebar">
<fieldset>
	
	 <legend>Colocar Paciente na Fila</legend>

	  <fieldset>
		 <form action="buscaPaciente" class="navbar-form navbar-left" role="search">
		 	<label>Buscar Pacimente</label>&nbsp;&nbsp;&nbsp;&nbsp;
		 	<input type="text" name="paciente.nomePaciente" value="${paciente.cpf}" id="nome" placeholder="CPF Paciente" class="form-control" size="30" >
		 	&nbsp;&nbsp;&nbsp;
		 	<input type="submit" id="buscar" class="btn btn-primary" value="Buscar">&nbsp;&nbsp;&nbsp
		 </form>
	</fieldset>
	<fieldset>
		
	   		<div class="panel-heading">
                    <Legend class="panel-title">Lista de Pacientes</Legend>
                </div>
                    <div class="panel-body">
                    <div>
                      <table class="table table-hover">
                            <thead>
                            <td><strong>Nome</strong></td>
                            <td><strong>CPF</strong></td>
                            <td><strong>Escolher</strong></td>
                            </thead>
                            <!--Sql para buscar consultas na fila de antendimento no banco de dados-->
                            <tbody> <c:forEach items="${pacienteList}" var="paciente">
                                <tr>
                                    <td>${paciente.nomePaciente}</td>
                                    <td>${paciente.cpfPaciente}</td>
                                     <td>
                                     	
                                        <a href="${linkTo[FilaController].addPaciente}?pkKey=${paciente.pk_paciente}">
                                        	<button type="submit" id="icnEditar" class="btn btn-default">
                                        	<i class="glyphicon glyphicon-edit"></i>
                                        </button></a>
                                    </td>

                                </tr>
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
		
	  </fieldset>
	 
		<fieldset>
		 	<form action="buscarMedico" class="navbar-form navbar-left" role="search"> 
			 	<label>Buscar Medico</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="medico.nomeMedico"    value="${medico.crm}" id="nome" placeholder="CRM Medico" class="form-control" size="30" >
				&nbsp;&nbsp;&nbsp;
				<input type="submit" id="buscar" class="btn btn-primary" value="Buscar">&nbsp;&nbsp;&nbsp;
			 </form>
		</fieldset>
	<fieldset>
          <div class="panel-heading">
                    <Legend class="panel-title">Lista de Médicos</Legend>
                </div>
                    <div class="panel-body">
                    <div>
                      <table class="table table-hover">
                            <thead>
                            <td><strong>Nome</strong></td>
                            <td><strong>CRM</strong></td>
                            <td><strong>Escolher</strong></td>                            
                            </thead>
                            <!--Sql para buscar consultas na fila de antendimento no banco de dados-->
                            <tbody> <c:forEach items="${medicoList}" var="medico">
                                <tr>
                                    <td>${medico.nomeMedico}</td>
                                    <td>${medico.crm}</td>
                                     <td>
                                        <a href="${linkTo[FilaController].addMedico}?pkKey=${medico.pkMedico}"><button type="submit" id="icnEditar" class="btn btn-default"><i class="glyphicon glyphicon-edit"></i></button></a>
                                    </td>
                                </tr>
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
			
		</fieldset>
	
	<fieldset>
	<form action="create">	
		<div class="panel-heading">
                    <Legend>Resultado</Legend>
                </div>
                    <div class="panel-body">
                    <div>
                      <table class="table table-hover">
                            <thead>
                            <td><strong>Nome Paciente</strong></td>
                            <td><strong>Nome Medico</strong></td>
                            <td><strong></strong></td>                            
                            </thead>
                            <!--Sql para buscar consultas na fila de antendimento no banco de dados-->
                            <tbody> <c:forEach items="${filaList}" var="fila">
                                <tr>
                                    <td>${fila.nomeMedico}</td>
                                    <td>${fila.nomePaciente}</td>
                                </tr>
                               </c:forEach>
                            </tbody>
                        </table>
                    </div>
    
                </div>
	<input type="submit" id="enviar" class="btn btn-primary" value="Salvar">&nbsp;&nbsp;&nbsp;
	<input type="reset" class="btn btn-default" value="Limpar">&nbsp;&nbsp;&nbsp;
	 <a href="<c:url value="/"/>">Voltar</a>
	</form>
	</fieldset>
	</fieldset>
	 </div>
	 </div>
	 </div>
	 </div>
</body>
</html>