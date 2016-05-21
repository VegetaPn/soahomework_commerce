package com.soa2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.soa2.model.Order;
import com.soa2.model.Product;
import com.soa2.util.ConnectionHelper;



public class OrderDao {
	public List<Order> findOrderByCustomerID(int customerID){
		 List<Order> list = new ArrayList<Order>();
	        Connection c = null;
	    	String sql = "SELECT * FROM soaworktwo.order where customer_id=?";
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, customerID);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	Order order=new Order();
	            	order.setId(rs.getInt("id"));
	            	order.setProduct_id_list(rs.getString("product_id_list"));
	            	order.setProduct_num_list(rs.getString("product_num_list"));
	            	order.setTotal_price(rs.getDouble("total_price"));
	            	order.setCustomer_id(rs.getInt("customer_id"));
	            	order.setShip_address(rs.getString("ship_address"));
	            	order.setProcess(rs.getString("process"));
	                list.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	}
	public List<Order> findOrderByProcess(String  process){
		 List<Order> list = new ArrayList<Order>();
	        Connection c = null;
	    	String sql = "SELECT * FROM soaworktwo.order where process=?";
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement(sql);
	            ps.setString(1, process);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	Order order=new Order();
	            	order.setId(rs.getInt("id"));
	            	order.setProduct_id_list(rs.getString("product_id_list"));
	            	order.setProduct_num_list(rs.getString("product_num_list"));
	            	order.setTotal_price(rs.getDouble("total_price"));
	            	order.setCustomer_id(rs.getInt("customer_id"));
	            	order.setShip_address(rs.getString("ship_address"));
	            	order.setProcess(rs.getString("process"));
	                list.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	}
	 public void updateProcess(String process,int id) {
	        Connection c = null;
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement("UPDATE soaworktwo.order SET process=? WHERE id=?");
	            ps.setString(1, process);
	            ps.setInt(2, id);
	            
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	     
	    }
	public Order findOrderByID(int id){
		String sql = "SELECT * FROM soaworktwo.order WHERE id = ?";
        
        Connection c = null;
        Order order=new Order();
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	order.setId(rs.getInt("id"));
            	order.setProduct_id_list(rs.getString("product_id_list"));
            	order.setProduct_num_list(rs.getString("product_num_list"));
            	order.setTotal_price(rs.getDouble("total_price"));
            	order.setCustomer_id(rs.getInt("customer_id"));
            	order.setShip_address(rs.getString("ship_address"));
            	order.setProcess(rs.getString("process"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return order;
	}
	 public List<Order> findAll() {
	        List<Order> list = new ArrayList<Order>();
	        Connection c = null;
	    	String sql = "SELECT * FROM soaworktwo.order ";
	        try {
	            c = ConnectionHelper.getConnection();
	            Statement s = (Statement) c.createStatement();
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	            	Order order=new Order();
	            	order.setId(rs.getInt("id"));
	            	order.setProduct_id_list(rs.getString("product_id_list"));
	            	order.setProduct_num_list(rs.getString("product_num_list"));
	            	order.setTotal_price(rs.getDouble("total_price"));
	            	order.setCustomer_id(rs.getInt("customer_id"));
	            	order.setShip_address(rs.getString("ship_address"));
	            	order.setProcess(rs.getString("process"));
	                list.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	    }
	 
	public Order createOrder(Order order) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
        	String sql="INSERT INTO `order`(product_id_list,product_num_list,total_price,customer_id,ship_address,process) VALUES(?,?,?,?,?,?)";
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
            ps.setString(6, order.getProcess());
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
