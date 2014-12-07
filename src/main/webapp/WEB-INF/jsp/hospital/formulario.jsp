<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	
<title>Cadastro de Unidades</title>
</head>

<body>
<c:import url="../include/menu.jsp"></c:import>
<div class="container">
<div class="row" id="main-content">
<div class="well" align="center">
<div class="span4" id="sidebar">
 
 <form action="create">
 <fieldset>
 <legend>Cadastro de Hospitais</legend>
  <input type="text" name="hospital.razaosocial" value="${hospital.razaosocial}" id="razaosocial" placeholder="Razão social" class="form-control" size="50" >
 <input type="text" name="hospital.nomeFantasia" value="${hospital.nomeFantasia}" id="nomefantasia" placeholder="Nome fantasia" class="form-control" size="50" >
 <input type="text" name="hospital.cnpj" value="${hospital.cnpj}" id="cnpj" placeholder="CNPJ" class="form-control" size="50">
 <input type="text" name="hospital.enderecoHospital" value="${hospital.enderecoHospital}" id="endereco" placeholder="Endereço da unidade" class="form-control" size="50">
 <input type="text" name="hospital.telefonehospital" value="${hospital.telefonehospital}" id="telefone" placeholder="Telefone" class="form-control" size="50">

 <br>
 <input type="submit" id="enviar" onclick=" return validaFormulario()" class="btn btn-primary" value="Salvar">&nbsp;&nbsp;&nbsp;
 <input type="reset" class="btn btn-default" value="Limpar">&nbsp;&nbsp;&nbsp;
 <a href="<c:url value="/"/>"></a>
</fieldset>
 </form>
 </div>
 </div>
 </div>
 </div>
</body>
</html>