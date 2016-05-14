package com.soa2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soa2.model.Product;
import com.soa2.util.ConnectionHelper;



public class ProductDao {
	   public List<Product> findAll() {
	        List<Product> list = new ArrayList<Product>();
	        Connection c = null;
	    	String sql = "SELECT * FROM product ";
	        try {
	            c = ConnectionHelper.getConnection();
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	            	Product product=new Product();
	            	product.setId(rs.getInt("id"));
	            	product.setName(rs.getString("name"));
	            	product.setDescription(rs.getString("description"));
	            	product.setPrice(rs.getDouble("price"));
	            	product.setStock(rs.getInt("stock"));
	            	product.setStatus(rs.getInt("status"));
	                list.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	    }

}
