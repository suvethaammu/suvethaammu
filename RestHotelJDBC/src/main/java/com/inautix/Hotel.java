package com.inautix;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;
@SuppressWarnings("restriction")
@XmlRootElement(name="Hotel")
@ApiModel
public class Hotel {
	@ApiModelProperty(position = 1, required = true, value = "id containing only  numbers")
	private int hotelId;
	@ApiModelProperty(position = 1, required = true, value = "name containing only letters ")
	   private String hotelName;
	@ApiModelProperty(position = 1, required = true, value = "location containing only letters")
	   private String location;
	
public int getHotelId() {
	return hotelId;
}
public void setHotelId(int hotelId) {
	this.hotelId = hotelId;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

}
