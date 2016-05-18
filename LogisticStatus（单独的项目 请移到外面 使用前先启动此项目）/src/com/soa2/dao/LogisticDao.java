package com.soa2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soa2.model.Logistics;
import com.soa2.util.ConnectHelper;

public class LogisticDao {

	public Logistics getStatus(int orderId){
		
		String sql = "select * from logistic_record where order_id='"+orderId+"'";
		ResultSet rs;
		ConnectHelper db=new ConnectHelper(sql);
		Logistics logistic = new Logistics();
		try {  
			 rs=db.pst.executeQuery();
			 while(rs.next()){
				logistic.setOrder_id(orderId);
				logistic.setId(rs.getInt("id"));
				logistic.setProgress(rs.getString("progress"));
				logistic.setStatus(rs.getInt("status"));	   
		      }
			  rs.close();
			  db.close();
			  return logistic;
		   } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		   }
		return null;		
	}
	
}
