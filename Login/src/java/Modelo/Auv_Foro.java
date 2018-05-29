/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author ViniJ
 */
public class Auv_Foro {
    private int COD_FORO;
    private String COD_CURSO;
    private String TEMA;
    private String DESCRIPCION;
    private Date FECHA_INICIO;
    private Date FECHA_FIN;

    public int getCOD_FORO() {
        return COD_FORO;
    }

    public void setCOD_FORO(int COD_FORO) {
        this.COD_FORO = COD_FORO;
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

    public Date getFECHA_INICIO() {
        return FECHA_INICIO;
    }

    public void setFECHA_INICIO(Date FECHA_INICIO) {
        this.FECHA_INICIO = FECHA_INICIO;
    }

    public Date getFECHA_FIN() {
        return FECHA_FIN;
    }

    public void setFECHA_FIN(Date FECHA_FIN) {
        this.FECHA_FIN = FECHA_FIN;
    }
    
    public Auv_Foro(int COD_FORO, String COD_CURSO, String TEMA, String DESCRIPCION, Date FECHA_INICIO, Date FECHA_FIN) {
        this.COD_FORO = COD_FORO;
        this.COD_CURSO = COD_CURSO;
        this.TEMA = TEMA;
        this.DESCRIPCION = DESCRIPCION;
        this.FECHA_INICIO = FECHA_INICIO;
        this.FECHA_FIN = FECHA_FIN;
    }
    
    public Auv_Foro(){
        
    }
    
    
    
}


