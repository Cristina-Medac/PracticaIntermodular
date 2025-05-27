package com.mycompany.practica_intermodular;

public class Pais {
    
    private String nombre;
    private int poblacion;
    private String idioma;
    private Curiosidad listaCuriosidades;
    private int idCont;

    public Pais(String nombre, int poblacion, String idioma, int idCont) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.idioma = idioma;
        this.idCont=idCont;
    }
    
    public Pais(String nombre, int poblacion, String idioma, int idCont, Curiosidad listaCuriosidades) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.idioma = idioma;
        this.idCont=idCont;
        this.listaCuriosidades = listaCuriosidades;
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public String getIdioma() {
        return idioma;
    }
    
    public int getIdCont() {
        return idCont;
    }

    public Curiosidad getListaCuriosidades() {
        return listaCuriosidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setListaCuriosidades(Curiosidad listaCuriosidades) {
        this.listaCuriosidades = listaCuriosidades;
    }

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", poblacion=" + poblacion + 
                ", idioma=" + idioma;
    }
    
    
    
}
