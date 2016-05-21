package com.soa2.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.soa2.dao.ManufacturesDao;
import com.soa2.dao.OrderDao;
import com.soa2.dao.ProductDao;
import com.soa2.model.Manufacture;
import com.soa2.model.Order;
import com.soa2.model.Status;

@Path("/Manufactures")
public class Manufactures {
	ProductDao dao=new ProductDao();
	ManufacturesDao mdao=new ManufacturesDao();
	OrderDao orderdao=new OrderDao();
	@GET @Path("{orderid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	
	public Status produce(@PathParam("orderid") int orderid) {//true是内存充足可以生产并减少库存，fasle是不足 不能产
		Status status=new Status();
		if(dao.produces(orderid)){
			mdao.createManufactures(orderid);//加入记录中
			orderdao.updateProcess("厂商已生产", orderid);
			status.setResult(true);
			return status;
		}else{
			status.setResult(false);
			return status;
		}
		
		
	}
	
	@GET @Path("findorderByprocess/{process}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Order> findallOrders(@PathParam("process") String process) {//展示所有的订单,process取值{顾客已下单，厂商已生产，物流配送中}
		return orderdao.findOrderByProcess(process);//展示顾客已下单状态的订单 让ecommerce选择一个生产
		
		
	}
}
