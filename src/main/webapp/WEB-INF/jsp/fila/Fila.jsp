<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
 <body>
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Fila de atendimento
                </div>
                <div class="panel-body">
                    <div>
                        <table class="table table-hover">
                            <thead>
                            <td><strong>Ordem</strong></td>
                            <td><strong>Hor�rio</strong></td>
                            <td><strong>Nome do Paciente</strong></td>
                            <td><strong>Nome do M�dico<br>respons�vel pela consulta</strong></td>
                            <td><strong>Cancelar<br>consulta</strong></td>
                            </thead>
                            <!--Sql para buscar consultas na fila de antendimento no banco de dados-->
                            <tbody>
                                <tr>
                                    <td>1�</td>
                                    <td>15:30</td>
                                    <td>John Doe</td>
                                    <td>Dr. Jane Roe</td>
                                    <td>
                                        <button type="submit" id="icnCancelar" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i></button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div>
            
        </div>
    </body>
</html>