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

@Path("/Manufactures")
public class Manufactures {
	ProductDao dao=new ProductDao();
	ManufacturesDao mdao=new ManufacturesDao();
	OrderDao orderdao=new OrderDao();
	@GET @Path("{orderid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean produce(@PathParam("orderid") int orderid) {//true���ڴ����������������ٿ�棬fasle�ǲ��� ���ܲ�
		if(dao.produces(orderid)){
			mdao.createManufactures(orderid);//�����¼��
			orderdao.updateProcess("����������", orderid);
			return true;
		}else{
			return false;
		}
		
		
	}
	
	@GET @Path("findorderByprocess/{process}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Order> findallOrders(@PathParam("process") String process) {//չʾ���еĶ���,processȡֵ{�˿����µ�������������������������}
		return orderdao.findOrderByProcess(process);//չʾ�˿����µ�״̬�Ķ��� ��ecommerceѡ��һ������
		
		
	}
}
