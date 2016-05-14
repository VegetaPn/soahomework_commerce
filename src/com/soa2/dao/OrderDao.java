package com.soa2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
import com.soa2.model.Order;
import com.soa2.util.ConnectionHelper;



public class OrderDao {
	public Order createOrder(Order order) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
        	String sql="INSERT INTO `order`(product_id_list,product_num_list,total_price,customer_id,ship_address) VALUES(?,?,?,?,?)";
        	  System.out.println(order.getProduct_id_list());
        	  System.out.println(order.getProduct_num_list());
        	  System.out.println(order.getTotal_price());
        	  System.out.println(order.getCustomer_id());
        	  System.out.println(order.getShip_address());
        	c = ConnectionHelper.getConnection();
            ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getProduct_id_list());
            ps.setString(2, order.getProduct_num_list());
            ps.setDouble(3, order.getTotal_price());
            ps.setInt(4, order.getCustomer_id());
            ps.setString(5, order.getShip_address());
            System.out.println(sql);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            order.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return order;
    }
}
