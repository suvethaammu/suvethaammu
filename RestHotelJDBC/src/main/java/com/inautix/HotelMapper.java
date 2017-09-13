package com.inautix;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HotelMapper implements RowMapper<Hotel> {

	public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hotel hotel=new Hotel();
		hotel.setHotelId(rs.getInt("hotelId"));
		hotel.setHotelName(rs.getString("hotelName"));
		hotel.setLocation(rs.getString("location"));
		
		return hotel;
	}

}
