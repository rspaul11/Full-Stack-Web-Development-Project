package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.DBconnection;

public class UserDaoImpl implements UserDAO{

	private static final String INSERT="INSERT INTO `user` (`userId`, `name`, `userName`, `password`, `email`, `phoneNumber`, `address`, `role`) " +
										"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE `user` SET `Name` = ?, `Password` = ?, `PhoneNumber` = ?, `Address` = ?, `Role` = ? WHERE `UserId` = ?";
	private static final String GET_USER="SELECT * FROM `user` WHERE `id`=?";
	private static final String  DELETE="DELETE FROM `user` WHERE `userId`=?";
	private static final String  ALL_USER="SELECT * FROM `user`";
	private static final String GET_USER_BY_EMAIL = "SELECT * FROM `user` WHERE `Email` = ?";




	
	@Override
	public User getUser(int userId) {
		Connection connection = DBconnection.getConnection();
		PreparedStatement preparedStatement;
		User user=null;
		try {
			preparedStatement = connection.prepareStatement(GET_USER);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
			String name = resultSet.getString("name");
			String username = resultSet.getString("UserName");
			String password = resultSet.getString("Password");
			String email = resultSet.getString("Email");
			String phonenumber = resultSet.getString("PhoneNumber");
			String address = resultSet.getString("Address");
			String role = resultSet.getString("Role");
			
			user = new User(userId, name, username, password, email, phonenumber, address, role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}

	
	
	
	@Override
	public List<User> getAllUsers() {
		ArrayList<User> userlist = new ArrayList<User>();
		try {
			Connection connection = DBconnection.getConnection();
			Statement statement = connection.createStatement();
			
			
			ResultSet resultSet = statement.executeQuery(ALL_USER);
			while(resultSet.next()) {
				int userId = resultSet.getInt("userId");
				String name = resultSet.getString("name");
				String username = resultSet.getString("UserName");
				String password = resultSet.getString("Password");
				String email = resultSet.getString("Email");
				String phonenumber = resultSet.getString("PhoneNumber");
				String address = resultSet.getString("Address");
				String role = resultSet.getString("Role");
				User user = new User(userId, name, username, password, email, phonenumber, address, role);
				userlist.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}

	@Override
	public void addUser(User user) {
		try(Connection connection=DBconnection.getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(INSERT);)
		{

			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPhoneNumber());
			preparedStatement.setString(7, user.getAddress());
			preparedStatement.setString(8, user.getRole());
			

			int res= preparedStatement.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {
		try(Connection connection=DBconnection.getConnection();
				PreparedStatement preparedStatement =connection.prepareStatement(UPDATE);)
		{

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setInt(6, user.getUserId());

			int res= preparedStatement.executeUpdate();
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByEmail(String email) {
	    Connection connection = DBconnection.getConnection();
	    PreparedStatement preparedStatement;
	    User user = null;
	    try {
	        preparedStatement = connection.prepareStatement(GET_USER_BY_EMAIL);
	        preparedStatement.setString(1, email);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int userId = resultSet.getInt("userId");
	            String name = resultSet.getString("name");
	            String username = resultSet.getString("UserName");
	            String password = resultSet.getString("Password");
	            String phoneNumber = resultSet.getString("PhoneNumber");
	            String address = resultSet.getString("Address");
	            String role = resultSet.getString("Role");

	            user = new User(userId, name, username, password, email, phoneNumber, address, role);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}





	@Override
	public void deleteUser(int userId) {
		
		
		try {Connection connection = DBconnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE);
			statement.setInt(1, userId);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}