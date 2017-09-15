package com.inautix.Employee;

import java.util.Iterator;
import java.util.List;



public class EmployeeApp {
	public static void main(String[] args) {
	String emp_id="E2";
	EmployeeDao empDao = new EmployeeDao();
	List<EmployeeBean> holdingList = empDao.getAdmin(emp_id);
	System.out.println("ADMIN_ID\tEMPLOYEE_ID\tEMPLOYEE_NAME\tEMP_PWD\t\tEMP_DESIGNATION\t\tEMP_SALARY");
	System.out.println("-------------------------------------------------------------------------------------------");

	Iterator<EmployeeBean> itr1 =  holdingList.iterator();
	while(itr1.hasNext()){
		EmployeeBean empBean = itr1.next();
		System.out.println(empBean.getAdmin_id()+"\t\t"+empBean.getEmp_id()+"\t\t"+empBean.getEmp_name()+"\t\t"+empBean.getEmp_pwd()+"\t\t"+empBean.getEmp_designation()+"\t\t"+empBean.getSalary());
}
	
}
}

