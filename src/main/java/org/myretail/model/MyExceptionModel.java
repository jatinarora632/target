package org.myretail.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyExceptionModel {
	
	@JsonProperty("exception_message")
	private String exceptionMessage;

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	

}
