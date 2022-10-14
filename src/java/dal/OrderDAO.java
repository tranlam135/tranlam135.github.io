/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Cart;
import model.Item;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author LAM
 */
public class OrderDAO extends DBContext{
        
    public List<OrderDetail> history(int uid) {
        List<OrderDetail> list = new ArrayList<OrderDetail>();
        String sql = "select o.date, p.name, p.image , ol.price, ol.quantity, (ol.price * ol.quantity) as total\n" +
                        "from Account a inner join [Order] o on a.uID = o.uID\n" +
                        "	inner join OrderLine ol on o.oid = ol.oid\n" +
                        "	inner join Products p on ol.pid = p.pid\n" +
                        "where a.uid = ?\n" +
                        "order by o.date desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                OrderDetail o = new OrderDetail();
                
                o.setDate(rs.getDate(1));
                o.setName(rs.getString(2));
                o.setImage(rs.getString(3));
                o.setPrice(rs.getFloat(4));
                o.setQuantity(rs.getInt(5));
                o.setTotal(rs.getFloat(6));
                
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public List<OrderDetail> getListByPage(List<OrderDetail> list,
            int start,int end){
        ArrayList<OrderDetail> arr = new ArrayList<>();
        for(int i = start; i < end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public List<Order> getAllFromOrderLine() {
        List<Order> list = new ArrayList<Order>();
        String sql = "select ol.oid, sum(ol.price * ol.quantity) as totalmoney\n"
                        + "from OrderLine  ol\n" 
                        + "group by ol.oid\n"
                        + "order by ol.oid";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Order o = new Order();
                
                o.setOid(rs.getInt(1));
                o.setDate("");
                o.setTotalmoney(rs.getFloat(2));
                o.setuID(0);
                
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    
    public void addOrder(Account u, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        
        try{
            String sql="insert into [order] "
                        + "values(?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            st.setFloat(2, cart.getTotalMoney());
            st.setInt(3, u.getUid());
            st.executeUpdate();
            
            String sql1 = "select top 1 id from [Order] "
                        + "order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs=st1.executeQuery();
            while(rs.next()){
                for(Item i:cart.getItems()){
                    String sql2 = "insert into [orderline] values(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, rs.getInt(1));
                    st2.setInt(2, i.getProducts().getPid());
                    st2.setInt(3, i.getQuantity());
                    st2.setFloat(4, i.getPrice());
                    st2.executeUpdate();
                }
            }
            
            String sql3 = "update Products set quantity = quantity - ? \n" +
                            "where pid = ?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (Item i:cart.getItems()){
                st3.setInt(1, i.getQuantity());
                st3.setInt(2, i.getProducts().getPid());
                st3.executeUpdate();
            }
        } catch(SQLException e){
            System.out.println(e);
        }
    }
}
