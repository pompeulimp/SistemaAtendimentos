<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value="bootstrap/js/relogio.js"/>"></script>

<title>Bem vindo ao Sistema de Atendimentos Web de Hospitais</title>
</head>
<body onload="startTime()">
	<h1>${wecan}</h1>
	<h1 id="txt"></h1>
	<input type="text">	
	<input type="button" value="estilo do bootstrap" class="btn btn-primary">
	<h2><a href="paciente/listar">Listar Pacientes</a></h2>
	<h2><a href="paciente/formulario">Criar Paciente</a></h2>
	<h2><a href="medico/listar">Listar Medicos</a></h2>
	<h2><a href="medico/formulario">Criar Medico</a></h2>
	<h2><a href="especialidade/listar">Listar Especialidades</a></h2>
	<h2><a href="especialidade/formulario">Criar Especialidades</a></h2>
	<h2><a href="hospital/listar">Listar Unidades</a></h2>
	<h2><a href="hospital/formulario">Criar Unidade</a></h2>
</body>
</html>