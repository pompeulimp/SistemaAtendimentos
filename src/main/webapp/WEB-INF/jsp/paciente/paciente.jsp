<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="bootstrap/css/estilo.css"/>"
	rel="stylesheet" type="text/css" />
	
<link href="<c:url value="bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
	
<script type="text/javascript"
	src="<c:url value="bootstrap/js/validacoesFomulario.js"/>"></script>

<title>Cadastro_Paciente</title>
</head>

<body>
<div class="well" align="center">
 <h1>${paciente}</h1>
 <form action="" id="cadastroPaciente">
<table>
 <tr><td>Nome: </td><td><input type="text" id="nome" onblur="validacao('nome')"></td></tr>
 <tr><td>CPF: </td><td><input type="text" id="cpf" onblur="validacao('cpf')"></td></tr>
 <tr><td>Endereço: </td><td><input type="text" id="endereco" onblur="validacao('endereco')"></td></tr>
 <tr><td>Telefone: </td><td><input type="text" id="telefone" onblur="validacao('telefone')"></td></tr>
 <tr align="center"><td colspan = 2><br><input type="submit" id="enviar" class="btn btn-warning" value="Salvar">.        .<input type="reset" class="btn btn-warning" value="Limpar"></td></tr>
 </table>
 </form>
 </div>
</body>
</html>


