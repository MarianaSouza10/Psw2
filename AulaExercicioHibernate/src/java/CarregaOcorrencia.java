/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author RA21504533
 */
public class CarregaOcorrencia extends HttpServlet {

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
            out.println("<title>Servlet CarregaOcorrencia1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarregaOcorrencia1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            int idOcorrencia = 5;

            Ocorrencia ocorrencia0;
            // Buscar do Banco ...
            Session sessao = HibernateUtil.getSessionFactory().openSession();

            ocorrencia0 = (Ocorrencia) sessao.get(Ocorrencia.class, idOcorrencia);

            out.println("Dados da Ocorrencia:" + idOcorrencia + " ");

            if (ocorrencia0 == null) {

                out.println("Não encontrei a ocorrencia de id: " + idOcorrencia);
            }
            else {
                out.println("nome:" + ocorrencia0.getNome());
                out.println("endereco:" + ocorrencia0.getEndereco());
                out.println("tipo_ocorrencia:" + ocorrencia0.getTipo_ocorrencia());
            }

        
            
            
            
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
