package com.soa2.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status {
	private boolean result;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
}
