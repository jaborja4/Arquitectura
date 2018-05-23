/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexion.ConexionBD;
import Modelo.Seg_Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ajborjal
 */
public class SvrLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Seg_Usuario resultado= new Seg_Usuario();
        resultado.setEstadoLogin(false);
        resultado.setMensajeLogin("Error desconocido");
        try {
            if (request.getParameter("cod_usuario") != null && request.getParameter("clave") != null) {
                Connection con = new ConexionBD().Conexion();
                String sql = "SELECT * FROM seg_usuario WHERE COD_USUARIO=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, request.getParameter("cod_usuario"));
                ResultSet rs = ps.executeQuery();
                rs.next();
                if ("ACT".equals(rs.getString("estado"))) {
                    ActualizarAcceso(request.getParameter("cod_usuario"));
                    if (rs.getString("clave").equals(request.getParameter("clave"))) {
                        resultado.setEstadoLogin(true);
                        InsertarAcceso(rs.getString("COD_PERFIL"), "USRCLV", request.getParameter("cod_usuario"), request.getRemoteAddr(), "CORRECTO");
                        resultado.setMensajeLogin("Correcto");
                    } else {
                        IntentoErroneo(request.getParameter("cod_usuario"), rs.getInt("intentos_erroneos"));
                        resultado.setEstadoLogin(false);
                        resultado.setMensajeLogin("Usuario o Clave Incorrecta");
                    }
                } else {
                    resultado.setEstadoLogin(false);
                    resultado.setMensajeLogin("Usuario Bloqueado");
                }
                ps.close();
            con.close();
            }else{
                resultado.setEstadoLogin(false);
                resultado.setMensajeLogin("Los campos usuario y clave son obligatorios");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("Seg_Usuario", resultado);
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
    
    private void IntentoErroneo(String cod_usuario, Integer intentos_actuales){
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "UPDATE seg_usuario SET intentos_erroneos=?, estado=? WHERE cod_usuario=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, intentos_actuales+1);
            if(intentos_actuales>=2)
                ps.setString(2, "BLO");
            else
                ps.setString(2, "ACT");
            ps.setString(3, cod_usuario);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ActualizarAcceso(String cod_usuario){
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "UPDATE seg_usuario SET fecha_ultimo_acceso=? WHERE cod_usuario=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ps.setString(2, cod_usuario);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void InsertarAcceso(String cod_perfil, String tipo_acceso, String cod_usuario, String ip, String resultado){
        String funcionalidad="";
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "SELECT * FROM seg_perfil_funcionalidad WHERE COD_PERFIL=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cod_perfil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funcionalidad += rs.getString("SEC_FUNCIONALIDAD") + "|";
            }
            String sql2 = "INSERT INTO seg_registro_acceso VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, 0);
            ps2.setString(2, tipo_acceso);
            ps2.setString(3, cod_usuario);
            ps2.setString(4, ip);
            ps2.setString(5, funcionalidad);
            ps2.setString(6, resultado);
            ps2.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            ps2.execute();
            ps2.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
