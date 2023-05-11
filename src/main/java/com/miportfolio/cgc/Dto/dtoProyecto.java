package com.miportfolio.cgc.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String fechaP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String linkP;
    @NotBlank
    private String urlP;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String fechaP, String descripcionP, String linkP, String urlP) {
        this.nombreP = nombreP;
        this.fechaP = fechaP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
        this.urlP = urlP;
    }
    
    

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    
    
}
