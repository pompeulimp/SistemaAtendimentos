<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Paciente</title>
</head>
<body>
	<form action="create">
		<input type="hidden" name="paciente.pk_paciente" value="${paciente.pk_paciente}">
		<input type="text" name="paciente.nomePaciente" value="${paciente.nomePaciente}" placeholder="nome">
		<input type="text" name="paciente.cpfPaciente"  value="${paciente.cpfPaciente}" placeholder="cpf">
		<input type="text" name="paciente.enderecoPaciente" value="${paciente.enderecoPaciente}" placeholder="endereço">
		<input type="text" name="paciente.telefonePaciente" value="${paciente.telefonePaciente}" placeholder="telefone">
		<input type="submit" name="gravar" />
	</form>
</body>
</html>