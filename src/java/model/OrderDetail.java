/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author LAM
 */
public class OrderDetail {
    private Date date;
    private String name, image;
    private float price;
    private int quantity;
    private float total;

    public OrderDetail() {
    }

    public OrderDetail(Date date, String name, String image, float price, int quantity, float total) {
        this.date = date;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
   
}
