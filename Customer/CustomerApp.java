package com.inautix.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.inautix.Customer.CustomerBean;
import com.inautix.Customer.CustomerDao;
import com.inautix.Hotel.HotelBean;
import com.inautix.Hotel.HotelDao;
import com.inautix.Room.RoomBean;
import com.inautix.Room.RoomDao;

public class CustomerApp {

	public static void main(String[] args) {
		System.out.println("\t\t\t-----------------CUSTOMER-------------");
		int flag=0;
		String cust_id = "1001";
		String cust_pwd = "suve";
		Scanner ip=new Scanner(System.in);
		while(true)
		{
		System.out.println("1.View & Edit Profile \n2.Available Hotels \n3.Available rooms \n4.Booking rooms \n5.Cancelling rooms \n6.Payment \n7.Exit");
		System.out.println("Enter the choice");
		int ch=ip.nextInt();
		System.out.println();
		switch(ch)
		{
		case 2:
		{
			String admin_id="A1";
			HotelDao roomDao = new HotelDao();
			List<HotelBean> holdingList = roomDao.getHotels(admin_id);
			 Iterator<HotelBean> itr =  holdingList.iterator();
			 if(holdingList==null)
				{
					System.out.println("Sorry, No hotels are available...!!!!!!");
					break;
				}
			 else
			 {
			 System.out.println("Available hotels are....!!!!!!!");
			 System.out.println();
			 System.out.println("HOTEL_ID\tHOTEL_NAME\tLOCATION");
			 System.out.println("----------------------------------------------------");
			while(itr.hasNext()){
				HotelBean roBean = itr.next();
				System.out.println(roBean.getHotel_id()+"\t\t"+roBean.getHotel_name()+"\t   "+roBean.getLocation());
			}
			 }

			break;
		}
		case 3:
		{
			System.out.println("Enter the hotel_id:");
			String hotel_id=ip.next();
			RoomDao roomDao = new RoomDao();
						boolean res=roomDao.validate(hotel_id);
					if(res)
					{
						
						System.out.println("No rooms are available");
					}
					else
					{
			List<RoomBean> holdingList = roomDao.getAvailRooms(cust_id,hotel_id);
			System.out.println("Available rooms in the hotel are...!!!!"); 
			System.out.println();
			 System.out.println("HOTEL_ID\tROOM_ID\t\tROOM_TYPE\tROOM_PRICE\tROOM_AVAILABLE");
			System.out.println("----------------------------------------------------------------------------------------");
			 Iterator<RoomBean> itr =  holdingList.iterator();
				
			 while(itr.hasNext()){
					RoomBean roBean = itr.next();

				System.out.println(roBean.getHotel_id()+"\t\t"+roBean.getRoom_id()+"\t\t"+roBean.getRoom_type()+"\t   "+roBean.getRoom_price()+"\t\t"+roBean.getRoom_avail());
			}
			 
					}			
			 
			break;
		}
		case 1:
		{
			
		CustomerDao custDao = new CustomerDao();
		List<CustomerBean> customerList = custDao.getCustomerHoldings(cust_id,cust_pwd);
		 Iterator<CustomerBean> itr =  customerList.iterator();
		while(itr.hasNext()){
			CustomerBean custBean = itr.next();
			

			if(custBean.getCust_pwd().equals(custBean.getCust_repwd()))
			{
				 System.out.println("CUSTOMER_ID\tCUSTOMER_NAME\tPassword\tConfirm_pwd\tphone.no\tAddress");
				 System.out.println("---------------------------------------------------------------------------------------");
			System.out.println(custBean.getCust_id()+"\t\t"+ custBean.getCust_name()+"\t\t"+custBean.getCust_pwd()+"\t\t"+custBean.getCust_repwd()+"\t\t"+custBean.getCust_phno()+"\t"+custBean.getCust_address());
			}
			else
			{
				System.out.println("Invalid Password...Re-enter the Password");
			}
			}
		break;
		}
		case 4:
		{
			System.out.println("Enter the hotel_id:");
			String hotel_id=ip.next();
			System.out.println("Enter the room_id:");
			String room_id=ip.next();
		
			//SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
			System.out.println("Enter check_in date:");
			String check_in = ip.next();
			System.out.println("Enter the check_out date:");
			String check_out = ip.next();
			System.out.println("No of days are:");
			int days=ip.nextInt();
			RoomDao roomDao = new RoomDao();
			List<RoomBean> bookingList = roomDao.bookingDetails(cust_id,hotel_id,room_id,check_in,check_out,days);
			List<RoomBean> holdingList = roomDao.getBookRooms(hotel_id,room_id);
			 Iterator<RoomBean> itr3 =  holdingList.iterator();
			 System.out.println("HOTEL_ID\tROOM_ID\t\tROOM_TYPE\tROOM_PRICE\tROOM_AVAILABLE");
			 System.out.println("----------------------------------------------------------------------------------------");
			while(itr3.hasNext())
			{
				RoomBean roBean = itr3.next();
				System.out.println(roBean.getHotel_id()+"\t\t"+roBean.getRoom_id()+"\t\t"+roBean.getRoom_type()+"\t   "+roBean.getRoom_price()+"\t\t"+roBean.getRoom_avail());
			}
			System.out.println("Room id " +(String) room_id+ " is booked....");
			System.out.println();
			break;
			
		}
		case 5:
		{
			System.out.println("Enter the hotel_id:");
			String hotel_id=ip.next();
			System.out.println("Enter the room_id:");
			String room_id=ip.next();
			RoomDao roomDao = new RoomDao();
			List<RoomBean> holdingList = roomDao.getCancelRooms(hotel_id,room_id);
			 Iterator<RoomBean> itr3 =  holdingList.iterator();
			 System.out.println("HOTEL_ID\tROOM_ID\t\tROOM_TYPE\tROOM_PRICE\tROOM_AVAILABLE");
			 System.out.println("----------------------------------------------------------------");
			while(itr3.hasNext()){
				RoomBean roBean = itr3.next();
				System.out.println(roBean.getHotel_id()+"\t\t"+roBean.getRoom_id()+"\t\t"+roBean.getRoom_type()+"\t   "+roBean.getRoom_price()+"\t\t"+roBean.getRoom_avail());
			}
			System.out.println("Room id " +(String) room_id+ " is cancelled....");
				break;
			}
		case 6:
		{
			CustomerDao custDao = new CustomerDao();
			List<CustomerBean> customerList = custDao.getPay(cust_id);
			 Iterator<CustomerBean> itr =  customerList.iterator();
			 System.out.println("CUSTOMER_ID\tROOM_ID\t\tPAYMENT");
			 System.out.println("------------------------------------------------");
			while(itr.hasNext()){
				CustomerBean custBean = itr.next();
				
			System.out.println(custBean.getCust_id()+"\t\t"+custBean.getRoom_id()+"\t\t"+custBean.getAmt());
			}
			break;
		}
		case 7:
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