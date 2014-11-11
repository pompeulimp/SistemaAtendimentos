<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="../bootstrap/css/estilo.css"/>"
	rel="stylesheet" type="text/css" />
	
<link href="<c:url value="../bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
	
<script type="text/javascript"
	src="<c:url value="ootstrap/js/validacoesFomulario.js"/>"></script>

<title>CadastroMedicos</title>
</head>

<body>

<div class="container">
<div class="row" id="main-content">
<div class="well" align="center">
<div class="span4" id="sidebar">
 
 <form action="create" id="cadastroMedico">
 <fieldset>
 <legend></legend>
 <input type="hidden" name="medico.pkMedico" value="${medico.pkMedico}"/>
 <input type="text" name="medico.nomeMedico" value="${medico.nomeMedico}" id="nome" placeholder="Nome Completo" class="form-control" size="50">
 <input type="text" name="medico.crm" value="${medico.crm}" placeholder="crm" id="crm" placeholder="CRM" class="form-control" size="50">
 <!--<input type="text" id="cpf" placeholder="CPF/CNPJ" class="form-control" size="50">
  <input type="text" id="nacimento" placeholder="Data nacimento" class="form-control" size="50">
 <input type="text" id="endereco" placeholder="Endereço" class="form-control" size="50">
 <input type="text" id="bairro" placeholder="Bairro" class="form-control" size="50" >
 <input type="text" id="cidade" placeholder="Cidade" class="form-control" size="50" > 
 <input type="text" id="fone" placeholder="Celular" class="form-control" size="50">
 <input type="text" id="email" placeholder="Email" class="form-control" size="50" > -->
 <input type="text" id="telefone" name="medico.telMedico" value="${medico.telMedico}"  placeholder="Telefone" class="form-control" size="50">
 <input type="text" id="disponibilidade" name="medico.disponibilidade" value="${medico.disponibilidade}" placeholder="Disponibilidade" class="form-control" size="50"/>
 
 <!-- <input type="text" id="login" placeholder="Login" class="form-control" size="50" >
 <input type="password" id="password" placeholder="Senha" class="form-control" size="50" >-->

 <br>
 <input type="submit" id="enviar" onclick=" return validaFormulario()" class="btn btn-warning" value="Salvar">&nbsp;&nbsp;&nbsp;
 <input type="reset" class="btn btn-warning" value="Limpar">&nbsp;&nbsp;&nbsp;
 <a href="/sistemaantendimento">Voltar</a>
</fieldset>
 </form>
 </div>
 </div>
 </div>
 </div>
</body>
</html>