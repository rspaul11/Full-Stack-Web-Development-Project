package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.util.DBconnection;

public class MenuDAOimpl implements MenuDAO {

    private static final String INSERT = "INSERT INTO menu (menuid, restaurantid, itemname, description, price, isavailable, ratings, imagepath) "
                                       + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String UPDATE = "UPDATE menu SET restaurantid=?, itemname=?, description=?, price=?, isavailable=?, ratings=?, imagepath=? WHERE menuid=?";
    private static final String SELECT = "SELECT * FROM menu WHERE menuid=?";
    private static final String SELECT_ALL = "SELECT * FROM menu";
    private static final String DELETE = "DELETE FROM menu WHERE menuid=?";
    private static final String SELECT_BY_RESTAURANT = "SELECT * FROM menu WHERE restaurantid=?"; // Added

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> list = new ArrayList<>();

        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Menu m = new Menu();
                m.setMenuId(rs.getInt("menuid"));
                m.setRestaurantId(rs.getInt("restaurantid"));
                m.setItemName(rs.getString("itemname"));
                m.setDescription(rs.getString("description"));
                m.setPrice(rs.getDouble("price"));
                m.setAvailable(rs.getBoolean("isavailable"));
                m.setRatings(rs.getDouble("ratings"));
                m.setImagePath(rs.getString("imagepath"));
                list.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Menu getMenu(int id) {
        Menu m = null;
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Menu();
                m.setMenuId(rs.getInt("menuid"));
                m.setRestaurantId(rs.getInt("restaurantid"));
                m.setItemName(rs.getString("itemname"));
                m.setDescription(rs.getString("description"));
                m.setPrice(rs.getDouble("price"));
                m.setAvailable(rs.getBoolean("isavailable"));
                m.setRatings(rs.getDouble("ratings"));
                m.setImagePath(rs.getString("imagepath"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return m;
    }

    @Override
    public void addMenu(Menu menu) {
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT)) {

            ps.setInt(1, menu.getMenuId());
            ps.setInt(2, menu.getRestaurantId());
            ps.setString(3, menu.getItemName());
            ps.setString(4, menu.getDescription());
            ps.setDouble(5, menu.getPrice());
            ps.setBoolean(6, menu.isAvailable());
            ps.setDouble(7, menu.getRatings());
            ps.setString(8, menu.getImagePath());

            ps.executeUpdate();
            System.out.println("Menu inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMenu(Menu menu) {
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setBoolean(5, menu.isAvailable());
            ps.setDouble(6, menu.getRatings());
            ps.setString(7, menu.getImagePath());
            ps.setInt(8, menu.getMenuId());

            ps.executeUpdate();
            System.out.println("Menu updated successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(Menu menu) {
        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE)) {

            ps.setInt(1, menu.getMenuId());
            ps.executeUpdate();
            System.out.println("Menu deleted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getMenusByRestaurant(int restaurantId) {
        List<Menu> list = new ArrayList<>();

        try (Connection connection = DBconnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_RESTAURANT)) {

            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Menu m = new Menu();
                m.setMenuId(rs.getInt("menuid"));
                m.setRestaurantId(rs.getInt("restaurantid"));
                m.setItemName(rs.getString("itemname"));
                m.setDescription(rs.getString("description"));
                m.setPrice(rs.getDouble("price"));
                m.setAvailable(rs.getBoolean("isavailable"));
                m.setRatings(rs.getDouble("ratings"));
                m.setImagePath(rs.getString("imagepath"));
                list.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}