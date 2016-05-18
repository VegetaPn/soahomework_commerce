package com.soa2.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.soa2.model.Logistics;

@WebService
@SOAPBinding(style = Style.RPC)

public interface LogisticsInterface {
	@WebMethod
	Logistics getLogisticsStatus(int id);
}
