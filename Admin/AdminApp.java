package com.inautix.Admin;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.inautix.Employee.EmployeeBean;
import com.inautix.Employee.EmployeeDao;
public class AdminApp {

	
		public static void main(String[] args) {

			Scanner ip=new Scanner(System.in);
			System.out.println("\t\t-------------ADMIN---------------");
			int flag=0;
			while(true)
			{
				String admin_id = "A2";
			System.out.println("1.View & Edit Profile \n2.Add Employee \n3.Delete Employee \n4.View Employee Details \n5.Exit");
			System.out.println();
			System.out.println("Enter the choice");
			int ch=ip.nextInt();
			System.out.println();
			switch(ch)
			{
				case 1:
				{
				
				AdminDao adDao = new AdminDao();
				List<AdminBean> holdingList = adDao.getAdmin(admin_id);
				System.out.println("ADMIN_ID\tADMIN_PWD\tHOTEL_ID");
				System.out.println("------------------------------------------------------");
				 Iterator<AdminBean> itr =  holdingList.iterator();
				while(itr.hasNext()){
					AdminBean adBean = itr.next();
					System.out.println(adBean.getAdmin_id()+"\t\t"+adBean.getAdmin_pwd()+"\t\t"+adBean.getHotel_id());
				}
				break;
				}
				case 2:
				{
					EmployeeDao empDao = new EmployeeDao();
					
					System.out.println("Enter the employee id:");
					String emp_id=ip.next();
					System.out.println("Enter the employee name:");
					String emp_name=ip.next();
					System.out.println("Enter the employee password:");
					String emp_pwd=ip.next();
					System.out.println("Enter the employee designation:");
					String emp_designation=ip.next();
					System.out.println("Enter the employee salary:");
					int salary=ip.nextInt();
					List<EmployeeBean> assList= empDao.addEmployee(admin_id,emp_id,emp_name,emp_pwd,emp_designation,salary);
					System.out.println("Employee Added successfully!!");
					System.out.println();
					System.out.println("ADMIN_ID\tEMPLOYEE_ID\tEMPLOYEE_NAME\tEMP_PWD\tEMP_DESIGNATION\tEMP_SALARY");
					System.out.println("-------------------------------------------------------------------------------------------");

					Iterator<EmployeeBean> itr1 =  assList.iterator();
					while(itr1.hasNext()){
						EmployeeBean empBean = itr1.next();
						System.out.println(empBean.getAdmin_id()+"\t\t"+empBean.getEmp_id()+"\t\t"+empBean.getEmp_name()+"\t\t"+empBean.getEmp_pwd()+"\t\t"+empBean.getEmp_designation()+"\t\t"+empBean.getSalary());
				}
					break;
			}
				case 3:
				{
					EmployeeDao empDao = new EmployeeDao();
					System.out.println("Enter the employee id:");
					String emp_id=ip.next();
					List<EmployeeBean> delList= empDao.deleteEmployee(emp_id);
					System.out.println("Removed Successfully....Now the available employees are!!!!");
					System.out.println();
					System.out.println("ADMIN_ID\tEMPLOYEE_ID\tEMPLOYEE_NAME\tEMP_PWD\tEMP_DESIGNATION\tEMP_SALARY");
					System.out.println("--------------------------------------------------------------------------------------------");

					Iterator<EmployeeBean> itr2 =  delList.iterator();
					while(itr2.hasNext()){
						EmployeeBean empBean = itr2.next();
						System.out.println(empBean.getAdmin_id()+"\t\t"+empBean.getEmp_id()+"\t\t"+empBean.getEmp_name()+"\t\t"+empBean.getEmp_pwd()+"\t\t"+empBean.getEmp_designation()+"\t\t"+empBean.getSalary());
				}
					break;
				}
				case 4:
				{
					AdminDao empDao = new AdminDao();
					List<EmployeeBean> holdingList = empDao.getEmp(admin_id);
					System.out.println("ADMIN_ID\tEMPLOYEE_ID\tEMPLOYEE_NAME\tEMP_PWD\t\tEMP_DESIGNATION\t\tEMP_SALARY");
					System.out.println("-------------------------------------------------------------------------------------------");

					Iterator<EmployeeBean> itr1 =  holdingList.iterator();
					while(itr1.hasNext()){
						EmployeeBean empBean = itr1.next();
						System.out.println(empBean.getAdmin_id()+"\t\t"+empBean.getEmp_id()+"\t\t"+empBean.getEmp_name()+"\t\t"+empBean.getEmp_pwd()+"\t\t"+empBean.getEmp_designation()+"\t\t"+empBean.getSalary());
				}
					break;
				}
				case 5:
				{
					flag=1;
					break;
				}
				
			}
		if(flag==1)
		{
			
			break;
		}
		System.out.println();
			}
			
	}
}
