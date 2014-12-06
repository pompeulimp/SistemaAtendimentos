<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<fieldset>
	<form id="pacienteCPF" action="<c:url value="/paciente/cpf"/>"
		method="post" class="navbar-form navbar-left" role="search">
		<label>Buscar Pacimente por CPF</label> <input
			type="text" name="cpf" value="${cpf}" id="cpf"
			placeholder="CPF Paciente" class="form-control" size="30"> <input
			type="submit" value="ok" class="btn">
			<div class="resultP"></div>
	</form>
	
	<script>
		$("#pacienteCPF").submit(
				function(event) {
					event.preventDefault();

					var $form = $(this), term = $form.find("input[name='cpf']")
							.val(), url = $form.attr("action");

					var posting = $.post(url, {
						cpf : term
					});
					
					posting.done(function(data) {
						$(".resultP").html(data);
					});
				});
	</script>


</fieldset>
