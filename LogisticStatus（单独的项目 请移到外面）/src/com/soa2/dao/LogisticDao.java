package com.soa2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soa2.model.Logistics;
import com.soa2.util.ConnectHelper;

public class LogisticDao {

	public Logistics getStatus(int id){
		
		String sql = "select * from logistic_record where id='"+id+"'";
		ResultSet rs;
		ConnectHelper db=new ConnectHelper(sql);
		Logistics logistic = new Logistics();
		try {  
			 rs=db.pst.executeQuery();
			 while(rs.next()){
				logistic.setId(id);
				logistic.setOrder_id(rs.getInt("order_id"));
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
