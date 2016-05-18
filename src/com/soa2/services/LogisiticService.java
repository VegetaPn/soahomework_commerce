package com.soa2.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.soa2.dao.LogisiticDao;
import com.soa2.dao.OrderDao;
import com.soa2.logisticstatus.Logistics;
import com.soa2.logisticstatus.LogisticsImplService;
import com.soa2.logisticstatus.LogisticsInterface;
import com.soa2.model.Logisitic;
import com.soa2.model.Order;

@Path("/LogisiticService")
public class LogisiticService {
	LogisiticDao logisitic=new LogisiticDao();
	OrderDao orderdao=new OrderDao();
	@GET @Path("findorderByprocess/{process}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Order> findallOrders(@PathParam("process") String process) {//չʾ���еĶ���,processȡֵ{�˿����µ�������������������������}
		return orderdao.findOrderByProcess(process);//չʾ�����Ѿ������Ķ��� ��manufacturerѡ��һ������

	}
	@GET @Path("{orderid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Logisitic transport(@PathParam("orderid") int orderid) {//true���ڴ����������������ٿ�棬fasle�ǲ��� ���ܲ�
		
			orderdao.updateProcess("����������", orderid);
			return logisitic.create(orderid);
		
	}
	
	@GET @Path("status/{orderid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Logistics getLogisticStatus(@PathParam("orderid") int orderid) {
		
		 LogisticsImplService service = new LogisticsImplService();
		 LogisticsInterface  ps = service.getLogisticsImplPort();
         return ps.getLogisticsStatus(orderid);
		
	}
}
