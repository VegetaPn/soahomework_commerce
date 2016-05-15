package com.soa2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
import com.soa2.model.Manufacture;
import com.soa2.model.Order;
import com.soa2.services.Manufactures;
import com.soa2.util.ConnectionHelper;

public class ManufacturesDao {
	public Manufacture createManufactures(int  orderid) {
        Connection c = null;
        PreparedStatement ps = null;
        Manufacture manufacture=new Manufacture();
        try {
        	String sql="INSERT INTO manufacture_record(order_id,status) VALUES(?,?)";
        	
        	c = ConnectionHelper.getConnection();
            ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           
            ps.setInt(1, orderid);
            ps.setInt(2, 0);
            System.out.println(sql);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            manufacture.setId(id);
            manufacture.setOrder_id(orderid);
            manufacture.setStatus(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return manufacture;
    }
}
