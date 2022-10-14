/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CartDAO;
import dal.LaptopDAO;
import dal.SubCategoriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.SubCategories;

/**
 *
 * @author LAM
 */
public class LaptopsServlet extends HttpServlet {

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
            out.println("<title>Servlet LaptopsServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LaptopsServlet at " + request.getContextPath() + "</h1>");
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
        //checkbox
        String[] id_raw = request.getParameterValues("id");
        String getID = "";
        int[] id = null;
        if (id_raw != null) {
            id = new int[id_raw.length];
            for (int i = 0; i < id.length; i++) {
                id[i] = Integer.parseInt(id_raw[i]);
                getID += "&id=" + id_raw[i];
            }
        }
        
        SubCategoriesDAO cdb = new SubCategoriesDAO();
        List<SubCategories> clist = cdb.getAll();
        
        boolean[] cid = new boolean[clist.size()];
        
        for (int i = 0; i < cid.length; i++) {
            if (ischeck(clist.get(i).getScid(), id))
                cid[i] = true;
            else
                cid[i] = false;
        }
        request.setAttribute("cats", clist);
        request.setAttribute("cid", cid);
        //checkbox
        
        //sort
        String sortby = request.getParameter("sortby");
        if (sortby == null || sortby.equals("")) sortby = "0";
        getID += "&sortby=" + sortby;
        //sort
        
        LaptopDAO db = new LaptopDAO();
        List<Products> list1 = db.checkLaptops(id, sortby);
        
        int page, numperpage = 12;
        int size = list1.size();
        
        int num = (size % 12 == 0 ? (size / 12) : ((size / 12)) + 1);
        
        String xpage = request.getParameter("page");
        
        if (xpage == null){
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);
        List<Products> list = db.getListByPage(list1, start, end);
        
        
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("data", list);
        request.setAttribute("getid", getID);
        request.setAttribute("checked", sortby);
        
        request.getRequestDispatcher("laptops.jsp").forward(request, response);
    }
    
    private boolean ischeck(int d, int[] id){
        if (id == null)
            return false;
        else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == d)
                    return true;
            }
            return false;
        }  
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
        
        response.sendRedirect("laptops");
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
