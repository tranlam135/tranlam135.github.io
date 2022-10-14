/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAM
 */
public class Cart {
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public Item getItemById(int id) {
        for (Item i: items) {
            if (i.getProducts().getPid() == id) {
                return i;
            }
        }
        return null;
    }
    
    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }
    
    public void addItem(Item item) {
        if (getItemById(item.getProducts().getPid()) != null) {
            Item i = getItemById(item.getProducts().getPid());
            i.setQuantity(i.getQuantity() + item.getQuantity());
        } else {
            items.add(item);
        }
    }
    
    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
    
    public float getTotalMoney() {
        float tmp = 0;
        for (Item item: items) {
            tmp += item.getPrice() * item.getQuantity();
        }
        return tmp;
    }
}
