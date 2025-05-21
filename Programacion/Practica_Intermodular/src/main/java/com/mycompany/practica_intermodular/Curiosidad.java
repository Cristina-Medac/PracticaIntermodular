package com.mycompany.practica_intermodular;

public class Curiosidad {
    
    private String gastronomia;
    private String fiesta;
    private String historia;

    public Curiosidad(String gastronomia, String fiesta, String historia) {
        this.gastronomia = gastronomia;
        this.fiesta = fiesta;
        this.historia = historia;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public String getFiesta() {
        return fiesta;
    }

    public String getHistoria() {
        return historia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public void setFiesta(String fiesta) {
        this.fiesta = fiesta;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    @Override
    public String toString() {
        return "Curiosidad{" + "gastronomia=" + gastronomia + ", fiesta=" + fiesta + ", historia=" + historia + '}';
    }
    
    
    
}
