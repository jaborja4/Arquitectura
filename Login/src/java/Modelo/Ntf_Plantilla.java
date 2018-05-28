package Modelo;

import java.util.Date;

public class Ntf_Plantilla{

    private String COD_PLANTILLA;
    private String NOMBRE;
    private String ESTADO;
    private String MENSAJE;
    private String TIPO;

    public Ntf_Plantilla() {
    }

    public Ntf_Plantilla(String COD_PLANTILLA, String NOMBRE, String ESTADO, String MENSAJE, String TIPO) {
        this.COD_PLANTILLA = COD_PLANTILLA;
        this.NOMBRE = NOMBRE;
        this.ESTADO = ESTADO;
        this.MENSAJE = MENSAJE;
        this.TIPO = TIPO;
    }
    
    /**
     * @return the COD_PLANTILLA
     */
    public String getCOD_PLANTILLA() {
        return COD_PLANTILLA;
    }

    /**
     * @param COD_PLANTILLA the COD_PLANTILLA to set
     */
    public void setCOD_PLANTILLA(String COD_PLANTILLA) {
        this.COD_PLANTILLA = COD_PLANTILLA;
    }

    /**
     * @return the NOMBRE
     */
    public String getNOMBRE() {
        return NOMBRE;
    }

    /**
     * @param NOMBRE the NOMBRE to set
     */
    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    /**
     * @return the ESTADO
     */
    public String getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    /**
     * @return the MENSAJE
     */
    public String getMENSAJE() {
        return MENSAJE;
    }

    /**
     * @param MENSAJE the MENSAJE to set
     */
    public void setMENSAJE(String MENSAJE) {
        this.MENSAJE = MENSAJE;
    }

    /**
     * @return the TIPO
     */
    public String getTIPO() {
        return TIPO;
    }

    /**
     * @param TIPO the TIPO to set
     */
    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

}
