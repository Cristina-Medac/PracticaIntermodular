package com.mycompany.practica_intermodular;

public class Continente {
    
    private String nombre;
    private double superficie;
    private String clima;
    private int numeroPaises;
    private Pais listaPaises;

    public Continente(String nombre, double superficie, String clima, int numeroPaises) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.clima = clima;
        this.numeroPaises = numeroPaises;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSuperficie() {
        return superficie;
    }

    public String getClima() {
        return clima;
    }

    public int getNumeroPaises() {
        return numeroPaises;
    }

    public Pais getListaPaises() {
        return listaPaises;
    }
    
    
    
}
