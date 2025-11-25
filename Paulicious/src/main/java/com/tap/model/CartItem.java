package com.tap.model;

public class CartItem {
	private int itemId;
	private int menuId;
	private int restaurantId;
	private String name;
	private int quantity;
	private double price;

	

	
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public CartItem(int itemId, int menuId, int restaurantId, String name, int quantity, double price) {
	    this.itemId = itemId;
	    this.menuId = menuId;
	    this.restaurantId = restaurantId;
	    this.name = name;
	    this.quantity = quantity;
	    this.price = price;
	    
	}

	
	
	
}