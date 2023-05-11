package com.miportfolio.cgc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String urlEx;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String urlEx) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlEx = urlEx;
    }
    
    //Getter y Setter

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
