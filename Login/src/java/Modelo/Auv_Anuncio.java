/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Jose Achig
 */
public class Auv_Anuncio {
     
    private Integer COD_ANUNCIO;
    private String COD_CURSO;
    private String TEMA;   
    private String DESCRIPCION;
    private Date FECHA;
    
     public Auv_Anuncio() {
    }


    public Auv_Anuncio(Integer COD_ANUNCIO, String COD_CURSO, String TEMA, String DESCRIPCION, Date FECHA) {
        this.COD_ANUNCIO = COD_ANUNCIO;
        this.COD_CURSO = COD_CURSO;
        this.TEMA = TEMA;
        this.DESCRIPCION = DESCRIPCION;
        this.FECHA = FECHA;
    }

    
    
    public Integer getCOD_ANUNCIO() {
        return COD_ANUNCIO;
    }

    public void setCOD_ANUNCIO(Integer COD_ANUNCIO) {
        this.COD_ANUNCIO = COD_ANUNCIO;
    }

    public String getCOD_CURSO() {
        return COD_CURSO;
    }

    public void setCOD_CURSO(String COD_CURSO) {
        this.COD_CURSO = COD_CURSO;
    }

    public String getTEMA() {
        return TEMA;
    }

    public void setTEMA(String TEMA) {
        this.TEMA = TEMA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    
    
    
    
}
