<%-- 
    Document   : criar
    Created on : May 9, 2017, 2:10:08 PM
    Author     : romulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Cliente</title>
    </head>
    <body>
        <h1>Atualizar Cliente</h1>
        <s:form action="AtualizarCliente" method="POST">
            <s:hidden name="id" value="%{cliente.getId()}"></s:hidden>
            <s:textfield name="nome" value="%{cliente.getNome()}" label="Nome"></s:textfield>
            <s:textfield name="email" value="%{cliente.getEmail()}" label="Email"></s:textfield>
            <s:submit value="Atualizar"></s:submit>
        </s:form>
        <a href="index.jsp">Voltar</a><br>
    </body>
</html>
