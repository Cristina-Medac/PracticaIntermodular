package com.mycompany.practica_intermodular;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseManager {
    
    private String url;
    private String user;
    private String password;
    private Connection conn = null;

    public DataBaseManager() throws SQLException{
        this.url = "jdbc:mysql://infocontinentes.czc28oot7odo.us-east-1.rds.amazonaws.com/ProyectoFinal";
        this.user = "admin";
        this.password = "Panosotros";
        
        this.conn = DriverManager.getConnection(url, user, password);
        
        }
    
    
    public void cerrarSesion() throws SQLException {
        
        this.conn.close();
        
        
    }
    
    public ArrayList<Continente> continentes()throws SQLException {
        
        ArrayList<Continente> listaContinentes = new ArrayList<>();
        String sql = "Select * from Continentes";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
                String nombre = rs.getString("nombre"); 
                String clima = rs.getString("clima");
                int superficie = rs.getInt("superficie");
                int n_paises = rs.getInt("num_paises");
                Continente c = new Continente(nombre, superficie, clima, n_paises);
                listaContinentes.add(c);
                }
        return listaContinentes;
        }
    
    public ArrayList<Pais> paises()throws SQLException {
        
        ArrayList<Curiosidad> listaCuriosidades = new ArrayList<>();
        ArrayList<Pais> listaPaises0 = new ArrayList<>();
        String sql = "Select * from Paises";
        String sql2 = "Select * from Curiosidades";
        PreparedStatement stmt = conn.prepareStatement(sql);
        PreparedStatement stmt2 = conn.prepareStatement(sql2);
        ResultSet rs2 = stmt2.executeQuery();
        while (rs2.next()) {
                String gastronomia = rs2.getString("gastronomia"); 
                String fiesta = rs2.getString("festividad");
                String peculiaridad = rs2.getString("peculiaridad");
                Curiosidad cu = new Curiosidad(gastronomia, fiesta, peculiaridad);
                listaCuriosidades.add(cu);
        }
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
                String nombre = rs.getString("nombre"); 
                int poblacion = rs.getInt("poblacion");
                String idioma_oficial = rs.getString("idioma_oficial");
                Pais p = new Pais(nombre, poblacion, idioma_oficial);
                listaPaises0.add(p);
                }
        ArrayList<Pais> listaPaises = new ArrayList<>();
        for (int i = 0; i < listaPaises0.size(); i++) {
            String nombre = listaPaises0.get(i).getNombre();
            int poblacion = listaPaises0.get(i).getPoblacion();
            String idioma_oficial = listaPaises0.get(i).getIdioma();
            Pais p = new Pais(nombre, poblacion, idioma_oficial, listaCuriosidades.get(i));
            listaPaises.add(p);
            
            
        }
        
        return listaPaises;
        }
}
    
    
    /*public ArrayList<Curiosidad> curiosidades()throws SQLException {
        
        ArrayList<Curiosidad> listaCuriosidades = new ArrayList<>();
        String sql = "Select * from Curiosidades";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
                String gastronomia = rs.getString("gastronomia"); 
                String fiesta = rs.getString("festividad");
                String peculiaridad = rs.getString("peculiaridad");
                Curiosidad cu = new Curiosidad(gastronomia, fiesta, peculiaridad);
                listaCuriosidades.add(cu);
                }
        return listaCuriosidades;
        }*/
     





