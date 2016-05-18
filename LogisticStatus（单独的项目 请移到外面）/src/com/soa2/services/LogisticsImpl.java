package com.soa2.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.soa2.dao.LogisticDao;
import com.soa2.model.Logistics;

@SuppressWarnings("unused")
@WebService(endpointInterface = "com.soa2.services.LogisticsInterface")
public class LogisticsImpl implements LogisticsInterface{

	@Override
	public Logistics getLogisticsStatus(int id) {
		LogisticDao logistic =new LogisticDao();
		return logistic.getStatus(id);
	}

}
