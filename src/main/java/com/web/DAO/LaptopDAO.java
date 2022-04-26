package com.web.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.web.model.LaptopDetail;

public class LaptopDAO {
	
	public static List<LaptopDetail> viewLaptops() throws Exception {
		Connection con = null;
		PreparedStatement lap = null;
		
		List <LaptopDetail> listProduct = new ArrayList<LaptopDetail>();
		
		LaptopDetail set = null;
		
		con = ConnectionUtil.getConnection();
		String query = "SELECT * FROM laptopview";
		
		lap = con.prepareStatement(query);
		ResultSet rs =lap.executeQuery(); 
		while(rs.next()) {
			set = new LaptopDetail();
			set.setId(rs.getInt("id"));
			set.setLapName(rs.getString("lap_name"));
			set.setLapSpecification(rs.getString("lap_specification"));
			set.setLapModel(rs.getString("lap_model"));
			set.setPrice(rs.getString("price"));
			set.setRating(rs.getString("rating"));
			set.setCount(rs.getString("counts"));
			
			listProduct.add(set);
		}
		System.out.println(listProduct);
		return listProduct;
		
		
	}
	public static int buyLaptop(int userId, int lapId, String strdate) throws Exception {
		int m = 0;
		Connection con = ConnectionUtil.getConnection();	
		PreparedStatement lap = null;
		
		String querey = "INSERT INTO laptoptransation(user_id,product_id,DATE) VALUES(?,?,?);";
		
		lap = con.prepareStatement(querey);
		lap.setInt(1,userId);
		lap.setInt(2,lapId);
		lap.setString(3, strdate);
		m = lap.executeUpdate();
		
		 
		
		return 0;
	}

	}


