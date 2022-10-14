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
import model.Products;
import model.SubCategories;

/**
 *
 * @author LAM
 */
public class TypeProductsDAO extends DBContext{
    
    public List<Products> getTopNewest() {
        List<Products> list = new ArrayList<Products>();
        String sql = "select top(6) p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "order by p.Release_date desc";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Products p = new Products();
                
                p.setPid(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                
                SubCategories sc = new SubCategories();
                sc.setScid(rs.getInt("scid"));
                sc.setScname(rs.getString("scname"));
                p.setSubCat(sc);
                
                p.setRelease_date(rs.getDate("release_date"));
                p.setSale_off(rs.getInt("sale_off"));
                p.setDescription(rs.getString("description"));
                p.setIs_sell(rs.getInt("is_sell"));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public List<Products> getTopSell() {
        List<Products> list = new ArrayList<Products>();
        String sql = "select top(6) p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "order by p.is_sell desc";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Products p = new Products();
                
                p.setPid(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                
                SubCategories sc = new SubCategories();
                sc.setScid(rs.getInt("scid"));
                sc.setScname(rs.getString("scname"));
                p.setSubCat(sc);
                
                p.setRelease_date(rs.getDate("release_date"));
                p.setSale_off(rs.getInt("sale_off"));
                p.setDescription(rs.getString("description"));
                p.setIs_sell(rs.getInt("is_sell"));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public List<Products> getTopSale() {
        List<Products> list = new ArrayList<Products>();
        String sql = "select top(6) p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "order by p.sale_off desc";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Products p = new Products();
                
                p.setPid(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                
                SubCategories sc = new SubCategories();
                sc.setScid(rs.getInt("scid"));
                sc.setScname(rs.getString("scname"));
                p.setSubCat(sc);
                
                p.setRelease_date(rs.getDate("release_date"));
                p.setSale_off(rs.getInt("sale_off"));
                p.setDescription(rs.getString("description"));
                p.setIs_sell(rs.getInt("is_sell"));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public List<Products> getDeal(int scid) {
        List<Products> list = new ArrayList<Products>();
        String sql = "select p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "where p.sale_off > 0 and p.scid = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, scid);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Products p = new Products();
                
                p.setPid(rs.getInt("pid"));
                p.setName(rs.getString("name"));
                p.setImage(rs.getString("image"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                
                SubCategories sc = new SubCategories();
                sc.setScid(rs.getInt("scid"));
                sc.setScname(rs.getString("scname"));
                p.setSubCat(sc);
                
                p.setRelease_date(rs.getDate("release_date"));
                p.setSale_off(rs.getInt("sale_off"));
                p.setDescription(rs.getString("description"));
                p.setIs_sell(rs.getInt("is_sell"));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
}
