package org.myretail.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class ProductModel {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("current_price")
	private ProductPriceModel currentPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductPriceModel getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(ProductPriceModel currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", currentPrice=" + currentPrice.toString() + "]";
	}
}