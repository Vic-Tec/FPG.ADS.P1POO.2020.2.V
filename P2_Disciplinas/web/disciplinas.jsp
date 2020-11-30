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
        <%
            ArrayList<Disciplina> disciplinasList = (ArrayList) application.getAttribute("disciplinasList");
            if (disciplinasList == null) {
                disciplinasList = Disciplina.getList();
                application.setAttribute("disciplinasList", disciplinasList);
            }
            String exceptionMessage = null;
            if (request.getParameter("def") != null) {
                try {
                    String nome = request.getParameter("nome");
                    long rowId = Long.parseLong(request.getParameter("rowId"));
                    double nota = Double.parseDouble(request.getParameter("nota"));
                    String ementa = request.getParameter("ementa");
                    int ciclo = Integer.parseInt(request.getParameter("ciclo"));
                    Disciplina.update(rowId, nome, ementa, ciclo, nota);
                    response.sendRedirect(request.getRequestURI());
                } catch (Exception ex) {
                    exceptionMessage = ex.getLocalizedMessage();
                }
            }
            if (request.getParameter("cancelar") != null) {
                response.sendRedirect(request.getRequestURI());
            }
            if (request.getParameter("acionarIns") != null) {
                try {
                    String nome = request.getParameter("nome");
                    long rowId = Long.parseLong(request.getParameter("rowId"));
                    double nota = Double.parseDouble(request.getParameter("nota"));
                    String ementa = request.getParameter("ementa");
                    int ciclo = Integer.parseInt(request.getParameter("ciclo"));
                    Disciplina.update(rowId, nome, ementa, ciclo, nota);
                    response.sendRedirect(request.getRequestURI());
                } catch (Exception ex) {
                    exceptionMessage = ex.getLocalizedMessage();
                }
            }
            if (request.getParameter("acionarDel") != null) {
                try {
                    long rowId = Long.parseLong(request.getParameter("rowId"));
                    Disciplina.delete(rowId);
                    response.sendRedirect(request.getRequestURI());
                } catch (Exception ex) {
                    exceptionMessage = ex.getLocalizedMessage();
                }
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/head-references.jspf"%>
        <title>Minhas Disciplinas</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Minhas Disciplinas</h1>
        <br>
        <table border="1">
            <tr>
                <th>índice</th>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Definição de Nota</th>
            </tr>
            <%for (int i = 0; i < disciplinasList.size(); i++) {%>
            <tr>
                <td><%=i + 1%></td>
                <%Disciplina d = disciplinasList.get(i);%>
                <td><%= d.getNome()%></td>
                <td><%= d.getEmenta()%></td>
                <td><%= d.getCiclo()%></td>
                <td><%= d.getNota()%></td>
                <td>
                    <form>
                        <input type="hidden" name="i" value="<%=i%>"/>
                        <input type="number" name="nota" min="0" max="10" step="0.01" style="width:50px"/>
                        <input type="submit" name="def" value="Definir"/>
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
