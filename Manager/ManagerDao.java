package com.inautix.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inautix.Customer.CustomerBean;
import com.inautix.Employee.EmployeeBean;
import com.inautix.Hotel.ConnectionManager;

public class ManagerDao {
	public List viewManagerDetail(String Emp_id){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List holdingsList = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from T_XBBNHHV_EMPLOYEE where emp_id=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, Emp_id);		
			
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
	
public List bookedDetails(String hname){
		
		//step 3: create statement object 
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		List holdingsList = null;
		ResultSet rs1 = null;
		String searchQuery = "SELECT b.cust_id,b.hotel_name,b.room_id,b.check_in,b.check_out,b.persons,h.room_price from T_XBBNHHV_BOOKING_DETAILS b,T_XBBNHHV_ROOM h where b.hotel_name=?";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, hname);		
			
			 rs1 = stmt.executeQuery();	
			
			 holdingsList = new ArrayList<CustomerBean>();
			 
			while(rs1.next()) {
				CustomerBean eBean = new CustomerBean();
				eBean.setCust_id(rs1.getString(1));
                eBean.setHotel_name(rs1.getString(2));
                eBean.setRoom_id(rs1.getString(3));
                eBean.setCheck_in(rs1.getString(4));
                eBean.setCheck_out(rs1.getString(5));
                eBean.setDays(rs1.getInt(6));
                eBean.setAmount(rs1.getInt(7));
					holdingsList.add(eBean);	
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
			 catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		
		return holdingsList;
		
	}
	
public boolean isValid(String hname,String uname,String pwd) throws SQLException

{
       
       Connection con = ConnectionManager.getConnection();
       PreparedStatement stmt = null;
       
              stmt = con.prepareStatement("select * from  T_XBBNHHV_hotel where hotel_name=? AND emp_id = ? AND emp_pwd= ?") ;
              stmt.setString(1, hname);
              stmt.setString(2, uname);
              stmt.setString(3, pwd);
       
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
	
}
