package com.inautix.Manager;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.inautix.Customer.CustomerBean;
import com.inautix.Customer.CustomerDao;
import com.inautix.Employee.EmployeeBean;
import com.inautix.Employee.EmployeeDao;
import com.inautix.Room.RoomBean;
import com.inautix.Room.RoomDao;


public class ManagerApp 
{
	public static void main(String[] args) {
	Scanner ip=new Scanner(System.in);
	System.out.println("\t\t-------------MANAGER---------------");
	int flag=0;
	while(true)
	{
	String emp_id = "E1";
	System.out.println("1.View & Edit profile \n2.Booking Details \n3.Bill \n4.Exit");
	System.out.println();
	System.out.println("Enter the choice");
	int ch=ip.nextInt();
	int amt=0;
	System.out.println();
	switch(ch)
	{
		case 1:
		{
			ManagerDao empDao=new ManagerDao();
			List<EmployeeBean> assList= empDao.viewManagerDetail(emp_id);
			
			System.out.println("ADMIN_ID\tEMPLOYEE_ID\tEMPLOYEE_NAME\tEMP_PWD\tEMP_DESIGNATION\tEMP_SALARY");
			System.out.println("-------------------------------------------------------------------------------------------");

			Iterator<EmployeeBean> itr1 =  assList.iterator();
			while(itr1.hasNext()){
				EmployeeBean empBean = itr1.next();
				System.out.println(empBean.getAdmin_id()+"\t\t"+empBean.getEmp_id()+"\t\t"+empBean.getEmp_name()+"\t\t"+empBean.getEmp_pwd()+"\t\t"+empBean.getEmp_designation()+"\t\t"+empBean.getSalary());
		}
			break;
		}
		
	
		
		case 2:
		{
			System.out.println("Enter the room_id:");
			String room_id=ip.next();
			ManagerDao mDao = new ManagerDao();
			List<CustomerBean> holdingList =mDao.bookedDetails(room_id);
			 Iterator<CustomerBean> itr3 =  holdingList.iterator();
			 System.out.println("CUSTOMER_ID\t\tHOTEL_ID\t\tROOM_ID\t\tCHECK_IN_DATE\t\tCHECK_OUT_DATE\t\tNO.OF.DAYS");
			 System.out.println("----------------------------------------------------------------");
			while(itr3.hasNext()){
				CustomerBean roBean = itr3.next();
				System.out.println(roBean.getCust_id()+"\t\t\t"+roBean.getHotel_id()+"\t\t\t  "+roBean.getRoom_id()+"\t\t"+roBean.getCheck_in()+"\t\t"+roBean.getCheck_out()+"\t\t"+roBean.getDays());
			}
		
		
			break;
		}
		
		case 3:
		{
			System.out.println("Enter the Customer_id:");
			String cust_id=ip.next();
			System.out.println("Enter the Room_id:");
			String room_id=ip.next();
			CustomerDao mDao = new CustomerDao();
			List<CustomerBean> holdingList =mDao.getPayment(cust_id);
			 Iterator<CustomerBean> itr3 =  holdingList.iterator();
			 System.out.println();
//			 System.out.println("CUSTOMER_ID\t\tHOTEL_ID\t\tROOM_ID\t\tAMOUNT");
//			 System.out.println("----------------------------------------------------------------");
			while(itr3.hasNext()){
				CustomerBean cuBean = itr3.next();
				System.out.println("Amount to be paid by the customer with customer_id " +cust_id+" is....");
				System.out.println(cuBean.getAmount());
				amt=cuBean.getAmount();
				mDao.getBill(cust_id,room_id,amt);
			}
			
		
			break;
		}
		case 4:
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
