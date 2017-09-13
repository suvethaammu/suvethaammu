package com.inautix;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class HotelJDBCTemplate implements HotelDAO {

	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject=new JdbcTemplate(dataSource);
	}
	public Hotel getHotel(int hotelId) 
	{
		Hotel hotel=null;
		try{
		String SQL="select * from XBBNHHV_HOTEL where hotelId=?";
		 hotel=jdbcTemplateObject.queryForObject(SQL,new Object[]{hotelId},new HotelMapper());
		}
		catch(EmptyResultDataAccessException e)
		{
			System.out.println(e);
		}
		
		return hotel;
		
	}
	
	public List getAllHotels() {
		List hotelList=null;
		String SQL="select * from XBBNHHV_HOTEL";
		hotelList=jdbcTemplateObject.query(SQL,new Object[]{},new HotelMapper());
		return hotelList;
	}
	public void createHotel(Hotel hotel) 
	{
		String insertSQL="insert into XBBNHHV_HOTEL values ("+hotel.getHotelId()+",'"+hotel.getHotelName()+"','"+hotel.getLocation()+"')";
		jdbcTemplateObject.update(insertSQL);
		
	}
	public void updateHotel(Hotel hotel,int hotelId) {
		
		String updateSQL="update XBBNHHV_HOTEL set hotelId="+hotel.getHotelId()+",hotelName='"+hotel.getHotelName()+"',location='"+hotel.getLocation()+"' where hotelId="+hotelId;
		jdbcTemplateObject.update(updateSQL);
	}
	public void deleteHotel(int hotelId) {
		String deleteSQL="delete from XBBNHHV_HOTEL where hotelId="+hotelId;
		jdbcTemplateObject.update(deleteSQL);
		
	}

}

