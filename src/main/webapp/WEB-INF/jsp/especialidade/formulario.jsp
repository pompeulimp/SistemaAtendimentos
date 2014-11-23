<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	

<title>Especialidades Medicas</title>
</head>
<body>
<div>
	<c:import url="../include/menu.jsp"></c:import>
</div>
<div class="container">
<div class="row" id="main-content">
<div class="well" align="center">
<div class="span4" id="sidebar">
	<form action="create">
	<fieldset>
 	<legend></legend>
		<input type="hidden" name ="especialidade.pkEspecialidade" value="${especialidade.pkEspecialidade}" >
		<input type="text" name ="especialidade.descricao" value="${especialidade.descricao}" class="form-control" size="50" placeholder="especialidade">
		<input type="submit" id="enviar"  class="btn btn-warning" value="Gravar">
		<input type="reset" class="btn btn-warning" value="Limpar">&nbsp;&nbsp;&nbsp;
		<a href="<c:url value="/"/>">Voltar</a>
	</fieldset>	
	</form>
 </div>
 </div>
 </div>
 </div>
</body>
</html>