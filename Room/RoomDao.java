package com.inautix.Room;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.Customer.CustomerBean;
import com.inautix.Employee.EmployeeBean;
import com.inautix.Hotel.ConnectionManager;
public class RoomDao {

	
		public List getHoldings(String hotel_name){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT * from T_XBBNHHV_ROOM where hotel_name=?";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				 stmt.setString(1, hotel_name);	
				 resultset = stmt.executeQuery();	
				
				 holdingsList = new ArrayList<RoomBean>();
				 
				while(resultset.next()) {
					RoomBean rBean = new RoomBean();
					rBean.setHotel_name(resultset.getString(1));
					rBean.setR1(resultset.getString(2));
					rBean.setR2(resultset.getString(3));
					rBean.setR3(resultset.getString(4));
					rBean.setR4(resultset.getString(5));
					rBean.setR5(resultset.getString(6));
					
					rBean.setRoom_type(resultset.getString(7));
					rBean.setRoom_price(resultset.getInt(8));
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
		
	public List getroomPrice(String hotel_name){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT * from T_XBBNHHV_ROOM where hotel_name=?";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				 stmt.setString(1, hotel_name);	
				 resultset = stmt.executeQuery();	
				
				 holdingsList = new ArrayList<RoomBean>();
				 
				while(resultset.next()) {
					RoomBean rBean = new RoomBean();
					
					rBean.setRoom_price(resultset.getInt(8));
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
		

		public boolean insertRoom(String room_id){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			boolean isValid=false;
			int resultset = 0;
			String searchQuery = "alter table T_XBBNHHV_ROOM add "+room_id+" varchar(2) DEFAULT 'A' ";

			try {
				 stmt = conn.prepareStatement(searchQuery);
				// stmt.setString(1, hotel_name);	
//				 stmt.setString(1, room_id);	
//				
				
				 resultset=stmt.executeUpdate();
				 if(resultset!=0)
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
						
						e.printStackTrace();
					}
			}
			return isValid;
			
			
			
		}
		
public List getRooms(){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT * from T_XBBNHHV_ROOM";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				//stmt.setString(1, Room_id);		
				
				 resultset = stmt.executeQuery();	
				
				 holdingsList = new ArrayList<RoomBean>();
				 
				while(resultset.next()) {
					RoomBean rBean = new RoomBean();
					rBean.setHotel_id(resultset.getString(1));
					rBean.setRoom_id(resultset.getString(2));
					rBean.setRoom_type(resultset.getString(3));
					rBean.setRoom_price(resultset.getInt(4));
					rBean.setRoom_avail(resultset.getString(5));

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
	public List getAvailRooms(String cust_id,String hotel_id){
	
	//step 3: create statement object 
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
	List holdingsList = null;
	ResultSet resultset = null;
	String searchQuery = "SELECT * from T_XBBNHHV_ROOM where cust_id=? and hotel_id=? ";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		stmt.setString(1, hotel_id);		
		
		 resultset = stmt.executeQuery();	
//		 if(!resultset.next())
//		 {
//			// System.out.println("No available rooms");
//			 holdingsList=null;
//		 }
//		 else
//		 {
		 holdingsList = new ArrayList<RoomBean>();
		 
		while(resultset.next()) {
			RoomBean rBean = new RoomBean();
			rBean.setHotel_id(resultset.getString(1));
			rBean.setRoom_id(resultset.getString(2));
			rBean.setRoom_type(resultset.getString(3));
			rBean.setRoom_price(resultset.getInt(4));
			rBean.setRoom_avail(resultset.getString(5));
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
	public boolean validate(String hotel_id)
    {
           Connection conn = ConnectionManager.getConnection();  
           PreparedStatement stmt1 = null;
                  ResultSet rs1 = null;
                  String sql1 = "select * from  T_XBBNHHV_ROOM where hotel_id= ? and room_avail='A'";
               try 
                  {
                        stmt1 = conn.prepareStatement(sql1);
                        stmt1.setString(1,hotel_id);
                        rs1 = stmt1.executeQuery();
                                             
                         if(rs1.next())
                        {
                        	
                               return false;
                        }
                        else
                        {
                               return true;
                        }
                        
                        
                  } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return false;
                  }
                  
                  finally{
                        try {
                               if(rs1 != null)
                               rs1.close();
                               if(stmt1 != null)                               
                               stmt1.close();                           
                               conn.commit();
                               if(conn != null)
                               conn.close();
                        }                    
                        catch (SQLException e) {
                                      // TODO Auto-generated catch block
                                      e.printStackTrace();
                               }
                  }
           
    }
	

	public List getBookRooms(String hotel_id,String room_id){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		List updateList = null;
		int resultset = 0;
		ResultSet resultset1 = null;
		String updquery="update T_XBBNHHV_ROOM set room_avail='B' where hotel_id=? and room_id=?";
		String searchQuery = "SELECT * from T_XBBNHHV_ROOM  ";
		try {
			 stmt = conn.prepareStatement(updquery);
			 stmt1 = conn.prepareStatement(searchQuery);
			 stmt.setString(1, hotel_id);
				stmt.setString(2, room_id);
				
				resultset = stmt.executeUpdate();
				
				resultset1 = stmt1.executeQuery();
				
			 updateList = new ArrayList<RoomBean>();
			 
			while(resultset1.next()) {
				RoomBean rBean = new RoomBean();
				rBean.setHotel_id(resultset1.getString(1));
				rBean.setRoom_id(resultset1.getString(2));
				rBean.setRoom_type(resultset1.getString(3));
				rBean.setRoom_price(resultset1.getInt(4));
				rBean.setRoom_avail(resultset1.getString(5));
					updateList.add(rBean);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		finally{
			try {
				if(resultset1 != null)
				resultset1.close();
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
		
		return updateList;
		
	}


public List getCancelRooms(String hotel_id,String room_id){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		List updateList = null;
		int resultset = 0;
		ResultSet resultset1 = null;
		String updquery="update T_XBBNHHV_ROOM set room_avail='A' where hotel_id=? and room_id=?";
		String searchQuery = "SELECT * from T_XBBNHHV_ROOM ";
		try {
			 stmt = conn.prepareStatement(updquery);
			 stmt1 = conn.prepareStatement(searchQuery);
			 stmt.setString(1, hotel_id);
				stmt.setString(2, room_id);
				resultset = stmt.executeUpdate();
				resultset1 = stmt1.executeQuery();
				
			 updateList = new ArrayList<RoomBean>();
			 
			while(resultset1.next()) {
				RoomBean rBean = new RoomBean();
				rBean.setHotel_id(resultset1.getString(1));
				rBean.setRoom_id(resultset1.getString(2));
				rBean.setRoom_type(resultset1.getString(3));
				rBean.setRoom_price(resultset1.getInt(4));
				rBean.setRoom_avail(resultset1.getString(5));
					updateList.add(rBean);	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		finally{
			try {
				if(resultset1 != null)
				resultset1.close();
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
		
		return updateList;
		
	}
public List bookingDetails(String cust_id,String hotel_id,String room_id,String check_in,String check_out,int days)
{

	Connection conn = ConnectionManager.getConnection();         
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
     List assList = null;
    int rs = 0;
     ResultSet rs1 = null;
     String sql = "insert into T_XBBNHHV_BOOKING_DETAILS (cust_id,hotel_id,room_id,check_in,check_out,days) values (?,?,?,?,?,?)";
     String sqll = "select * from  T_XBBNHHV_BOOKING_DETAILS ";
try 
{
	
             stmt = conn.prepareStatement(sql);
             stmt1=conn.prepareStatement(sqll);
             stmt.setString(1, cust_id);		
             stmt.setString(2, hotel_id);	
             stmt.setString(3, room_id);
             stmt.setString(4,check_in);
             stmt.setString(5,check_out);
            stmt.setInt(6,days);
             rs = stmt.executeUpdate();
             rs1 = stmt1.executeQuery();
            
  assList = new ArrayList<CustomerBean>();
  
             while(rs1.next())
             {
            	 CustomerBean eBean = new CustomerBean();
                             eBean.setCust_id(rs1.getString(1));
                             eBean.setHotel_id(rs1.getString(2));
                             
                             eBean.setRoom_id(rs1.getString(3));
                             eBean.setCheck_in(rs1.getString(4));
                             eBean.setCheck_out(rs1.getString(5));
                             eBean.setDays(rs1.getInt(6));
                             assList.add(eBean);
             }
             
            
} catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}

		finally{
             try {
                             if(rs1!= null)
                             rs1.close();
                             if(stmt != null)                                                                   
                             stmt.close();                                                      
                             conn.commit();
                             if(conn != null)
                             conn.close();
             }                                              
             catch (SQLException e) 
             {
                                             // TODO Auto-generated catch block
                     e.printStackTrace();
             }
}

return assList;
}
public List bookroom(String hid,String rid,String indate,String outdate,String days){
	
	//step 3: create statement object 
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
	List holdingsList = null;
	ResultSet resultset = null;
	String searchQuery = "SELECT * from T_XBBNHHV_EMPLOYEE where admin_id=?";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		stmt.setString(1, hid);		
		stmt.setString(2, rid);
		stmt.setString(3, indate);
		stmt.setString(4, outdate);
		stmt.setString(5, days);
		
		 resultset = stmt.executeQuery();	
		
		 holdingsList = new ArrayList<EmployeeBean>();
		 
		while(resultset.next()) {
			EmployeeBean eBean = new EmployeeBean();
			eBean.setAdmin_id(resultset.getString(1));
            eBean.setEmp_id(resultset.getString(2));
            eBean.setEmp_name(resultset.getString(3));
            eBean.setEmp_pwd(resultset.getString(4));
            eBean.setEmp_designation(resultset.getString(5));
            eBean.setSalary(resultset.getInt(6));
			
				holdingsList.add(eBean);	
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
public boolean updateRoom(String hname,int price){
	
	System.out.println(hname);
	System.out.println(price);
	  Connection conn = ConnectionManager.getConnection();
      PreparedStatement stmt = null;
  
      int rs = 0;
   
      boolean isValid = false;
    
     String sql="update T_XBBNHHV_ROOM set room_price=? where hotel_name=? ";
      try 
      {
    	  	System.out.println("sss");
             stmt = conn.prepareStatement(sql);        
             
             stmt.setInt(1, price);
             stmt.setString(2, hname);
             rs = stmt.executeUpdate(); 
             System.out.println("s");
             System.out.println(rs);
             if(rs!=0)
             {
            	 System.out.println("rs:"+rs);
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

}
