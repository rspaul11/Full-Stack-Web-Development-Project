package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;
import com.tap.model.User;

public interface RestaurantDAO {
	
	List<Restaurant> getAllRestaurant();
	Restaurant getRestaurant(int RestaurantId);
	
	void addRestauran(Restaurant restaurant);
	
	void updateRestaurant(Restaurant restaurant);
	
	void deleteUser(int RestaurantId);
}