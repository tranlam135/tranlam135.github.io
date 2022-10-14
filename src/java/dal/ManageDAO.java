/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Products;

/**
 *
 * @author LAM
 */
public class ManageDAO extends DBContext{
    public void addProduct(Products p) {
        String sql = "insert into Products\n" 
                    +"values (?,?,?,?,?,?,0,?,0)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1, p.getName());
            st.setString(2, p.getImage());
            st.setFloat(3, p.getPrice());
            st.setInt(4, p.getQuantity());
            st.setInt(5, p.getSubCat().getScid());
            st.setDate(6, p.getRelease_date());
            st.setString(7, p.getDescription());
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void addSubCategories(String name) {
            String sql = "insert into SubCategories\n" 
                    +"values ('?', 1)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void editProduct(String name, String image, String price, String quantity, String sale_off, String description, String pid) {
        String sql = "update products\n" 
                    +"set name = ?, image = ?, price = ?, quantity = ?, sale_off = ?, description = ?\n"
                    + "where pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, image);
            st.setString(3, price);
            st.setString(4, quantity);
            st.setString(5, sale_off);
            st.setString(6, description);
            st.setString(7, pid);
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("e");
        }
        
    }
    
    public void deleteProduct(String pid) {
        String sql = "delete from Products\n" 
                    +"where pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1, pid);
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
}
