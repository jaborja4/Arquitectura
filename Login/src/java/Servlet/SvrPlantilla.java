package Servlet;

import Conexion.ConexionBD;
import Modelo.Auv_Entrega_Tarea;
import Modelo.Ntf_Plantilla;
import Modelo.Seg_Usuario;
import Threads.DesbloquearUsuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SvrPlantilla extends HttpServlet {

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
        Ntf_Plantilla plantilla = new Ntf_Plantilla();
        Auv_Entrega_Tarea resultado = new Auv_Entrega_Tarea();
        try {
            if (request.getParameter("cod_tarea") != null && request.getParameter("cod_alumno") != null && request.getParameter("cod_curso") != null) {
                Connection con = new ConexionBD().Conexion();
                String sql = "SELECT * FROM auv_entrega_tarea WHERE COD_TAREA=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, request.getParameter("cod_tarea"));
                ResultSet rs = ps.executeQuery();
                rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SvrPlantilla.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("Auv_Entrega_Tarea", resultado);
        request.getRequestDispatcher("plantilla.jsp").forward(request, response);

    }

    public List tareas(Connection conn, Integer crieterio)
            throws SQLException {
        List tareas_entrega = new LinkedList();
        String query = "SELECT COD_TAREA, COD_ALUMNO, COD_CURSO FROM auv_entrega_tarea WHERE COD_TAREA LIKE ?";
        try {
            // create the preparedstatement and add the criteria
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, crieterio);

            // process the results
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Auv_Entrega_Tarea tr = new Auv_Entrega_Tarea();
                tr.setARCHIVO(rs.getString("ARCHIVO"));
                tr.setCALIFICACION(rs.getFloat("CALIFICACION"));
                tr.setOBSERVACION(rs.getString("OBSERVACION"));
                tareas_entrega.add(tr);
            }
            rs.close();
            ps.close();
        } catch (SQLException se) {
            // log exception;
            throw se;
        }
        return tareas_entrega;
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
