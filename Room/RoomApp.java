package com.inautix.Room;


import java.util.Iterator;
import java.util.List;
public class RoomApp {

	
		public static void main(String[] args) {
		
			String Room_id = "1";
//			String Room_name = "aaa";
//			String Room_type = "ac";
//			String Room_price = "5000";
			
			RoomDao roomDao = new RoomDao();
			List<RoomBean> holdingList = roomDao.getHoldings(Room_id);
			 Iterator<RoomBean> itr =  holdingList.iterator();
			while(itr.hasNext()){
				RoomBean roBean = itr.next();
				System.out.println("HOTEL_ID\t\tROOM_ID\t\tROOM_TYPE\tROOM_PRICE\tROOM_AVAILABLE");
				System.out.println();
				System.out.println(roBean.getHotel_id()+"\t\t"+roBean.getRoom_id()+"\t\t"+roBean.getRoom_type()+"\t\t"+roBean.getRoom_price()+"\t\t"+roBean.getRoom_avail());
			}

		}

	}
