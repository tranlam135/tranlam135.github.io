/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SubCategories;

/**
 *
 * @author LAM
 */
public class SubCategoriesDAO extends DBContext{
    public List<SubCategories> getAll() {
        List<SubCategories> list = new ArrayList<SubCategories>();
        try {
            String sql = "select * from subcategories";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                SubCategories sc = new SubCategories();
                
                sc.setScid(rs.getInt(1));
                sc.setScname(rs.getString(2));
                sc.setCid(rs.getInt(3));
                
                list.add(sc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public SubCategories getByID(int scid) {
        try {
            String sql = "select * from subcategories\n"
                            + "where scid = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, scid);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                SubCategories sc = new SubCategories();
                
                sc.setScid(rs.getInt(1));
                sc.setScname(rs.getString(2));
                sc.setCid(rs.getInt(3));
                
                return sc;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public SubCategories getByName(String name) {
        try {
            String sql = "select * from subcategories\n"
                            + "where scname = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                SubCategories sc = new SubCategories();
                
                sc.setScid(rs.getInt(1));
                sc.setScname(rs.getString(2));
                sc.setCid(rs.getInt(3));
                
                return sc;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
}
