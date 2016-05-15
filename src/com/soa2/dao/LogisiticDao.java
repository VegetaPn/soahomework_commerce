package com.soa2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
import com.soa2.model.Logisitic;
import com.soa2.model.Manufacture;
import com.soa2.util.ConnectionHelper;

public class LogisiticDao {
	public Logisitic create(int  orderid) {
        Connection c = null;
        PreparedStatement ps = null;
        Logisitic logisitic=new Logisitic();
        try {
        	String sql="INSERT INTO logistic_record(order_id,progress,status) VALUES(?,?,?)";
        	
        	c = ConnectionHelper.getConnection();
            ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           
            ps.setInt(1, orderid);
            ps.setString(2, "≈‰ÀÕ÷–");
            ps.setInt(3, 0);
            System.out.println(sql);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            logisitic.setId(id);
            logisitic.setOrder_id(orderid);
            logisitic.setStatus(0);
            logisitic.setProgress("≈‰ÀÕ÷–");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return logisitic;
    }
}
