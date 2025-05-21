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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setNumeroPaises(int numeroPaises) {
        this.numeroPaises = numeroPaises;
    }

    public void setListaPaises(Pais listaPaises) {
        this.listaPaises = listaPaises;
    }

    @Override
    public String toString() {
        return "Continente{" + "nombre=" + nombre + ", superficie=" + superficie + 
                ", clima=" + clima + ", numeroPaises=" + numeroPaises + ", listaPaises=" + listaPaises + '}';
    }
    
    
    
}
