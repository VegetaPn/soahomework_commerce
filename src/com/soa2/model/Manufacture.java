package com.soa2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Manufacture {
private int id;
private int order_id;
private int status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

}
