/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author ajborjal
 */
public class Seg_Usuario {
    private String COD_USUARIO;
    private String COD_PERFIL;
    private String CORREO_ELECTRONICO;   
    private String NOMBRE;
    private String CLAVE;
    private String ESTADO;
    private Date FECHA_CREACION;
    private Integer INTENTOS_ERRONEOS;
    private Date FECHA_ULTIMO_ACCESO;
    private boolean estadoLogin;
    private String mensajeLogin;

    public boolean isEstadoLogin() {
        return estadoLogin;
    }

    public void setEstadoLogin(boolean estadoLogin) {
        this.estadoLogin = estadoLogin;
    }

    public String getMensajeLogin() {
        return mensajeLogin;
    }

    public void setMensajeLogin(String mensajeLogin) {
        this.mensajeLogin = mensajeLogin;
    }

    public String getCOD_USUARIO() {
        return COD_USUARIO;
    }

    public void setCOD_USUARIO(String COD_USUARIO) {
        this.COD_USUARIO = COD_USUARIO;
    }

    public String getCOD_PERFIL() {
        return COD_PERFIL;
    }

    public void setCOD_PERFIL(String COD_PERFIL) {
        this.COD_PERFIL = COD_PERFIL;
    }

    public String getCORREO_ELECTRONICO() {
        return CORREO_ELECTRONICO;
    }

    public void setCORREO_ELECTRONICO(String CORREO_ELECTRONICO) {
        this.CORREO_ELECTRONICO = CORREO_ELECTRONICO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public Date getFECHA_CREACION() {
        return FECHA_CREACION;
    }

    public void setFECHA_CREACION(Date FECHA_CREACION) {
        this.FECHA_CREACION = FECHA_CREACION;
    }

    public Integer getINTENTOS_ERRONEOS() {
        return INTENTOS_ERRONEOS;
    }

    public void setINTENTOS_ERRONEOS(Integer INTENTOS_ERRONEOS) {
        this.INTENTOS_ERRONEOS = INTENTOS_ERRONEOS;
    }

    public Date getFECHA_ULTIMO_ACCESO() {
        return FECHA_ULTIMO_ACCESO;
    }

    public void setFECHA_ULTIMO_ACCESO(Date FECHA_ULTIMO_ACCESO) {
        this.FECHA_ULTIMO_ACCESO = FECHA_ULTIMO_ACCESO;
    }
    
    
}
