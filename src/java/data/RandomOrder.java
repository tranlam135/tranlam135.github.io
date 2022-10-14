/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dal.AccountDAO;
import dal.OrderDAO;
import java.text.ParseException;
import java.util.List;
import java.util.Random;
import model.Order;
/**
 *
 * @author LAM
 */

public class RandomOrder {
    
    public static String getDate() throws ParseException {
        Integer x;
        int day, month, year;
        Random rand = new Random();
        month = rand.nextInt(12) + 1;
        year = rand.nextInt(2) + 2019;
        if (year == 2020 && month == 2) {
            day = rand.nextInt(29) + 1;
        } else if (month == 2) {
            day = rand.nextInt(28) + 1;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = rand.nextInt(30) + 1;
        } else day = rand.nextInt(31) + 1;
        x = year * 10000 + month * 100 + day;
        String str = x.toString();
        str = new StringBuilder(str).insert(4, "-").toString();
        str = new StringBuilder(str).insert(7, "-").toString();
        return str;
    }
    
    public static void main(String[] args) throws ParseException {
        AccountDAO adb = new AccountDAO();
        OrderDAO odb = new OrderDAO();
        Random rand = new Random();
        
        int n = adb.getAll().size();
        List<Order> list = odb.getAllFromOrderLine();
        String s = null;
        
        for (int i = 1; i <= 1000; i++) {
            s = getDate();
            int uid = rand.nextInt(n) + 1;
            System.out.format("('%s',%.2f,%d),\n", s, list.get(i).getTotalmoney(), uid);
        }
    }
}
