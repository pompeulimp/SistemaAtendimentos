<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="bootstrap/css/estilo.css"/>" rel="stylesheet"
	type="text/css" />

<link href="<c:url value="bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<c:url value="bootstrap/js/validacoesFomulario.js"/>"></script>

<title>Cadastro_Paciente</title>
</head>

<body>
	<div class="container">
		<div class="row" id="main-content">
			<div class="well" align="center">
				<div class="span4" id="sidebar">
					<h1 class="text-muted">${paciente}</h1>

					<form action="" id="cadastroPaciente" method="post">
						<fieldset>
							<legend></legend>

							<input type="text" id="nome" placeholder="Nome Completo"
								class="form-control" size="50" onblur="validacao('nome',false)">
							<input type="text" id="cpf" placeholder="CPF"
								class="form-control" size="50" onblur="validacao('cpf',false)">
							<input type="text" id="endereco" placeholder="Endereço"
								class="form-control" size="50"
								onblur="validacao('endereco',false)"> <input type="text"
								id="telefone" placeholder="Telefone" class="form-control"
								size="50" onblur="validacao('telefone',false)"> <br>
							<input type="submit" id="enviar"
								onclick=" return validaFormulario()" class="btn btn-warning"
								value="Salvar">&nbsp;&nbsp;&nbsp; <input type="reset"
								class="btn btn-warning" value="Limpar">&nbsp;&nbsp;&nbsp;
							<a href="http://localhost:8080/vraptor-blank-project/">Voltar</a>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>


