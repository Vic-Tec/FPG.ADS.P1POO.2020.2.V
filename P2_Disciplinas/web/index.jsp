<%-- 
    Document   : sobre
    Created on : 1 de out de 2020, 23:31:08
    Author     : Victor
--%>
<%@page import="br.edu.fatecpg.poo.Disciplina" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/head-references.jspf"%>
        <title>Index</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Index</h1>
        <p>Nome: Victor Gabriel Leme da Silva</p>
        <p>RA: 1290481912034</p>
        <p>Quantidade de disciplinas matriculadas esse semestre: <%= Disciplina.getList().size() %></p>
    </body>
</html>
