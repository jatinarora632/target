package org.myretail.utils;

public class ProductExceptionHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String exceptionMessage;

	public ProductExceptionHandler(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
