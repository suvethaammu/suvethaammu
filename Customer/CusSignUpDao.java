package com.inautix.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.inautix.Hotel.ConnectionManager;
public class CusSignUpDao {


Connection con = ConnectionManager.getConnection(); 
PreparedStatement ps = null;
CustomerBean b=new CustomerBean();
private int result;
	public int insertuserdetails(CustomerBean b2) throws SQLException {
		
		PreparedStatement ps=con.prepareStatement("insert into  T_XBBNHHV_CUSTOMER_DETAILS(cust_id ,cust_name,cust_pwd,cust_repwd,cust_phno,cust_address) values(?,?,?,?,?,?)");
		ps.setString(1,b2.getCust_id());
		ps.setString(2,b2.getCust_name());
		ps.setString(3,b2.getCust_pwd());
		ps.setString(4,b2.getCust_repwd());
		ps.setString(5,b2.getCust_phno());
		ps.setString(6,b2.getCust_address());
		result=ps.executeUpdate();
		System.out.println(result);
		return result;
		
		
	}
     
}
