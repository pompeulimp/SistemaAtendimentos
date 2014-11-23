<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                        <!--<a class="navbar-brand" href="#">SAA - Sistema de Agendamento de Atendimentos</a>-->
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="<c:url value="/"/>"><i class="fa fa-hospital-o"></i>&nbsp;Página Inicial</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle"><i class="fa fa-list-alt"></i>&nbsp;Cadastro <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="<c:url value="/usuario/formulario"/>"><i class="fa fa-user"></i>&nbsp;Usuario</a></li>
                                    <li><a href="<c:url value="/paciente/formulario"/>"><i class="fa fa-user"></i>&nbsp;Paciente</a></li>
                                    <li><a href="<c:url value="/medico/formulario"/>"><i class="fa fa-user-md"></i>&nbsp;Médico</a></li>
                                    <li><a href="<c:url value="/hospital/formulario"/>"><i class="fa fa-plus"></i>&nbsp;Hospital</a></li>
                                    <li><a href="<c:url value="/especialidade/formulario"/>"><i class="fa fa-plus"></i>&nbsp;Especialidade</a></li>
                                    <li><a href="<c:url value="/tipo/formulario"/>"><i class="fa fa-plus"></i>&nbsp;Tipo de Atendimento</a></li>
                                </ul>
                            </li>
                            <li><a href=""><i class="fa fa-medkit"></i>&nbsp;Marcar Consulta</a></li>
                            <li><a href=""><i class="fa fa-list-ol"></i>&nbsp;Fila</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle"><i class="fa fa-list-ul"></i>&nbsp;Visualizar Cadastros <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                	<li><a href="<c:url value="/usuario/listar"/>"><i class="fa fa-user"></i>&nbsp;Usuario</a></li>
                                    <li><a href="<c:url value="/paciente/listar"/>"><i class="fa fa-user"></i>&nbsp;Paciente</a></li>
                                    <li><a href="<c:url value="/medico/listar"/>"><i class="fa fa-user-md"></i>&nbsp;Médico</a></li>
                                    <li><a href="<c:url value="/hospital/listar"/>"><i class="fa fa-plus"></i>&nbsp;Hospital</a></li>
                                    <li><a href="<c:url value="/especialidade/listar"/>"><i class="fa fa-plus"></i>&nbsp;Especialidade</a></li>
                                    <li><a href="<c:url value="/tipo/listar"/>"><i class="fa fa-plus"></i>&nbsp;Tipo de Atendiemnto</a></li>
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
