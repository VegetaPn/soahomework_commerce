package com.soa2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soa2.model.Order;
import com.soa2.model.Product;
import com.soa2.util.ConnectionHelper;



public class ProductDao {
	 public boolean isEnoughOrNot( String[] ids, String[] nums){
		 for(int i=0;i<ids.length;i++){
			 if(Integer.parseInt(nums[i])>findStockByID(Integer.parseInt(ids[i]))){
				 return false;//库存不够
			 }
		 }
		 for(int i=0;i<ids.length;i++){
			 update(Integer.parseInt(ids[i]),findStockByID(Integer.parseInt(ids[i]))-Integer.parseInt(nums[i]));
		 }
		 
		 return true;
	 }
	 public int findStockByID(int id) {
		    int stock = 0;
	        Connection c = null;
	    	String sql = "SELECT * FROM product where id=?";
	        try {
	            c = ConnectionHelper.getConnection();
	          PreparedStatement ps=c.prepareStatement(sql);
	          ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()) {
	            	stock=rs.getInt("stock");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return stock;
		 
	 }
	 public void update(int  productid,int num) {
	        Connection c = null;
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement("UPDATE product SET stock=? WHERE id=?");
	            ps.setInt(1, num);
	            ps.setInt(2, productid);
	            
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	     
	    }
	 public boolean produces(int orderid) {//生产订单
		 OrderDao orderdao=new OrderDao();
		 Order order=orderdao.findOrderByID(orderid);
		 String[] ids=order.getProduct_id_list().split(",");
		 String[] nums=order.getProduct_num_list().split(",");
		 return isEnoughOrNot(ids,nums);
	 }
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
