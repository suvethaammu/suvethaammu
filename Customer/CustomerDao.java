package com.inautix.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inautix.Hotel.ConnectionManager;
import com.inautix.Customer.CustomerBean;
import com.inautix.Employee.EmployeeBean;

public class CustomerDao {

	public List getCustomerHoldings(String Cust_id,String cust_pwd){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List customerList = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from T_XBBNHHV_CUSTOMER_DETAILS where cust_id=? and cust_pwd=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, Cust_id);		
			stmt.setString(2, cust_pwd);		
			 resultset = stmt.executeQuery();	
			 customerList = new ArrayList<CustomerBean>();
			 
			while(resultset.next()) {
				CustomerBean custBean = new CustomerBean();
				custBean.setCust_id(resultset.getString(1));
				custBean.setCust_name(resultset.getString(2));
				custBean.setCust_pwd(resultset.getString(3));
				custBean.setCust_repwd(resultset.getString(4));
				custBean.setCust_phno(resultset.getString(5));
				custBean.setCust_address(resultset.getString(6));
				//custBean.setRoom_id(resultset.getString(7));
				//stockBean.setStockName(resultset.getString(2));
			
					customerList.add(custBean);	
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
		
		return customerList;
		
	}

public List getCustomer(String uname){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List customerList = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from T_XBBNHHV_CUSTOMER_DETAILS where cust_name=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
		stmt.setString(1, uname);
			 resultset = stmt.executeQuery();	
			 customerList = new ArrayList<CustomerBean>();
			 
			while(resultset.next()) {
				CustomerBean custBean = new CustomerBean();
				custBean.setCust_id(resultset.getString(1));
				custBean.setCust_name(resultset.getString(2));
				custBean.setCust_pwd(resultset.getString(3));
				custBean.setCust_repwd(resultset.getString(4));
				custBean.setCust_phno(resultset.getString(5));
				custBean.setCust_address(resultset.getString(6));
				//custBean.setRoom_id(resultset.getString(7));
				//stockBean.setStockName(resultset.getString(2));
			
					customerList.add(custBean);	
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
		
		return customerList;
		
	}

	
	
	
	public List getPayment(String Cust_id){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List customerList = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT b.days,r.room_price from T_XBBNHHV_BOOKING_DETAILS b,T_XBBNHHV_ROOM r where b.room_id=r.room_id and b.cust_id=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, Cust_id);		
			 resultset = stmt.executeQuery();	
			 customerList = new ArrayList<CustomerBean>();
			 
			while(resultset.next()) {
				CustomerBean custBean = new CustomerBean();
				int days=resultset.getInt(1);
				int price=resultset.getInt(2);
				int amt=days*price;
			    custBean.setAmount(amt);
				customerList.add(custBean);	
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
		
		return customerList;
		
	}
	public boolean updateAddress(String uname,String name){
		
		
		  Connection conn = ConnectionManager.getConnection();
	      PreparedStatement stmt = null;
	  
	      int rs = 0;
	   
	      boolean isValid = false;
	    
	     String sql="update T_XBBNHHV_CUSTOMER_DETAILS set cust_address=? where cust_name=?";
	      try 
	      {
	    	  	
	             stmt = conn.prepareStatement(sql);        
	             
	             stmt.setString(1, name);
	             stmt.setString(2, uname);
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
	public boolean updatephno(String uname,String name){
		
		
		  Connection conn = ConnectionManager.getConnection();
	      PreparedStatement stmt = null;
	  
	      int rs = 0;
	   
	      boolean isValid = false;
	    
	     String sql="update T_XBBNHHV_CUSTOMER_DETAILS set cust_phno=? where cust_name=?";
	      try 
	      {
	    	  	
	             stmt = conn.prepareStatement(sql);        
	             
	             stmt.setString(1, name);
	             stmt.setString(2, uname);
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


public List getPaymenttype(String Cust_id){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List customerList = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from ";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, Cust_id);		
			 resultset = stmt.executeQuery();	
			 customerList = new ArrayList<CustomerBean>();
			 
			while(resultset.next()) {
				CustomerBean custBean = new CustomerBean();
				int days=resultset.getInt(1);
				int price=resultset.getInt(2);
				int amt=days*price;
			    custBean.setAmount(amt);
				customerList.add(custBean);	
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
		
		return customerList;
		
	}
public List getBill(String cust_id,String room_id,int amt)
{

	Connection conn = ConnectionManager.getConnection();         
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
     List assList = null;
     int rs = 0;
     ResultSet rs1 = null;
     String sql = "insert into T_XBBNHHV_BILL (cust_id,room_id,amt) values (?,?,?)";
     String sqll = "select * from  T_XBBNHHV_BILL ";
try 
{
	
             stmt = conn.prepareStatement(sql);
             stmt1=conn.prepareStatement(sqll);
             stmt.setString(1, cust_id);	
             stmt.setString(2, room_id);	
             stmt.setInt(3,amt);
             
             rs = stmt.executeUpdate();
             rs1 = stmt1.executeQuery();
            
  assList = new ArrayList<EmployeeBean>();
  
             while(rs1.next())
             {
                             CustomerBean eBean = new CustomerBean();
                             eBean.setCust_id(rs1.getString(1));
                             eBean.setRoom_id(rs1.getString(2));
                             eBean.setAmt(rs1.getInt(2));
                             assList.add(eBean);
             }
             
            
} catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}

		finally{
             try {
                             if(rs1 != null)
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
public List getPay(String cust_id)
{

	Connection conn = ConnectionManager.getConnection();         
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
     List assList = null;
     int rs = 0;
     ResultSet rs1 = null;
   
     String sqll = "select * from  T_XBBNHHV_BILL where cust_id=?";
try 
{
	
             //stmt = conn.prepareStatement(sql);
             stmt1=conn.prepareStatement(sqll);
             stmt1.setString(1, cust_id);		
            // stmt.setInt(2,amt);
             
             //rs = stmt.executeUpdate();
             rs1 = stmt1.executeQuery();
            
  assList = new ArrayList<EmployeeBean>();
  
             while(rs1.next())
             {
                             CustomerBean eBean = new CustomerBean();
                             eBean.setCust_id(rs1.getString(1));
                             eBean.setRoom_id(rs1.getString(2));
                             eBean.setAmt(rs1.getInt(3));
                             assList.add(eBean);
             }
             
            
} catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
}

		finally{
             try {
                             if(rs1 != null)
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

public boolean isValid(String uname,String pwd) throws SQLException

{
       
       Connection con = ConnectionManager.getConnection();
       PreparedStatement stmt = null;
       
              stmt = con.prepareStatement("select * from T_XBBNHHV_CUSTOMER_DETAILS where cust_name = ? AND cust_pwd= ?");
              stmt.setString(1, uname);
              stmt.setString(2, pwd);
       
       boolean isValid = false;
       ResultSet rs = null;
       
       rs = stmt.executeQuery();
              
       while(rs.next())
       {
              isValid = true;
       }
       con.close();
       return isValid;
       
}	


public boolean viewProfile(String uname) throws SQLException

{
       
       Connection con = ConnectionManager.getConnection();
       PreparedStatement stmt = null;
       
              stmt = con.prepareStatement("select * from T_XBBNHHV_CUSTOMER_DETAILS where cust_name = ?");
              stmt.setString(1, uname);
             
       
       boolean isValid = false;
       ResultSet rs = null;
       
       rs = stmt.executeQuery();
              
       while(rs.next())
       {
              isValid = true;
       }
       con.close();
       return isValid;
       
}	
public boolean signUpisValid(String uid, String uname,String pwd, String cpwd, String phno,String addr) 
{
       Connection conn = ConnectionManager.getConnection();
       PreparedStatement stmt = null;
       List MgrDetailsList = null;
       int rs = 0;
       boolean isValid = false;

       String sql = "insert into T_XBBNHHV_CUSTOMER_DETAILS values(?,?,?,?,?,?) ";
       try 
       {
              stmt = conn.prepareStatement(sql);
              stmt.setString(1, uid);
              stmt.setString(2, uname);
             
              stmt.setString(3, pwd);
              stmt.setString(4, cpwd);
              stmt.setString(5, phno);
              stmt.setString(6, addr);

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
public boolean checkRoom(String hname,String rid){
	
	
	//step 3: create statement object 
	  Connection conn = ConnectionManager.getConnection();
      PreparedStatement stmt1 = null;
     // PreparedStatement stmt1 = null;
//      List MgrDetailsList = null;
     ResultSet rs = null;
      int rs1=0;
      boolean isValid = false;
     
     String updquery="select * from T_XBBNHHV_ROOM where "+rid+"='A' and hotel_name=?";
      try 
      {
             
           stmt1 = conn.prepareStatement(updquery);
           stmt1.setString(1, hname);
           
             rs = stmt1.executeQuery(); 
           
           
             if(rs.next())
             {
            	
                    isValid=true;
             
             }
             
             
      } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
      }
      
      finally{
             try {
                    
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
      
      return isValid;
}
public boolean bookRoom(String uname,String hname,String rid,String indate,String outdate,String days){
	
	//step 3: create statement object 
	  Connection conn = ConnectionManager.getConnection();
      PreparedStatement stmt = null;
      PreparedStatement stmt1 = null;
//      List MgrDetailsList = null;
      int rs = 0;
      int rs1=0;
      boolean isValid = false;
      String sql = "insert into T_XBBNHHV_BOOKING_DETAILS values(?,?,?,?,?,?) ";
      System.out.println(rid);
     String updquery="update T_XBBNHHV_ROOM set " + rid + "='B' where hotel_name=?";
      try 
      {
             stmt = conn.prepareStatement(sql);
           stmt1 = conn.prepareStatement(updquery);
             stmt.setString(1, uname);
             stmt.setString(2, hname);
            
             stmt.setString(3, rid);
             stmt.setString(4, indate);
             stmt.setString(5, outdate);
             stmt.setString(6, days);
            // stmt.setInt(7, amnt);
             stmt1.setString(1, hname);
          
             rs = stmt.executeUpdate(); 
            rs1=stmt1.executeUpdate();
            if(rs1!=0)
            {
            System.out.println(rs1);
            }
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


public boolean cancelRoom(String uname,String hname,String rid){
	
	//step 3: create statement object 
	  Connection conn = ConnectionManager.getConnection();
      PreparedStatement stmt = null;
      PreparedStatement stmt1 = null;
//      List MgrDetailsList = null;
      int rs = 0;
      int rs1=0;
      boolean isValid = false;
      //String sql = "insert into T_XBBNHHV_BOOKING_DETAILS values(?,?,?,?,?,?) ";
      //System.out.println(rid);
     String updquery="update T_XBBNHHV_ROOM set " + rid + "='A' where hotel_name=?";
     String del="delete from T_XBBNHHV_BOOKING_DETAILS where cust_id=? and hotel_name=? and room_id=?";
      try 
      {
           
           stmt = conn.prepareStatement(updquery);
           stmt1 = conn.prepareStatement(del);
             stmt.setString(1, hname);
            stmt1.setString(1, uname);
            
             stmt1.setString(2, hname);
             stmt1.setString(3, rid);
//             stmt.setString(5, outdate);
//             stmt.setString(6, days);
             
         //    stmt.setString(3, rid);
          
             rs = stmt.executeUpdate(); 
             rs1 = stmt1.executeUpdate(); 
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
}