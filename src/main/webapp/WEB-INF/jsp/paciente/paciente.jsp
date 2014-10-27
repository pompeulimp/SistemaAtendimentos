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
 <h1>${paciente}</h1>
 <form action="" id="cadastroPaciente">
 <p>Nome: </p><input type="text" id="nome" onblur="validaNulidade('nome')"><br>
 <p>CPF: </p><input type="text" id="cpf" onblur="validaNulidade('cpf')"><br>
 <p>Endereço: </p><input type="text" id="endereco" onblur="validaNulidade('endereco')"><br>
 <p>Telefone: </p><input type="text" id="telefone" onblur="validaNulidade('telefone')"><br><br>
 <input type="submit" id="enviar" class="btn btn-warning" value="Salvar" onclick="teste()"><input type="reset" value="Limpar">
 </form>
</body>
</html>


