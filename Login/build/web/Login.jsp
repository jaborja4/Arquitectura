<%-- 
    Document   : Login
    Created on : 21/05/2018, 15:59:07
    Author     : ajborjal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acceso al Sistema</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="src/bootstrap.min.css">
        <link rel="stylesheet" href="src/metisMenu.min.css" >
        <link rel="stylesheet" href="src/sb-admin-2.css" >
        <script src="src/jquery.min.js"></script>
        <script src="src/md5.js"></script>
    </head>
    <body>
        <jsp:useBean id="Seg_Usuario" scope="request" class="Modelo.Seg_Usuario"/>
        <div class="container">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Inicio de Sesión</h3>
                    </div>
                    <div class="panel-body">
                        <form action="SvrLogin" role="form" method="POST">
                            <div class="form-group">
                                <input class="form-control" placeholder="Usuario" name="cod_usuario" type="text" >
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Contraseña" name="clave" type="password" onkeyup="this.form.hash.value = MD5(this.form.pass.value)">
                            </div>
                            <button type="submit" class="btn btn-lg btn-danger btn-block">Entrar</button>
                        </form>
                    </div>
                </div>       
                <%
                    if (Seg_Usuario.isEstadoLogin()) {
                %>
                <div class="alert alert-success">
                    <strong> 
                        <jsp:getProperty name="Seg_Usuario" property="mensajeLogin"/>
                    </strong>
                </div>
                <%
                } else {
                %>
                <div class="alert alert-danger">
                    <strong> 
                        <jsp:getProperty name="Seg_Usuario" property="mensajeLogin"/>
                    </strong>
                </div>
                <%
                    }
                %>    
            </div>
        </div>
    </body>
</html>
