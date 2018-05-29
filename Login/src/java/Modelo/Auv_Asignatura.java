/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author CORE I7
 */
public class Auv_Asignatura {
    public String COD_ASIGNATURA;
    public String DESCRIPCION;

    public Auv_Asignatura(String COD_ASIGNATURA, String DESCRIPCION) {
        this.COD_ASIGNATURA = COD_ASIGNATURA;
        this.DESCRIPCION = DESCRIPCION;
    }

    public Auv_Asignatura() {
    }

    public String getCOD_ASIGNATURA() {
        return COD_ASIGNATURA;
    }

    public void setCOD_ASIGNATURA(String COD_ASIGNATURA) {
        this.COD_ASIGNATURA = COD_ASIGNATURA;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }
    
}
