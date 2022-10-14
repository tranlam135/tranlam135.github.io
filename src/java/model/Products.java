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
public class Products {
    private int pid;
    private String name, image;
    private float price;
    private int quantity;
    private SubCategories subCat;
    private Date release_date;
    private int sale_off;
    private String description;
    private int is_sell;

    public Products() {
    }

    public Products(int pid, String name, String image, float price, int quantity, SubCategories subCat, Date release_date, int sale_off, String description, int is_sell) {
        this.pid = pid;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.subCat = subCat;
        this.release_date = release_date;
        this.sale_off = sale_off;
        this.description = description;
        this.is_sell = is_sell;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SubCategories getSubCat() {
        return subCat;
    }

    public void setSubCat(SubCategories subCat) {
        this.subCat = subCat;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public int getSale_off() {
        return sale_off;
    }

    public void setSale_off(int sale_off) {
        this.sale_off = sale_off;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIs_sell() {
        return is_sell;
    }

    public void setIs_sell(int is_sell) {
        this.is_sell = is_sell;
    }

    @Override
    public String toString() {
        return "Products{" + "pid=" + pid + ", name=" + name + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", subCat=" + subCat + ", release_date=" + release_date + ", sale_off=" + sale_off + ", description=" + description + ", is_sell=" + is_sell + '}';
    }
    
}
