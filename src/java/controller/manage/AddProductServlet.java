/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manage;

import dal.ManageDAO;
import dal.SubCategoriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Products;
import model.SubCategories;

/**
 *
 * @author LAM
 */
public class AddProductServlet extends HttpServlet {

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
            out.println("<title>Servlet AddProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductServlet at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("listmanage");
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
        
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        String release_date_raw = request.getParameter("release_date");
        String decription = request.getParameter("description");
        String scid_raw = request.getParameter("scid");
        
        float price;
        int quantity, scid;
        Date release_date;
        
        try {
            price = Float.parseFloat(price_raw);
        } catch (NumberFormatException e) {
            price = 0;
        }
        
        try {
            quantity = Integer.parseInt(quantity_raw);
        } catch (NumberFormatException e) {
            quantity = 0;
        }
        
        try {
            scid = Integer.parseInt(scid_raw);
        } catch (NumberFormatException e) {
            scid = 0;
        }
        
        try {
            release_date = Date.valueOf(release_date_raw);
        } catch (NumberFormatException e) {
            release_date = (Date) new java.util.Date();
        }
        
        SubCategoriesDAO db = new SubCategoriesDAO();
        SubCategories subCat = new SubCategories(scid, db.getByID(scid).getScname(), db.getByID(scid).getCid());
        
        Products p = new Products(0, name, image, price, quantity, subCat, release_date, 0, decription, 0);
        ManageDAO mdb = new ManageDAO();
        mdb.addProduct(p);
        response.sendRedirect("listmanage");
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
