package com.inautix.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inautix.Employee.EmployeeBean;
import com.inautix.Hotel.ConnectionManager;
public class AdminDao {

	
		public List getAdmin(String Admin_id){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT * from T_XBBNHHV_ADMIN where admin_id=?";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				stmt.setString(1, Admin_id);		
				
				 resultset = stmt.executeQuery();	
				
				 holdingsList = new ArrayList<AdminBean>();
				 
				while(resultset.next()) {
					AdminBean rBean = new AdminBean();
					rBean.setAdmin_id(resultset.getString(1));
					rBean.setAdmin_pwd(resultset.getString(2));
					rBean.setHotel_id(resultset.getString(3));
					
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
		
public List getEmp(String Admin_id){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			ResultSet resultset = null;
			String searchQuery = "SELECT * from T_XBBNHHV_EMPLOYEE where admin_id=?";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				stmt.setString(1, Admin_id);		
				
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
public boolean isValid(String admin_id,String admin_pwd) throws SQLException

{
       
       Connection con = ConnectionManager.getConnection();
       PreparedStatement stmt = null;
       
              stmt = con.prepareStatement("select * from T_XBBNHHV_ADMIN where admin_id = ? AND admin_pwd= ?");
              stmt.setString(1, admin_id);
              stmt.setString(2, admin_pwd);
       
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
public boolean insertEmployee(String uname,String eid,String ename,String epwd,String edesig,String esal){
	
	//step 3: create statement object 
	  Connection conn = ConnectionManager.getConnection();
      PreparedStatement stmt = null;
      List MgrDetailsList = null;
      int rs = 0;
      boolean isValid = false;
      String sql = "insert into T_XBBNHHV_EMPLOYEE values(?,?,?,?,?,?) ";
    
      try 
      {
             stmt = conn.prepareStatement(sql);
             stmt.setString(1, uname);
             stmt.setString(2, eid);
            
             stmt.setString(3, ename);
             stmt.setString(4, epwd);
             stmt.setString(5, edesig);
             stmt.setString(6, esal);
         
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
public boolean insertEmploy(String uname,String eid,String ename,String epwd,String cpwd,String edesig,String esal){
	
	//step 3: create statement object 
	  Connection conn = ConnectionManager.getConnection();
      PreparedStatement stmt = null;
    
      int rs = 0;
      boolean isValid = false;
      String sql = "insert into T_XBBNHHV_EMPLOY values(?,?,?,?,?,?,?) ";
    
      try 
      {
             stmt = conn.prepareStatement(sql);
             stmt.setString(1, uname);
             stmt.setString(2, eid);
            
             stmt.setString(3, ename);
             stmt.setString(4, epwd);
             stmt.setString(5, cpwd);
             stmt.setString(6, edesig);
             stmt.setString(7, esal);
         
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

}


