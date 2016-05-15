package com.soa2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
private int id;
private String product_id_list;
private String product_num_list;
private double total_price;
private int customer_id;
private String ship_address;
private String process;
public String getProcess() {
	return process;
}
public void setProcess(String process) {
	this.process = process;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProduct_id_list() {
	return product_id_list;
}
public void setProduct_id_list(String product_id_list) {
	this.product_id_list = product_id_list;
}
public String getProduct_num_list() {
	return product_num_list;
}
public void setProduct_num_list(String product_num_list) {
	this.product_num_list = product_num_list;
}
public double getTotal_price() {
	return total_price;
}
public void setTotal_price(double total_price) {
	this.total_price = total_price;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getShip_address() {
	return ship_address;
}
public void setShip_address(String ship_address) {
	this.ship_address = ship_address;
}


}
