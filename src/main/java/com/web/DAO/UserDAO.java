package com.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.model.UserDetail;

public class UserDAO {

public static int addUser(UserDetail user) throws Exception {
	Connection connect = null;
	PreparedStatement add = null;

	connect = ConnectionUtil.getConnection();
	String query = "insert into laptopshop (NAME,email,PASSWORD,moblie_No,city) values(?,?,?,?,?) ";

	add = connect.prepareStatement(query);
	add.setString(1, user.getName());
	add.setString(2, user.getEmail());
	add.setString(3, user.getPassword());
	add.setString(4, user.getMoblie_no());
	add.setString(5, user.getCity());

	int rows = add.executeUpdate();
	System.out.println(rows);
	connect.close();
	return rows;
	
}
public static int mailValidation(String mail) throws Exception {

	Connection connect = null;
	PreparedStatement validation = null;
	ResultSet data = null;

	connect = ConnectionUtil.getConnection();
	String query = "select email from laptopshop where email=?";
	validation = connect.prepareStatement(query);
	validation.setString(1, mail);
	data = validation.executeQuery();
	String email = null;
	while (data.next()) {
		email = data.getString("email");
	}
	connect.close();
	if (email == null) {
		return 0;
	} else {
		throw new Exception("You're an existing user");
	}
	
}
// login validation
public static String loginValidation(String mail, String password) throws Exception {
	Connection connect = null;
	PreparedStatement validation = null;
	ResultSet data = null;
	String message = null;
	String email = null;
	String key = null;
	

	connect = ConnectionUtil.getConnection();
	String query = "select email,password from laptopshop where email=?";
	validation = connect.prepareStatement(query);
	validation.setString(1, mail);
	data = validation.executeQuery();

	while (data.next()) {
		email = data.getString("email");
		key = data.getString("password");
		
	}
	connect.close();
	if (email == null) {
		throw new Exception("No records found");

	} else if (key.equals(password)) {
		//System.out.println("Hello " + name + "! :)");
		message = "Successfully logging in";
		return message;
	} else {
		throw new Exception("Invalid Credentials");
	}
}

}
