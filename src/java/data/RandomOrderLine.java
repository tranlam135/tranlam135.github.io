/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dal.AccountDAO;
import dal.DetailDAO;
import dal.LaptopDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.OrderLine;

/**
 *
 * @author LAM
 */
public class RandomOrderLine {
    public static void main(String[] args) {
        List<OrderLine> list = new ArrayList<>();
        Random rand = new Random();
        
        LaptopDAO ldb = new LaptopDAO();
        AccountDAO adb = new AccountDAO();
        DetailDAO ddb = new DetailDAO();
        
        for (int i = 1; i <= 500; i++) {
            int oid = rand.nextInt(2000) + 1;
            int pid = rand.nextInt(ldb.getAll().size()) + 1;
            int quantity = rand.nextInt(5) + 1;
            float price = ddb.getByPid(pid).getPrice() * (100 - ddb.getByPid(pid).getSale_off()) / 100;
            
            System.out.format("(%d,%d,%d,%.2f),\n", oid, pid, quantity, price);
        }
        
    }
}
