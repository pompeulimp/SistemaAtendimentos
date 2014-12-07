<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fieldset>
	<form id="medicocrm" action="<c:url value="/medico/crm"/>"
		method="post" class="navbar-form navbar-left" role="search">
		<label>Buscar Medico por CRM</label> <input type="text" name="crm"
			value="${crm}" id="busca" placeholder="CRM Medico"
			class="form-control" size="30"> <input type="submit"
			value="ok" class="btn btn-primary">
	</form>

	<div class="resultM"></div>

	<script>
		$("#medicocrm").submit(
				function(event) {
					event.preventDefault();
					var $form = $(this), term = $form.find("input[name='crm']")
							.val(), url = $form.attr("action");

					var posting = $.post(url, {
						crm : term
					});

					posting.done(function(data) {
						$(".resultM").html(data);

					});
				});
	</script>
</fieldset>
