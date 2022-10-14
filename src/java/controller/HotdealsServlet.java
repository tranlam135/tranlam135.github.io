/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.LaptopDAO;
import dal.SubCategoriesDAO;
import dal.TypeProductsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.Item;
import model.Products;

/**
 *
 * @author LAM
 */
public class HotdealsServlet extends HttpServlet {

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
            out.println("<title>Servlet HotdealsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HotdealsServlet at " + request.getContextPath() + "</h1>");
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
        
        SubCategoriesDAO sdb = new SubCategoriesDAO();
        int size = sdb.getAll().size();
        
        int lsize[] = new int[size];
        
        TypeProductsDAO db = new TypeProductsDAO();
        ArrayList<List<Products>> list = new ArrayList<List<Products>>();
        
        for (int i = 0; i < size; i++) {
            List<Products> singleList = db.getDeal(i);
            list.add(singleList);
            lsize[i] = singleList.size();
        }
        
        request.setAttribute("data", list);
        request.setAttribute("size", size);
        request.setAttribute("si", lsize);
        request.getRequestDispatcher("hotdeals.jsp").forward(request, response);
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
        HttpSession session =request.getSession();
        Account a = (Account) session.getAttribute("account");
        Cart cart = (Cart) session.getAttribute("cart");
        
        String id_raw = request.getParameter("id");
        int id;
        try {
           id = Integer.parseInt(id_raw);
           
           LaptopDAO pdb = new LaptopDAO();
           Products p = pdb.getById(id);
           float price = p.getPrice();
           Item t = new Item(p, 1, price);
           
           CartDAO cdb = new CartDAO();
           cart = cdb.addToCart(a, t, cart);
           
        }catch(NumberFormatException e){
        }        
        
        List<Item> list=cart.getItems();
        session.setAttribute("cart", cart);
        session.setAttribute("size", list.size());
        
        response.sendRedirect("hotdeals");
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
