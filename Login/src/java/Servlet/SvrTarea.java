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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CORE I7
 */
public class SvrTarea extends HttpServlet {

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
            out.println("<title>Servlet SvrTarea</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvrTarea at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    
    private void CrearTarea(String cod_curso,String tema,String descripcion, Date fecha_inicio, Date fecha_fin){
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "INSERT INTO TAREA(COD_TAREA,COD_CURSO,TEMA,DESCRIPCION,FECHA_INICIO,FECHA_FIN) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, MaximoTarea()+1);
            ps.setString(2, cod_curso);
            ps.setString(3, tema);
            ps.setString(4, descripcion);
            ps.setDate(5, (java.sql.Date) fecha_inicio);
            ps.setDate(6, (java.sql.Date) fecha_fin);
            //ps.setString(2, cod_curso);
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SvrLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private int MaximoTarea(){
        int max=0;
        Connection con = new ConexionBD().Conexion();
        String sql= "SELECT MAX(COD_TAREA) AS MAXIMO FROM auv_tarea";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                max= rs.getInt("MAXIMO") ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SvrTarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
}
