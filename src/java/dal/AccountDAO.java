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
import model.Account;

/**
 *
 * @author LAM
 */
public class AccountDAO extends DBContext{
    public Account check(String user, String pass) {
        
        String sql = "select * from account where [user]=? and [pass]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1),
                                 rs.getString(2),
                                 rs.getString(3),
                                 rs.getFloat(4),
                                 rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("e");
        }
        return null;
    }
    
    public Account checkAccountExsit(String user) {
        
        String sql = "select * from account where [user]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1),
                                 rs.getString(2),
                                 rs.getString(3),
                                 rs.getFloat(4),
                                 rs.getInt(5));
            }
        } catch (SQLException e) {
            System.out.println("e");
        }
        return null;
    }
    
    public List<Account> getAll() {
        List<Account> list = new ArrayList<Account>();
        try {
            String sql = "select * \n"
                        + "from account\n"
                        + "order by role asc, uid asc";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Account p = new Account();
                
                p.setUid(rs.getInt(1));
                p.setUser(rs.getString(2));
                p.setPass(rs.getString(3));
                p.setMoney(rs.getFloat(4));
                p.setRole(rs.getInt(5));
                
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public Account getById(int id) {
        List<Account> list = new ArrayList<Account>();
        try {
            String sql = "select * \n"
                        + "from account\n"
                        + "where uid = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Account p = new Account();
                
                p.setUid(rs.getInt(1));
                p.setUser(rs.getString(2));
                p.setPass(rs.getString(3));
                p.setMoney(rs.getFloat(4));
                p.setRole(rs.getInt(5));
                
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    public void signup(String user, String pass) {
        String sql = "insert into Account\n" 
                    +"values(?,?,0,1)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void changeMoney(float money, int uid) {
        String sql = "UPDATE Account\n"
                + "SET money = ?\n"
                + "WHERE uID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setFloat(1, money);
            st.setInt(2, uid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void changePass(String pass, int uid) {
        String sql = "UPDATE Account\n"
                + "SET pass = ?\n"
                + "WHERE uID = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setInt(2, uid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public void changeRole(String uid, int role) {
        String sql = "UPDATE Account\n"
                + "SET role = ?\n"
                + "WHERE uID = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            st.setString(2, uid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e");
        }
    }
    
    public List<Account> getListByPage(List<Account> list,
            int start,int end){
        ArrayList<Account> arr = new ArrayList<>();
        for(int i = start; i < end; i++){
            arr.add(list.get(i));
        }
        return arr;
    }

}
