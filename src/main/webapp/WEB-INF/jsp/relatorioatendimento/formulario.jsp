<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	

<title>Relatorio de Atendimentos Diarios</title>
</head>

<body>
<c:import url="../include/menu.jsp"></c:import>
<div class="container">
<div class="row" id="main-content">
<div class="well" align="center">
<div class="span4" id="sidebar">
 
 <form >
 <fieldset>
 <legend>Relatórios</legend>

 <input type="text" id="cpf" placeholder="CPF/CNPJ" class="form-control" size="50">
  <input type="text" id="nacimento" placeholder="Data nacimento" class="form-control" size="50">
   
 <input type="submit" id="enviar" onclick=" return validaFormulario()" class="btn btn-primary" value="Consultar">&nbsp;&nbsp;&nbsp;
 <input type="reset" class="btn btn-default" value="Limpar">&nbsp;&nbsp;&nbsp;

</fieldset>
 </form>
 </div>
 </div>
 </div>
 </div>
</body>
</html>