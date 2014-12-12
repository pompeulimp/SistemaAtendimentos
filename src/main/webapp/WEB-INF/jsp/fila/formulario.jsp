<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="../include/javascripts.jsp"></c:import>
<c:import url="../include/css.jsp"></c:import>
<title>Colocar Paciente na Fila</title>
</head>

<body>

	<c:import url="../include/menu.jsp"></c:import>
	<div class="container">
		<div class="row" id="main-content">
			<div class="well" align="center">
				<div class="span4" id="sidebar">
					<div>
						<c:import url="../fila/pacienteSearch.jsp"></c:import>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>