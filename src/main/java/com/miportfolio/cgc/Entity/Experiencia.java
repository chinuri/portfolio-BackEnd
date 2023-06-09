package com.miportfolio.cgc.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String urlEx;

    //Constructores
    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String urlEx) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlEx = urlEx;
    }
    
    
    //Getter y Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getUrlEx() {
        return urlEx;
    }

    public void setUrlEx(String urlEx) {
        this.urlEx = urlEx;
    }
        
    
    
}
