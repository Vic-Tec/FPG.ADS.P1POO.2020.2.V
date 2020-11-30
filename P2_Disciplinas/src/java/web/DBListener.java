/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;
import br.edu.fatecpg.poo.Disciplina;

/**
 * Web application lifecycle listener.
 *
 * @author Victor
 */
public class DBListener implements ServletContextListener {

    private static final String CLASS_NAME = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\victo\\Desktop\\disciplinas.db";

    public static String exceptionMessage = null;

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String etapa = "Inicialização...";
        Connection con = null;
        Statement stmt = null;
        try {
            etapa = "Registro da classe do driver...";
            Class.forName(CLASS_NAME);
            con = getConnection();
            etapa = "Preparação do statement...";
            stmt = con.createStatement();
            etapa = "Criação da tabela disciplinas...";
            stmt.execute(Disciplina.getCreateStatement());
            if (Disciplina.getList().isEmpty()){
                etapa = "Criar primeiros registros de disciplinas...";
                stmt.execute("INSERT INTO disciplinas VALUES('Banco de Dados', 'Conceitos de Base de Dados. Modelos conceituais de informações. Modelos de Dados: Relacional, Redes e Hierárquicos. Modelagem de dados - conceitual, lógica e física. Teoria relacional: dependências funcionais e multivaloradas, formas normais. Restrições de integridade e de segurança em Banco de Dados Relacional. Sistemas Gerenciadores de Banco de Dados – objetivo e funções. Linguagens de declaração e de manipulação de dados.', 4, 0.00)");
                stmt.execute("INSERT INTO disciplinas VALUES('Engenharia de Software III', 'Conceitos, evolução e importância de arquitetura de software. Padrões de Arquitetura. Padrões de Distribuição. Camadas no desenvolvimento de software. Tipos de Arquitetura de Software. Visões na arquitetura de software. Modelo de Análise e Projetos. Formas de representação. O processo de desenvolvimento. Mapeamento para implementação. Integração do sistema. Testes: planejamento e tipos. Manutenção. Documentação.', 4, 0.00)");
                stmt.execute("INSERT INTO disciplinas VALUES('Linguagem de Programação IV - Internet', 'Comandos de linguagens usadas na construção e estruturação de sites para a Web, com páginas dinâmi­cas e interativas. Definição de layouts e formatação em geral. Adição de algorítmos usando laços, matrizes, datas, funções e condições. Introdução a Orientação a Objetos utilizando objetos, métodos e propriedades. Integração com Banco de Dados. Exercícios práticos com projeto de criação de sites.', 4, 0.00)");
                stmt.execute("INSERT INTO disciplinas VALUES('Programação Orientada a Objetos', 'Conceitos e evolução da tecnologia de orientação a objetos. Limitações e diferenças entre o paradigma da programação estruturada em relação à orientação a objetos. Conceito de objeto, classe, métodos, atributos, herança, polimorfismo, agregação, associação, dependência, encapsulamento, mensagem e suas respectivas notações na linguagem padrão de representação da orientação a objetos. Implementação de algoritmos orientado a objetos utilizando linguagens de programação. Aplicação e uso das estruturas fundamentais da orientação a objetos.', 4, 0.00)");
                stmt.execute("INSERT INTO disciplinas VALUES('Sistemas Operacionais II', 'Apresentação de um sistema operacional específico utilizado em ambiente corporativo. Requisitos de hardware para instalação do sistema. Processo de instalação, personalização, operação, administração e segurança sobre o sistema operacional focado. Elaboração de projetos de seleção e implantação de um sistema operacional.', 4, 0.00)");
                stmt.execute("INSERT INTO disciplinas VALUES('Metodologia da Pesquisa Científica', 'O Papel da ciência e da tecnologia. Tipos de conhecimento. Método e técnica. O processo de leitura e de análise textual. Citações e bibliografias. Trabalhos acadêmicos: tipos, características e composição estrutural. O projeto de pesquisa experimental e não-experimental. Pesquisa qualitativa e quantitativa. Apresentação gráfica. Normas da ABNT.', 4, 0.00)");
            }
            etapa = "Desconexão do banco de dados...";
        } catch (Exception ex) {
            exceptionMessage = etapa + " : " + ex.getLocalizedMessage();
        } finally {
            try {
                stmt.close();
            } catch (Exception ex2) {     
            };
            try {
                con.close();
            } catch (Exception ex2){  
            };
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
