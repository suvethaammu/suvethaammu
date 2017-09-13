package com.inautix;

import java.util.List;

public interface HotelDAO {

	public Hotel getHotel(int hotelId);
	public List getAllHotels();
	public void createHotel(Hotel hotel);
	public void updateHotel(Hotel hotel,int hotelId);
	public void deleteHotel(int hotelId);
}
