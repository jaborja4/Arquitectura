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
public class Ntf_Notificacion {
     
    private String COD_NOTIFICACION;
    private String COD_EMISOR;
    private String COD_CURSO;   
    private String COD_PLANTILLA;
    private String COD_MEDIO;
    private String ESTADO;
    private String MENSAJE;
    private Date FECHA_ENTREGA;

    public String getCOD_NOTIFICACION() {
        return COD_NOTIFICACION;
    }

    public void setCOD_NOTIFICACION(String COD_NOTIFICACION) {
        this.COD_NOTIFICACION = COD_NOTIFICACION;
    }

    public String getCOD_EMISOR() {
        return COD_EMISOR;
    }

    public void setCOD_EMISOR(String COD_EMISOR) {
        this.COD_EMISOR = COD_EMISOR;
    }

    public String getCOD_CURSO() {
        return COD_CURSO;
    }

    public void setCOD_CURSO(String COD_CURSO) {
        this.COD_CURSO = COD_CURSO;
    }

    public String getCOD_PLANTILLA() {
        return COD_PLANTILLA;
    }

    public void setCOD_PLANTILLA(String COD_PLANTILLA) {
        this.COD_PLANTILLA = COD_PLANTILLA;
    }

    public String getCOD_MEDIO() {
        return COD_MEDIO;
    }

    public void setCOD_MEDIO(String COD_MEDIO) {
        this.COD_MEDIO = COD_MEDIO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getMENSAJE() {
        return MENSAJE;
    }

    public void setMENSAJE(String MENSAJE) {
        this.MENSAJE = MENSAJE;
    }

    public Date getFECHA_ENTREGA() {
        return FECHA_ENTREGA;
    }

    public void setFECHA_ENTREGA(Date FECHA_ENTREGA) {
        this.FECHA_ENTREGA = FECHA_ENTREGA;
    }

    
    
    
}
