package com.tap.dao;

import java.util.List;
import com.tap.model.Menu;

public interface MenuDAO {
    List<Menu> getAllMenus();
    Menu getMenu(int id);
    void addMenu(Menu menu);
    void updateMenu(Menu menu);
    void deleteMenu(Menu menu);
    List<Menu> getMenusByRestaurant(int restaurantId); // Added method
}