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
                disciplinasList = new ArrayList<>();
                disciplinasList.add(new Disciplina("Banco de Dados", "Conceitos de Base de Dados. Modelos conceituais de informações. Modelos de Dados: Relacional, Redes e Hierárquicos. Modelagem de dados - conceitual, lógica e física. Teoria relacional: dependências funcionais e multivaloradas, formas normais. Restrições de integridade e de segurança em Banco de Dados Relacional. Sistemas Gerenciadores de Banco de Dados – objetivo e funções. Linguagens de declaração e de manipulação de dados.", 4, 0.0));
                disciplinasList.add(new Disciplina("Engenharia de Software III", "Conceitos, evolução e importância de arquitetura de software. Padrões de Arquitetura. Padrões de Distribuição. Camadas no desenvolvimento de software. Tipos de Arquitetura de Software. Visões na arquitetura de software. Modelo de Análise e Projetos. Formas de representação. O processo de desenvolvimento. Mapeamento para implementação. Integração do sistema. Testes: planejamento e tipos. Manutenção. Documentação.", 4, 0.0));
                disciplinasList.add(new Disciplina("Programação Orientada a Objeto", "Conceitos e evolução da tecnologia de orientação a objetos. Limitações e diferenças entre o paradigma da programação estruturada em relação à orientação a objetos. Conceito de objeto, classe, métodos, atributos, herança, polimorfismo, agregação, associação, dependência, encapsulamento, mensagem e suas respectivas notações na linguagem padrão de representação da orientação a objetos. Implementação de algoritmos orientado a objetos utilizando linguagens de programação. Aplicação e uso das estruturas fundamentais da orientação a objetos.", 4, 0.0));
                disciplinasList.add(new Disciplina("Linguagem de Programação IV - Internet", "Comandos de linguagens usadas na construção e estruturação de sites para a Web, com páginas dinâmi­cas e interativas. Definição de layouts e formatação em geral. Adição de algorítmos usando laços, matrizes, datas, funções e condições. Introdução a Orientação a Objetos utilizando objetos, métodos e propriedades. Integração com Banco de Dados. Exercícios práticos com projeto de criação de sites.", 4, 0.0));
                disciplinasList.add(new Disciplina("Sistemas Operacionais II", "Apresentação de um sistema operacional específico utilizado em ambiente corporativo. Requisitos de hardware para instalação do sistema. Processo de instalação, personalização, operação, administração e segurança sobre o sistema operacional focado. Elaboração de projetos de seleção e implantação de um sistema operacional.", 4, 0.0));
                disciplinasList.add(new Disciplina("Metodologia da Pesquisa Científica", "O Papel da ciência e da tecnologia. Tipos de conhecimento. Método e técnica. O processo de leitura e de análise textual. Citações e bibliografias. Trabalhos acadêmicos: tipos, características e composição estrutural. O projeto de pesquisa experimental e não-experimental. Pesquisa qualitativa e quantitativa. Apresentação gráfica. Normas da ABNT.", 4, 0.0));
                application.setAttribute("disciplinasList", disciplinasList);
            }
            if(request.getParameter("def")!=null){
                int i = Integer.parseInt(request.getParameter("i"));
                Disciplina alt = disciplinasList.get(i);
                try{
                    alt.setNota(Double.parseDouble(request.getParameter("nota")));
                } catch(Exception ex){
                    alt.setNota(0.0);
                }
                response.sendRedirect(request.getRequestURI());
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
            <%for(int i=0;i<disciplinasList.size();i++){%>
            <tr>
                <td><%=i%></td>
                <%Disciplina d = disciplinasList.get(i);%>
                <td><%= d.getNome()%></td>
                <td><%= d.getEmenta()%></td>
                <td><%= d.getCiclo()%></td>
                <td><%= d.getNota()%></td>
                <td>
                    <form>
                        <input type="hidden" name="i" value="<%=i%>"/>
                        <input type="number" name="nota" min="0" max="10" step="0.01" styl="width:50px"/>
                        <input type="submit" name="def" value="Definir"/>
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
