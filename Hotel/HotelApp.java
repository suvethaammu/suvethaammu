package com.inautix.Hotel;
import java.util.Iterator;
import java.util.List;
public class HotelApp {

	
		public static void main(String[] args) {
		
			String Hotel_id = "102";

			
			HotelDao roomDao = new HotelDao();
			List<HotelBean> holdingList = roomDao.getHoldings(Hotel_id);
			 Iterator<HotelBean> itr =  holdingList.iterator();
			while(itr.hasNext()){
				HotelBean roBean = itr.next();
				System.out.println("HOTEL_ID\tHOTEL_NAME\tLOCATION");
				System.out.println();
				System.out.println(roBean.getHotel_id()+"\t\t"+roBean.getHotel_name()+"\t"+roBean.getLocation());
			}

		}

	}
