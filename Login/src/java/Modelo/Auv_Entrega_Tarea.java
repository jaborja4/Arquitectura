package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Auv_Entrega_Tarea{

    private Integer COD_TAREA;
    private String COD_ALUMNO;
    private String COD_CURSO;
    private String TEXTO;
    private Date FECHA_ENVIO;
    private String ARCHIVO;
    private Float CALIFICACION;
    private String OBSERVACION;

    public Auv_Entrega_Tarea() {
    }

    public Auv_Entrega_Tarea(Integer COD_TAREA, String COD_ALUMNO, String COD_CURSO, String TEXTO, Date FECHA_ENVIO, String ARCHIVO, Float CALIFICACION, String OBSERVACION) {
        this.COD_TAREA = COD_TAREA;
        this.COD_ALUMNO = COD_ALUMNO;
        this.COD_CURSO = COD_CURSO;
        this.TEXTO = TEXTO;
        this.FECHA_ENVIO = FECHA_ENVIO;
        this.ARCHIVO = ARCHIVO;
        this.CALIFICACION = CALIFICACION;
        this.OBSERVACION = OBSERVACION;
    }

    /**
     * @return the COD_TAREA
     */
    public Integer getCOD_TAREA() {
        return COD_TAREA;
    }

    /**
     * @param COD_TAREA the COD_TAREA to set
     */
    public void setCOD_TAREA(Integer COD_TAREA) {
        this.COD_TAREA = COD_TAREA;
    }

    /**
     * @return the COD_ALUMNO
     */
    public String getCOD_ALUMNO() {
        return COD_ALUMNO;
    }

    /**
     * @param COD_ALUMNO the COD_ALUMNO to set
     */
    public void setCOD_ALUMNO(String COD_ALUMNO) {
        this.COD_ALUMNO = COD_ALUMNO;
    }

    /**
     * @return the COD_CURSO
     */
    public String getCOD_CURSO() {
        return COD_CURSO;
    }

    /**
     * @param COD_CURSO the COD_CURSO to set
     */
    public void setCOD_CURSO(String COD_CURSO) {
        this.COD_CURSO = COD_CURSO;
    }

    /**
     * @return the TEXTO
     */
    public String getTEXTO() {
        return TEXTO;
    }

    /**
     * @param TEXTO the TEXTO to set
     */
    public void setTEXTO(String TEXTO) {
        this.TEXTO = TEXTO;
    }

    /**
     * @return the FECHA_ENVIO
     */
    public Date getFECHA_ENVIO() {
        return FECHA_ENVIO;
    }

    /**
     * @param FECHA_ENVIO the FECHA_ENVIO to set
     */
    public void setFECHA_ENVIO(Date FECHA_ENVIO) {
        this.FECHA_ENVIO = FECHA_ENVIO;
    }

    /**
     * @return the ARCHIVO
     */
    public String getARCHIVO() {
        return ARCHIVO;
    }

    /**
     * @param ARCHIVO the ARCHIVO to set
     */
    public void setARCHIVO(String ARCHIVO) {
        this.ARCHIVO = ARCHIVO;
    }

    /**
     * @return the CALIFICACION
     */
    public Float getCALIFICACION() {
        return CALIFICACION;
    }

    /**
     * @param CALIFICACION the CALIFICACION to set
     */
    public void setCALIFICACION(Float CALIFICACION) {
        this.CALIFICACION = CALIFICACION;
    }

    /**
     * @return the OBSERVACION
     */
    public String getOBSERVACION() {
        return OBSERVACION;
    }

    /**
     * @param OBSERVACION the OBSERVACION to set
     */
    public void setOBSERVACION(String OBSERVACION) {
        this.OBSERVACION = OBSERVACION;
    }
    
}
