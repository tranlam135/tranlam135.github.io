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
import model.Categories;
import model.Products;
import model.SubCategories;

/**
 *
 * @author LAM
 */
public class DetailDAO extends DBContext{
    
    public Products getByPid(int pid) {
        String sql = "select p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "where p.pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
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
                
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public Categories getCat(int pid) {
        String sql = "select c.cid, c.cname\n"
                    + "from products p inner join subcategories sc on p.scid = sc.scid "
                    + "inner join Categories c on sc.cid = c.cid\n"
                    + "where p.pid = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Categories c = new Categories();
                
                c.setCid(rs.getInt(1));
                c.setCname(rs.getString(2));
                
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public SubCategories getSubCat(int pid) {
        String sql = "select sc.scid, sc.scname, sc.cid\n"
                    + "from products p inner join subcategories sc on p.scid = sc.scid "
                    + "where p.pid = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
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
    
    public List<Products> getRelated(int pid) {
        List<Products> list = new ArrayList<Products>();
        String sql = "select top(4) p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "where sc.scid = ? and p.pid != ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            int scid = new DetailDAO().getSubCat(pid).getScid();
            st.setInt(1, scid);
            st.setInt(2, pid);
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
    
    public static void main(String[] args) {
        DetailDAO db = new DetailDAO();
        Categories c = db.getCat(51);
        System.out.println(c);
    }
}
