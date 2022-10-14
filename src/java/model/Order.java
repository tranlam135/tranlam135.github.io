/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LAM
 */


public class Order {
    private int oid;
    private String date;
    private float totalmoney;
    private int uID;

    public Order() {
    }

    public Order(int oid, String date, float totalmoney, int uID) {
        this.oid = oid;
        this.date = date;
        this.totalmoney = totalmoney;
        this.uID = uID;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    @Override
    public String toString() {
        return "Order{" + "oid=" + oid + ", date=" + date + ", totalmoney=" + totalmoney + ", uID=" + uID + '}';
    }
    
}
