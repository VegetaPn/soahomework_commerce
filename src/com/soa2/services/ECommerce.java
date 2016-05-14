package com.soa2.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.soa2.dao.OrderDao;
import com.soa2.dao.ProductDao;
import com.soa2.model.Order;
import com.soa2.model.Product;



@Path("/ECommerce")
public class ECommerce {//ECommerce�ṩ�Ľӿ� ��Ҫ�ṩ�µ��Ͳ�Ʒ�б�
	ProductDao productdao = new ProductDao();
	OrderDao orderdao = new OrderDao();
	
	@GET @Path("allproducts")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Product> findAll() {
		System.out.println("findAll");
		return productdao.findAll();
	}

	@POST @Path("addorder")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Order create(Order order) {//����Ϊһ��json�����������ݿ��еĸ�ʽ���磺
//		{
//		    "id":null,
//		    "product_id_list":"2,3",
//		    "product_num_list":"1,2",
//		    "total_price":45.6,
//		    "customer_id":1,
//		    "ship_address":"sdf"
//		    
//		}
		
		return orderdao.createOrder(order);
	}
	
}
