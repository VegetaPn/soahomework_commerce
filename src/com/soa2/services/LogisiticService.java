package com.soa2.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.soa2.dao.LogisiticDao;
import com.soa2.dao.ManufacturesDao;
import com.soa2.dao.OrderDao;
import com.soa2.dao.ProductDao;
import com.soa2.model.Logisitic;
import com.soa2.model.Order;

@Path("/LogisiticService")
public class LogisiticService {
	LogisiticDao logisitic=new LogisiticDao();
	OrderDao orderdao=new OrderDao();
	@GET @Path("findorderByprocess/{process}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Order> findallOrders(@PathParam("process") String process) {//展示所有的订单,process取值{顾客已下单，厂商已生产，物流配送中}
		return orderdao.findOrderByProcess(process);//展示厂商已经生产的订单 让manufacturer选择一个配送

	}
	@GET @Path("{orderid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Logisitic transport(@PathParam("orderid") int orderid) {//true是内存充足可以生产并减少库存，fasle是不足 不能产
		
			orderdao.updateProcess("物流配送中", orderid);
			return logisitic.create(orderid);
		
	}
}
