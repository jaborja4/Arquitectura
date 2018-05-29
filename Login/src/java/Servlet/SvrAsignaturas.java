/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexion.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Auv_Asignatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CORE I7
 */
public class SvrAsignaturas extends HttpServlet {

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
            ArrayList<Auv_Asignatura> lista_asignaturas= new ArrayList<Auv_Asignatura>();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            
            out.println("<head>");
            out.println("<title>Servlet SvrAsignaturas</title>");            
            out.println("<link rel='shortcut icon' type='image/x-icon' href='images/favicon.ico' />");
            out.println("</head>");
            lista_asignaturas=CargarAsignatura("001");
            
            out.println("<body>");
            out.println("<h1>Servlet SvrAsignaturas at " + request.getContextPath() + "</h1>");
            out.println("<h1>"+lista_asignaturas.get(0).getCOD_ASIGNATURA()+"</h1>");
            out.println("</body>");
            out.println("</html>");
            
          
            request.setAttribute("Asignaturas", lista_asignaturas);
            request.getRequestDispatcher("Seleccionar_Curso_Docente.jsp").forward(request, response);
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
    
    
    private ArrayList<Auv_Asignatura> CargarAsignatura(String cod_docente){
        ArrayList<Auv_Asignatura> lista_asignaturas= new ArrayList<Auv_Asignatura>();    
        try {
            Connection con = new ConexionBD().Conexion();
            String sql = "SELECT A.COD_ASIGNATURA,A.DESCRIPCION FROM auv_curso C,auv_asignatura A "+
                    "WHERE A.COD_ASIGNATURA=C.COD_ASIGNATURA AND COD_DOCENTE='?'";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            
            ps.setString(1, cod_docente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("A.COD_ASIGNATURA")+"\n");
                Auv_Asignatura asi=new Auv_Asignatura();
                asi.setCOD_ASIGNATURA(rs.getString("A.COD_ASIGNATURA"));
                asi.setDESCRIPCION(rs.getString("A.DESCRIPCION"));
                lista_asignaturas.add(asi);
            }
        }
            catch (SQLException ex) {
            Logger.getLogger(SvrAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_asignaturas;
    }
}
