/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author LAM
 */
public class ProfileServlet extends HttpServlet {

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
            out.println("<title>Servlet ProfileServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        AccountDAO db = new AccountDAO();
        
        Account a = (Account)session.getAttribute("account");
        Account account = db.getById(a.getUid());   
        
        request.setAttribute("account", account);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        AccountDAO db = new AccountDAO();
        
        Account a = (Account)session.getAttribute("account"); 
        
        String add = request.getParameter("addmoney");
        String pass = request.getParameter("pass");
        float addmoney;
        
        if (pass == null || pass.equals("")) pass = a.getPass();
        
        try {
            addmoney = Float.parseFloat(add);
        } catch (NumberFormatException e) {
            addmoney = -1;
        }
        
        if (addmoney < 0) {
            request.setAttribute("error", "Money must be positive integer!...");
            request.setAttribute("account", a);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            addmoney += a.getMoney();
            
            db.changeMoney(addmoney, a.getUid());
            
            if (pass != a.getPass()) {
                db.changePass(pass, a.getUid());
                session.removeAttribute("account");
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("success", "Save success!...");
                request.setAttribute("account", new Account(a.getUid(), a.getUser(), pass, addmoney, a.getRole()));
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }
        }
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
