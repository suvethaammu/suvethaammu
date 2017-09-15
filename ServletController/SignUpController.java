package com.inautix.ServletController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inautix.Admin.AdminDao;
import com.inautix.Customer.CusSignUpDao;
import com.inautix.Customer.CustomerBean;
import com.inautix.Employee.EmployeeBean;
import com.inautix.Employee.EmployeeDao;

@RestController
@RequestMapping(value = "/userdetails")
public class SignUpController {
	CusSignUpDao ud=new CusSignUpDao();
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	public int   userdetails(@RequestBody CustomerBean b) throws SQLException 
	{
		
		int d=0;
		d=ud.insertuserdetails(b);
		return d;
	
	}
	
	 @RequestMapping(value = "/all/{admin_id}"  , method = RequestMethod.GET )
	  public List<EmployeeBean> viewEmploy(@PathVariable ("admin_id") String admin_id) {
 	
		ArrayList<EmployeeBean> list1 = new ArrayList<EmployeeBean>();  
		AdminDao bdao=new AdminDao();
     list1= (ArrayList<EmployeeBean>) bdao.getEmp(admin_id);
     return list1;
   }
		
	
}

