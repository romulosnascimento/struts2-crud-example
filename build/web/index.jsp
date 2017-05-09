<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD de Clientes</title>
    </head>
    <body>
        <h1>CRUD de Clientes</h1>
        <a href="criar.jsp">Criar</a><br>
        <s:url action="ListarClientes" var="linkListar">
        </s:url>
        <s:a href="%{linkListar}">Listar</s:a><br>
    </body>
</html>
