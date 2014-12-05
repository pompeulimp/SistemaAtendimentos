<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Formulário de Login</title>
	<c:import url="../include/javascripts.jsp"></c:import>
	<c:import url="../include/css.jsp"></c:import>	
    <style type="text/css">
           .bs-example{
                margin: 20px;
            }
    </style>
</head>
<body>
<div class="container" style="width:75%;">    
                <div id="divLogin" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                    <div class="panel panel-default" >
                        <div class="panel-heading">
                            <div class="panel-title">Login</div>
                            <div style="float:right; font-size: 80%; position: relative; top:-10px;"><a style="color: #3372f3;" href="#">Esqueceu sua senha?</a></div>
                        </div>     
                        <div style="padding-top:30px" class="panel-body" >
                            <div style="display:none" id="alertaLogin" class="alert alert-danger col-sm-12"></div>
                            <form id="frmLogin" class="form-horizontal" role="form" action="<c:url value='/login/autentica'/>" method="post">
                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input id="txtLogin" name="usuario.nomeUsuario" type="text" class="form-control" value="" placeholder="Login">                                        
                                </div>
                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input id="txtSenha" name="usuario.senha" type="password" class="form-control" placeholder="Senha">
                                </div>
                                <div class="input-group">
                                    <div class="checkbox">
                                        <label>
                                            <input id="chkLembrar" name="chkLembrar" type="checkbox" value="1"> Lembrar-me
                                        </label>
                                    </div>
                                </div>
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                        <input id="btnLogin" name="btnLogin" class="btn btn-info" type="submit" value="Login"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            Para criar uma conta
                                            <a href="#" onClick="$('#loginbox').hide();
                                                $('#signupbox').show()">
                                                clique aqui!
                                            </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     
                        </div>                     
                    </div>  
                </div>
                <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">Inscreva-se</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide();
                                $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form">

                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email" placeholder="Email Address">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="firstname" placeholder="First Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="lastname" placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="passwd" placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Invitation Code</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="icode" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> &nbsp Sign Up</button>
                                        <span style="margin-left:8px;">or</span>  
                                    </div>
                                </div>
                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
                                    </div>                                           
                                </div>
                            </form>
                        </div>
                    </div>
                </div> 
            </div>
	<c:if test="${not empty errors }">
		<div class="alert alert-danger">
			<c:forEach items="${errors }" var="erro">
				${erro.category } - ${erro.message }<br/>
			</c:forEach>
		</div>
	</c:if>
</body>
</html>