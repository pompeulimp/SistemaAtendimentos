<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty errors }">
	<div class="alert alert-danger">
		<c:forEach items="${errors }" var="erro">
				${erro.category } - ${erro.message }<br />
		</c:forEach>
	</div>
</c:if>
