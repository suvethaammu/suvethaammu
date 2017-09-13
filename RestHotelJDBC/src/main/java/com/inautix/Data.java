package com.inautix;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Data {



	
	@ApiModelProperty(position = 1, required = true, value = "brief description of the property :output ")
	private List<Hotel> hotels;
	
	
	public List<Hotel>  getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> outputList) {
		this.hotels = outputList;
	}
	
	
}
