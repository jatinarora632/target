package org.myretail.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class ProductPriceModel {

	@JsonProperty("value")
	private float value;

	@JsonProperty("currency_code")
	private String currencyCode;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "ProductPriceModel [value=" + value + ", currencyCode=" + currencyCode + "]";
	}
}