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
public class LaptopDAO extends DBContext{
    
    public List<Products> getAll() {
        List<Products> list = new ArrayList<Products>();
        String sql = "select p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid";
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
    
    public List<Products> checkLaptops(int[] id, String sortby){
        List<Products> list = new ArrayList<>();
        String sql = "select p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "where 1 = 1";
        if(id != null){
            sql += " and p.scid in(";
            for (int i = 0; i < id.length; i++) {
                sql += id[i] + ",";
            }
            if (sql.endsWith(","))
                sql = sql.substring(0, sql.length()-1);
            sql += ")";
        }
        if (sortby != null && !sortby.equals("")) {
            int so;
            try {
                so = Integer.parseInt(sortby);
            } catch (NumberFormatException e) {
                so = 0;
            }
            switch (so) {
                case 0:
                    sql += "\n order by p.pid asc";
                    break;
                case 1:
                    sql += "\n order by p.Release_date desc";
                    break;
                case 2:
                    sql += "\n order by (p.price * (100 - p.sale_off) / 100)  desc";
                    break;
                case 3:
                    sql += "\n order by (p.price * (100 - p.sale_off) / 100)  asc";
                    break;
            }
        }
      
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            
            ResultSet rs=st.executeQuery();
            while(rs.next()){
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
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public List<Products> getByName(String name) {
        List<Products> list = new ArrayList<Products>();
        String sql = "select p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "where name like '%" + name + "%'";
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
    
    public Products getById(int id) {
        Products p = new Products();
        String sql = "select p.pid, p.name, p.image, p.price, p.quantity, sc.scid, sc.scname, "
                        + "p.release_date, p.sale_off, p.description, p.is_sell\n" 
                        + "from products p inner join subcategories sc on p.scid = sc.scid\n"
                        + "where p.pid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                
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
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return p;
    }
   
    public List<Products> getListByPage(List<Products> list,
            int start,int end){
        ArrayList<Products> arr = new ArrayList<>();
        for(int i = start; i < end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }

}
