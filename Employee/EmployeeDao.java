package com.inautix.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.inautix.Employee.EmployeeBean;
import com.inautix.Admin.AdminBean;
import com.inautix.Hotel.ConnectionManager;
public class EmployeeDao {

	
		public List getAdmin(String Emp_id){
			
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
		public List addEmployee(String admin_id,String emp_id,String emp_name,String emp_pwd,String emp_designation,int salary)
        {

			Connection conn = ConnectionManager.getConnection();         
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
             List assList = null;
             int rs = 0;
             ResultSet rs1 = null;
             String sql = "insert into T_XBBNHHV_EMPLOYEE (admin_id,emp_id,emp_name,emp_pwd,emp_designation,salary) values (?,?,?,?,?,?)";
             String sqll = "select * from  T_XBBNHHV_EMPLOYEE ";
     try 
     {
    		
                     stmt = conn.prepareStatement(sql);
                     stmt1=conn.prepareStatement(sqll);
                     stmt.setString(1, admin_id);		
         			
                     stmt.setString(2, emp_id);
                     stmt.setString(3,emp_name);
                     stmt.setString(4,emp_pwd);
                     stmt.setString(5,emp_designation);
                     stmt.setInt(6,salary);
                     
                     rs = stmt.executeUpdate();
                     rs1 = stmt1.executeQuery();
                    
          assList = new ArrayList<EmployeeBean>();
          
                     while(rs1.next())
                     {
                                     EmployeeBean eBean = new EmployeeBean();
                                     eBean.setAdmin_id(rs1.getString(1));
                                     eBean.setEmp_id(rs1.getString(2));
                                     eBean.setEmp_name(rs1.getString(3));
                                     eBean.setEmp_pwd(rs1.getString(4));
                                     eBean.setEmp_designation(rs1.getString(5));
                                     eBean.setSalary(rs1.getInt(6));
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
		public List deleteEmployee(String emp_id)
        {

			Connection conn = ConnectionManager.getConnection();         
			PreparedStatement stmt = null;
			PreparedStatement stmt1 = null;
             List delList = null;
             int rs = 0;
             ResultSet rs1 = null;
             String sql = "delete from T_XBBNHHV_EMPLOYEE where emp_id=? and admin_id=?";
             String sqll = "select * from  T_XBBNHHV_EMPLOYEE ";
     try 
     {
    		
                     stmt = conn.prepareStatement(sql);
                     stmt1=conn.prepareStatement(sqll);
                     //stmt.setString(1, admin_id);		
         			
                     stmt.setString(1, emp_id);
//                     stmt.setString(3,emp_name);
//                     stmt.setString(4,emp_pwd);
//                     stmt.setString(5,emp_designation);
//                     stmt.setInt(6,salary);
                     
                     rs = stmt.executeUpdate();
                     rs1 = stmt1.executeQuery();
                    
          delList = new ArrayList<EmployeeBean>();
          
                     while(rs1.next())
                    	 
                    	
                     {
                                     EmployeeBean eBean = new EmployeeBean();
                                     eBean.setAdmin_id(rs1.getString(1));
                                     eBean.setEmp_id(rs1.getString(2));
                                     eBean.setEmp_name(rs1.getString(3));
                                     eBean.setEmp_pwd(rs1.getString(4));
                                     eBean.setEmp_designation(rs1.getString(5));
                                     eBean.setSalary(rs1.getInt(6));
                                     delList.add(eBean);
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
     
     return delList;
        }
public List viewEmp(String admin_id){
			
			//step 3: create statement object 
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			List holdingsList = null;
			 int rs = 0;
             boolean isValid = false;
			ResultSet rs1 = null;
			String searchQuery = "SELECT * from T_XBBNHHV_EMPLOYEE where admin_id=? ";
			try {
				 stmt = conn.prepareStatement(searchQuery);
				 stmt.setString(1, admin_id);
				 rs1 = stmt.executeQuery();	
				
				 holdingsList = new ArrayList<AdminBean>();
				 if(rs!=0)
		          {
		         	
		                 isValid=true;
		          
		          }
		               
				while(rs1.next()) {
					EmployeeBean eBean = new EmployeeBean();
					  eBean.setAdmin_id(rs1.getString(1));
                      eBean.setEmp_id(rs1.getString(2));
                      eBean.setEmp_name(rs1.getString(3));
                      eBean.setEmp_pwd(rs1.getString(4));
                      eBean.setEmp_designation(rs1.getString(5));
                      eBean.setSalary(rs1.getInt(6));
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
public List viewEmploy(String mgr_id){
	
	//step 3: create statement object 
	Connection conn = ConnectionManager.getConnection();
	PreparedStatement stmt = null;
	List holdingsList = null;
	 int rs = 0;
     boolean isValid = false;
	ResultSet rs1 = null;
	String searchQuery = "SELECT * from T_XBBNHHV_EMPLOY where mgr_id=? ";
	try {
		 stmt = conn.prepareStatement(searchQuery);
		 stmt.setString(1, mgr_id);
		 rs1 = stmt.executeQuery();	
		
		 holdingsList = new ArrayList<AdminBean>();
		 if(rs!=0)
          {
         	
                 isValid=true;
          
          }
               
		while(rs1.next()) {
			EmployeeBean eBean = new EmployeeBean();
			  eBean.setMgr_id(rs1.getString(1));
              eBean.setEmp_id(rs1.getString(2));
              eBean.setEmp_name(rs1.getString(3));
              eBean.setEmp_pwd(rs1.getString(4));
              eBean.setEmp_cpwd(rs1.getString(5));
              eBean.setEmp_designation(rs1.getString(6));
              eBean.setSalary(rs1.getInt(7));
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
		public boolean delEmployee(String admin_id,String emp_id)
        {

			Connection conn = ConnectionManager.getConnection();         
			PreparedStatement stmt = null;
             List delList = null;
             int rs = 0;
             boolean isValid = false;
             ResultSet rs1 = null;
             String sql = "delete from T_XBBNHHV_EMPLOYEE where admin_id=? and emp_id=?";
           
     try 
     {
    		
                     stmt = conn.prepareStatement(sql);
                     stmt.setString(1, admin_id);
                     stmt.setString(2, emp_id);
                     rs = stmt.executeUpdate();
                    
          if(rs==0)
          {
         	
                 isValid=true;
          
          }
               
                    
     } catch (SQLException e) {
                  
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
                             e.printStackTrace();
                     }
     }
     
     return isValid;
        }
		
		public boolean delEmploy(String mgr_id,String emp_id)
        {

			Connection conn = ConnectionManager.getConnection();         
			PreparedStatement stmt = null;
             List delList = null;
             int rs = 0;
             boolean isValid = false;
             ResultSet rs1 = null;
             String sql = "delete from T_XBBNHHV_EMPLOY where mgr_id=? and emp_id=?";
           
     try 
     {
    		
                     stmt = conn.prepareStatement(sql);
                     stmt.setString(1, mgr_id);
                     stmt.setString(2, emp_id);
                     rs = stmt.executeUpdate();
                    
          if(rs==0)
          {
         	
                 isValid=true;
          
          }
               
                    
     } catch (SQLException e) {
                  
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
                             e.printStackTrace();
                     }
     }
     
     return isValid;
        }
		
}
		