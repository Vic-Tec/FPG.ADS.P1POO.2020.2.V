/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fatecpg.poo;

import java.util.ArrayList;
import java.sql.*;
import web.DBListener;

/**
 *
 * @author Victor
 */
public class Disciplina {

    private long rowId;
    private String nome;
    private String ementa;
    private int ciclo;
    private double nota;

    public Disciplina(long rowId, String nome, String ementa, int ciclo, double nota) {
        this.rowId = rowId;
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
    }

    public static ArrayList<Disciplina> getList() throws Exception {
        ArrayList<Disciplina> list = new ArrayList();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
            con = DBListener.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT rowId, * FROM disciplinas");
            while(rs.next()){
                list.add(new Disciplina(
                rs.getLong("rowId"),
                rs.getString("nome"),
                rs.getString("ementa"),
                rs.getInt("ciclo"),
                rs.getDouble("nota")
                ));
            }
        } catch (Exception ex) {
            methodException = ex;
        } finally {
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        return list;
    }
    
    public static void insert (String nome, String ementa, int ciclo, double nota) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
            con = DBListener.getConnection();
            stmt = con.prepareStatement("INSERT INTO disciplinas VALUES (?,?,?,?");
            stmt.setString(1,nome);
            stmt.setString(2,ementa);
            stmt.setInt(3,ciclo);
            stmt.setDouble(4,nota);
            stmt.execute();
        } catch (Exception ex) {
            methodException = ex;
        } finally {
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        if (methodException != null) throw methodException;
    }
    
    public static void update (long rowId, String nome, String ementa, int ciclo, double nota) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
            con = DBListener.getConnection();
            stmt = con.prepareStatement("UPDATE INTO disciplinas SET nome=?, ementa=?, ciclo=?, nota=? WHERE rowId=?");
            stmt.setString(1,nome);
            stmt.setString(2,ementa);
            stmt.setInt(3,ciclo);
            stmt.setDouble(4,nota);
            stmt.setLong(5,rowId);
            stmt.execute();
        } catch (Exception ex) {
            methodException = ex;
        } finally {
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        if (methodException != null) throw methodException;
    }
    
    public static void delete (long rowId) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
            con = DBListener.getConnection();
            stmt = con.prepareStatement("DELETE FROM disciplinas WHERE rowId=?");
            stmt.setLong(1,rowId);
            stmt.execute();
        } catch (Exception ex) {
            methodException = ex;
        } finally {
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        if (methodException != null) throw methodException;
    }

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplinas("
                + "nome VARCHAR(50) UNIQUE NOT NULL,"
                + "ementa VARCHAR(500) NOT NULL,"
                + "ciclo NUMBER(2) NOT NULL,"
                + "nota NUMBER(4) NOT NULL"
                + ")";
    }
}
