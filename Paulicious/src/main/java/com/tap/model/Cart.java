package com.tap.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Cart {

    private Map<Integer, CartItem> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addItemToCart(CartItem newItem) {
        int menuId = newItem.getMenuId() ;

        if (items.containsKey(menuId)) {
            CartItem existingItem = items.get(menuId);
            existingItem.setQuantity(existingItem.getQuantity() + newItem.getQuantity());
        } else {
            items.put(menuId, newItem);
        }
    }

    public void updateItemInCart(int menuId, int newQuantity) {
        if (items.containsKey(menuId)) {
            CartItem item = items.get(menuId);
            item.setQuantity(newQuantity);
        }
    }

    public void deleteItemFromCart(int menuId) {
        items.remove(menuId);
    }

    public Collection<CartItem> getItems() {
        return items.values(); // returns all cart items as a collection
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clearCart() {
        items.clear();
    }
}