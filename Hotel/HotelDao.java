package com.inautix.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class HotelDao {

	
		public List getHoldings(String Hotel_id){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT * from T_XBBNHHV_HOTEL where hotel_id=?";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				stmt.setString(1, Hotel_id);		
				
				 resultset = stmt.executeQuery();	
				
				 holdingsList = new ArrayList<HotelBean>();
				 
				while(resultset.next()) {
					HotelBean rBean = new HotelBean();
					rBean.setHotel_id(resultset.getString(1));
					rBean.setHotel_name(resultset.getString(2));
					rBean.setLocation(resultset.getString(3));
					
						holdingsList.add(rBean);	
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

			finally{
				try {
					if(resultset != null)
					resultset.close();
					if(stmt != null)					
					stmt.close();				
					conn.commit();
					if(conn != null)
					conn.close();
				}			
				 catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
			
			return holdingsList;
			
		}
		public boolean updateHotel(String location,String hname){
			
			
			  Connection conn = ConnectionManager.getConnection();
		      PreparedStatement stmt = null;
		  
		      int rs = 0;
		   
		      boolean isValid = false;
		    
		     String sql="update T_XBBNHHV_HOTELL set location=? where admin_id=? ";
		      try 
		      {
		    	  	
		             stmt = conn.prepareStatement(sql);        
		             
		             stmt.setString(1, location);
		             stmt.setString(2, hname);
		             rs = stmt.executeUpdate(); 
		          
		             if(rs!=0)
		             {
		            	
		                    isValid=true;
		             
		             }
		             
		             
		      } catch (SQLException e) {
		             // TODO Auto-generated catch block
		             e.printStackTrace();
		      }
		      
		      finally{
		             try {
		                    
		                    if(stmt != null)                                
		                    stmt.close();                     
		                    conn.commit();
		                    if(conn != null)
		                    conn.close();
		             }                    
		             catch (SQLException e) {
		                          // TODO Auto-generated catch block
		                          e.printStackTrace();
		                    }
		      }
		      
		      return isValid;
		}

		
		public List getHotels(String admin_id){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT hotel_id,hotel_name,location from T_XBBNHHV_HOTELL where admin_id=?";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				stmt.setString(1, admin_id);		
				
				 resultset = stmt.executeQuery();	
				
				 holdingsList = new ArrayList<HotelBean>();
				 
				while(resultset.next()) {
					HotelBean rBean = new HotelBean();
					rBean.setHotel_id(resultset.getString(1));
					rBean.setHotel_name(resultset.getString(2));
					rBean.setLocation(resultset.getString(3));
					
						holdingsList.add(rBean);	
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

			finally{
				try {
					if(resultset != null)
					resultset.close();
					if(stmt != null)					
					stmt.close();				
					conn.commit();
					if(conn != null)
					conn.close();
				}			
				 catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
			
			return holdingsList;
			
		}
		
		
}

