package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBconnection;

public class RestaurantDaoImpl implements RestaurantDAO {

	private static final String GET_RESTAURANTS = "SELECT * FROM `restaurant` WHERE `RestaurantId`=?";
	private static final String GET_ALL_RESTAURANTS = "SELECT * FROM `restaurant`";
	private static final String ADD_RESTAURANT = "INSERT INTO `restaurant` (`RestaurantId`, `Name`, `Address`, `PhoneNumber`, `CuisineType`, `DeliveryTime`, `AdminUserId`, `Rating`, `IsActive`, `ImagePath`)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE `restaurant` SET `Name` = ?, `Address` = ?, `PhoneNumber` = ?, `CuisineType` = ?, "
			+ "`DeliveryTime` = ?, `AdminUserId` = ?, `Rating` = ?, `IsActive` = ?, `ImagePath` = ? "
			+ "WHERE `RestaurantId` = ?";
	private static final String DELETE = "DELETE FROM `restaurant` WHERE `RestaurantId`=?";

	@Override
	public List<Restaurant> getAllRestaurant() {
		ArrayList<Restaurant> arrayList = new ArrayList<Restaurant>();
		Connection connection = DBconnection.getConnection();

		if (connection == null) {
			throw new RuntimeException("❌ DB connection is null in getAllRestaurant()");
		}

		try {
			PreparedStatement statement = connection.prepareStatement(GET_ALL_RESTAURANTS);
			ResultSet res = statement.executeQuery();

			while (res.next()) {
				int restaurantID = res.getInt("RestaurantId");
				String name = res.getString("Name");
				String address = res.getString("Address");
				String phonenumber = res.getString("PhoneNumber");
				String cuisinetype = res.getString("CuisineType");
				String deliverytime = res.getString("DeliveryTime");
				String adminserid = res.getString("AdminUserId");
				float rating = res.getFloat("Rating");
				String isactive = res.getString("IsActive");
				String imagePath = res.getString("ImagePath");
				Restaurant restaurant = new Restaurant(restaurantID, name, address, phonenumber, cuisinetype,
						deliverytime, adminserid, rating, isactive, imagePath);
				arrayList.add(restaurant);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrayList;
	}

	@Override
	public Restaurant getRestaurant(int RestaurantId) {
		Restaurant restaurant = null;
		Connection connection = DBconnection.getConnection();

		if (connection == null) {
			throw new RuntimeException("❌ DB connection is null in getRestaurant()");
		}

		try {
			PreparedStatement statement = connection.prepareStatement(GET_RESTAURANTS);
			statement.setInt(1, RestaurantId);
			ResultSet res = statement.executeQuery();

			if (res.next()) {
				String name = res.getString("Name");
				String address = res.getString("Address");
				String phonenumber = res.getString("PhoneNumber");
				String cuisinetype = res.getString("CuisineType");
				String deliverytime = res.getString("DeliveryTime");
				String adminuserid = res.getString("AdminUserId");
				float ratng = res.getFloat("Rating");
				String isactive = res.getString("IsActive");
				String imagePath = res.getString("ImagePath");

				restaurant = new Restaurant(RestaurantId, name, address, phonenumber, cuisinetype, deliverytime,
						adminuserid, ratng, isactive, imagePath);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public void addRestauran(Restaurant restaurant) {
		Connection connection = DBconnection.getConnection();

		if (connection == null) {
			throw new RuntimeException("❌ DB connection is null in addRestauran()");
		}

		try {
			PreparedStatement statement = connection.prepareStatement(ADD_RESTAURANT);
			statement.setInt(1, restaurant.getRestaurantId());
			statement.setString(2, restaurant.getName());
			statement.setString(3, restaurant.getAddress());
			statement.setString(4, restaurant.getPhoneNumber());
			statement.setString(5, restaurant.getCuisineType());
			statement.setString(6, restaurant.getDeliveryTime());
			statement.setString(7, restaurant.getAdminUserId());
			statement.setFloat(8, restaurant.getRating());
			statement.setString(9, restaurant.getIsActive());
			statement.setString(10, restaurant.getImagePath());

			int res = statement.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		Connection connection = DBconnection.getConnection();

		if (connection == null) {
			throw new RuntimeException("❌ DB connection is null in updateRestaurant()");
		}

		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE);
			statement.setString(1, restaurant.getName());
			statement.setString(2, restaurant.getAddress());
			statement.setString(3, restaurant.getPhoneNumber());
			statement.setString(4, restaurant.getCuisineType());
			statement.setString(5, restaurant.getDeliveryTime());
			statement.setString(6, restaurant.getAdminUserId());
			statement.setFloat(7, restaurant.getRating());
			statement.setString(8, restaurant.getIsActive());
			statement.setString(9, restaurant.getImagePath());
			statement.setInt(10, restaurant.getRestaurantId());
			int res = statement.executeUpdate();
			System.out.println(res);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int RestaurantId) {
		Connection connection = DBconnection.getConnection();

		if (connection == null) {
			throw new RuntimeException("❌ DB connection is null in deleteUser()");
		}

		try {
			PreparedStatement statement = connection.prepareStatement(DELETE);
			statement.setInt(1, RestaurantId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}