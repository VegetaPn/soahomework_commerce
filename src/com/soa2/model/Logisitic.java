package com.soa2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Logisitic {
private int id;
private int order_id;
private String progress;
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
public String getProgress() {
	return progress;
}
public void setProgress(String progress) {
	this.progress = progress;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

}
