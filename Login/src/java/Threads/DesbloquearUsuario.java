/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Conexion.ConexionBD;
import Servlet.SvrLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joeli
 */
public class DesbloquearUsuario implements Runnable{

    @Override
    public void run() {
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "SELECT * FROM seg_usuario WHERE ESTADO=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "BLO");
            ResultSet rs = ps.executeQuery();
            Date fecha;
            Date fechaActual = new Date();
            while (rs.next()) {
                fecha = rs.getDate("FECHA_ULTIMO_ACCESO");
                if (fecha.getMinutes() >= 5 && fecha.getMinutes() <= 60) {
                    if (fechaActual.getMinutes() - fecha.getMinutes() == 5) {
                        String sql2 = "UPDATE seg_usuario SET estado=? WHERE cod_usuario=?";
                        PreparedStatement ps2 = con.prepareStatement(sql2);
                        ps2.setString(1, "ACT");
                        ps2.setString(2, rs.getString("cod_usuario"));
                        ps2.executeUpdate();
                        ps2.close();
                    }
                }else{
                    if(fechaActual.getHours()-fecha.getHours()>=1){
                        String sql2 = "UPDATE seg_usuario SET estado=? WHERE cod_usuario=?";
                        PreparedStatement ps2 = con.prepareStatement(sql2);
                        ps2.setString(1, "ACT");
                        ps2.setString(2, rs.getString("cod_usuario"));
                        ps2.executeUpdate();
                        ps2.close();
                    }
                }
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
