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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <style type="text/css">
            .bs-example{
                margin: 20px;
            }
        </style>

<title>Bem vindo ao Sistema de Atendimentos Web de Hospitais</title>
</head>
<body onload="startTime()">
<<<<<<< HEAD
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
=======
	
	        <div class="bs-example">
            <nav id="myNavbar" class="navbar navbar-default" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Nome do Sistema</a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-hospital-o"></i>&nbsp;Página Inicial</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle"><i class="fa fa-list-alt"></i>&nbsp;Cadastro <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="paciente/formulario"><i class="fa fa-user"></i>&nbsp;Paciente</a></li>
                                    <li><a href="medico/formulario"><i class="fa fa-user-md"></i>&nbsp;Médico</a></li>
                                    <li><a href="hospital/hospital"><i class="fa fa-plus"></i>&nbsp;Hospital</a></li>
                                    <li><a href="especialidade/formulario"><i class="fa fa-plus"></i>&nbsp;Especialidade</a></li>
                                </ul>
                            </li>
                            <li><a href=""><i class="fa fa-medkit"></i>&nbsp;Marcar Consulta</a></li>
                            <li><a href=""><i class="fa fa-list-ol"></i>&nbsp;Fila</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle"><i class="fa fa-list-ul"></i>&nbsp;Visualizar Cadastros <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="paciente/listar"><i class="fa fa-user"></i>&nbsp;Paciente</a></li>
                                    <li><a href="medico/listar"><i class="fa fa-user-md"></i>&nbsp;Médico</a></li>
                                    <li><a href="#"><i class="fa fa-plus"></i>&nbsp;Hospital</a></li>
                                </ul>
                            </li>
                            <li><a href=""><i class="fa fa-file"></i>&nbsp;Relatórios</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Ajuda&nbsp;<i class="fa fa-question"></i></a></li>
                            <li><a href="#">Deslogar&nbsp;<i class="fa fa-sign-out"></i></a></li>
                            <li><p id="txt"></p></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
	
>>>>>>> 7ddc9091b785501f364a52f461a0e5e8a2fbab7f
</body>
</html>