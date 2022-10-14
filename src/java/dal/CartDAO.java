/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Cart;
import model.Item;

/**
 *
 * @author LAM
 */
public class CartDAO extends DBContext{
    
    public Cart getCart(Account a) {
        Cart cart = new Cart();
        String sql = "select pid, quantity\n" +
                        "from CartLine\n" +
                        "where uID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getUid());
            
            LaptopDAO db = new LaptopDAO();
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cart.addItem(new Item(db.getById(rs.getInt(1)),
                                    rs.getInt(2),
                                    db.getById(rs.getInt(1)).getPrice()));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return cart;
    }
    
    public boolean checkCartLineExist(Account a, Item i) {
        String sql = "select  *\n" +
                    "from CartLine\n" +
                    "where uID = ? and pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getUid());
            st.setInt(2, i.getProducts().getPid());
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public Cart addToCart(Account a, Item i, Cart cart) {
        cart.addItem(i);
        
        if (checkCartLineExist(a, i)) {
            String sql = "update CartLine\n" +
                            "set quantity = ? \n" +
                            "where uID = ? and pid = ?";
            try {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, cart.getQuantityById(i.getProducts().getPid()));
                st.setInt(2, a.getUid());
                st.setInt(3, i.getProducts().getPid());
                st.executeUpdate();
                
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        
        else {
            String sql2="insert into [cartLine] values(?,?,?)";
            try {
                PreparedStatement st = connection.prepareStatement(sql2);
                st.setInt(1, a.getUid());
                st.setInt(2, i.getProducts().getPid());
                st.setInt(3, i.getQuantity());
            
                st.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
                
        return cart;
    }
    
    public void removeCart(Account a, int pid) {
        String sql="delete from CartLine\n" +
                    "where uID = ? and pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getUid());
            st.setInt(2, pid);
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteCart(Account a) {
        String sql="delete from CartLine\n" +
                    "where uID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getUid());
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
