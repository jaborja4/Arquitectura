/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexion.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ViniJ
 */
@WebServlet(name = "SvrCrudUsuario", urlPatterns = {"/SvrCrudUsuario"})
public class SvrCrudUsuario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvrCrudUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvrCrudUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    private void InsertarUsuario(String cod_usuario, String cod_perfil, String correo_electronico, String nombre, String clave, String estado, Timestamp fecha_creacion, float intentos_erroneos, Timestamp fecha_ultimo_acceso){
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "INSERT INTO seg_usuario VALUES ?,?,?,?,?,?,?,?,?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cod_usuario);
            ps.setString(2, cod_perfil);
            ps.setString(3, correo_electronico);
            ps.setString(4, nombre);
            ps.setString(5, clave);
            ps.setString(6, estado);
            ps.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            ps.setFloat(6, intentos_erroneos);
            ps.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void EliminarUsuario(String cod_usuario){
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "DELETE FROM seg_usuario WHERE cod_usuario=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cod_usuario);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ActualizarUsuario(String cod_usuario, String correo_electronico, String nombre, String clave){
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "UPDATE seg_usuario SET correo_electronico=?,nombre=?,clave=? WHERE cod_usuario=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo_electronico);
            ps.setString(2, nombre);
            ps.setString(3, clave);
            ps.setString(4, cod_usuario);
            ps.executeUpdate();
            ps.close();
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
