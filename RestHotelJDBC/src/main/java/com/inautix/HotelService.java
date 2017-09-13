package com.inautix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;





@Configuration
@EnableSwagger2

@Controller
public class HotelService {

	@Autowired
	MetaData metaData;

	@Autowired
	Data data;

	@Autowired
	Response response;

	@Autowired
	ErrorDetails errorDetails;

	@Autowired
	HotelJDBCTemplate hotelDAOImpl;

	//Getting particular hotel...
	
	@ApiParam(value = "objects that need to be invoked", required = true)
	@ApiOperation(value = "retrieve a student record using GET method", notes = "Returns the student data with hotel id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful Response", response = Hotel.class),
			@ApiResponse(code = 404, message = "Invalid Information Sent", response = Hotel.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Hotel.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Hotel.class)

	})
	@RequestMapping(value = "hotels/{hotelId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> getHotel(@PathVariable("hotelId") int hotelId) {

		List<Hotel> hotelList = new ArrayList<Hotel>();

		Hotel hotel = new Hotel();
		ResponseEntity<Object> responseEntity = null;
		hotel = hotelDAOImpl.getHotel(hotelId);
		if (hotel != null) {

			hotelList.add(hotel);

			saveMetaData(true, "hotel details", "12345");
			saveData(null, hotelList);
			saveResponse(data, metaData, null);

			responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
		} else {

			saveMetaData(false, "Not found", "12345");
			errorDetails.setCode("TRA2001");
			errorDetails.setDescription("Hotel id not found");

			saveResponse(null, metaData, errorDetails);

			responseEntity = new ResponseEntity<Object>(response,
					HttpStatus.NOT_FOUND);

		}
		return responseEntity;

	}
	
	
	//Getting all the hotels....

	@ApiOperation(value = "retrieve all hotel records using GET method", notes = "Returns the list of hotel data ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful Response", response = Hotel.class),
			@ApiResponse(code = 404, message = "Invalid Information Sent", response = Hotel.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Hotel.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Hotel.class)

	})
	@RequestMapping(value = "/hotels", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> getAllHotels() {
		List<Hotel> hotelList = new ArrayList<Hotel>();

		ResponseEntity<Object> responseEntity = null;

		hotelList = hotelDAOImpl.getAllHotels();
		if (hotelList.isEmpty()) {

			saveMetaData(false, "Not found", "12345");
			errorDetails.setCode("TRA2001");
			errorDetails.setDescription("Hotel records not found");
			saveResponse(null, metaData, errorDetails);

			responseEntity = new ResponseEntity<Object>(response,
					HttpStatus.NOT_FOUND);
		} else {
			saveMetaData(true, "hotel details", "12345");
			saveData(null, hotelList);
			saveResponse(data, metaData, null);

			responseEntity = new ResponseEntity<Object>(response, HttpStatus.OK);
		}
		return responseEntity;
	}

	
	//Creating a particular hotel....
	
	@ApiParam(value = "single record to be inserted", required = true)
	@ApiOperation(value = "Save a hotel record using POST method", notes = "Create hotel data ")
	@ApiResponses(value = {
			@ApiResponse(code = 404, message = "Invalid Information Sent", response = Hotel.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Hotel.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Hotel.class),
			@ApiResponse(code = 201, message = "Created Response", response = Hotel.class) })
	@RequestMapping(value = "/hotels", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public  ResponseEntity<Object> createHotel(@RequestBody Hotel hotel) {
		Hotel hotelbean=null;
		List<Hotel> hotelList = new ArrayList<Hotel>();

		ResponseEntity<Object> responseEntity = null;
		hotelbean = hotelDAOImpl.getHotel(hotel.getHotelId());
		if (hotelbean != null) {

			errorDetails.setCode("TRA2002");
			errorDetails.setDescription("Hotel already exist");
			saveMetaData(false, "Error Occured", "TRA2002");
			saveResponse(null, metaData, errorDetails);

			responseEntity = new ResponseEntity<Object>(response,
					HttpStatus.CONFLICT);

		} else {

			hotelDAOImpl.createHotel(hotel);

			hotelList.add(hotel);
			saveMetaData(true, "Hotel Created", "14563");
			saveData(null, hotelList);
			saveResponse(data, metaData, null);
			responseEntity = new ResponseEntity<Object>(response,
					HttpStatus.CREATED);

		}
		return responseEntity;
	}

	
	//Updating the particular hotel....
	
	@ApiParam(value = "object that need to be updated by using one id", required = true)
	@ApiOperation(value = "Update a hotel record using PUT method",notes = "Update the hotel data with hotel id")
	@ApiResponses(value = { 
	@ApiResponse(code = 200, message = "Successful Response",response = Hotel.class ),  
	@ApiResponse(code = 404, message = "Invalid Information Sent",response = Hotel.class), 
	@ApiResponse(code = 500, message = "Internal Server Error",response = Hotel.class),
	@ApiResponse(code = 400, message = "Bad Request",response = Hotel.class)
	})
	@RequestMapping(value = "/hotels/{hotelId}", method = RequestMethod.PUT,produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> updateHotel(@PathVariable("hotelId") int hotelId,
			@RequestBody Hotel hotel) {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		ResponseEntity<Object> responseEntity=null;
		Hotel hotelbean=null;
		
		hotelbean = hotelDAOImpl.getHotel(hotelId);
		
		if(hotelbean!=null){
			hotelDAOImpl.updateHotel(hotel, hotelId);
			
			hotelList.add(hotel);
			
			saveMetaData(true,"Hotel updated details","14563");
			saveData(null, hotelList);
			saveResponse(data,metaData, null);
			
			responseEntity= new  ResponseEntity<Object>(response,HttpStatus.OK);
			
			}
			else{
				
				errorDetails.setCode("TRA2003");
				errorDetails.setDescription("hotel id not found");
				saveMetaData(false,"Error Occured","TRA2003");
				saveResponse(null,metaData, errorDetails);
				
				
				responseEntity= new  ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
				
			}
			return responseEntity;
		}
	
	
	
	
	//Deleting the particular hotel...
	@ApiParam(value = "object that need to be deleted by using one id", required = true)
	@ApiOperation(value = "Delete a hotel record using GET method",notes = "Delete the hotel data with hotel id")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Successful Response",response = Hotel.class ),
	@ApiResponse(code = 404, message = "Invalid Information Sent",response = Hotel.class),
	@ApiResponse(code = 500, message = "Internal Server Error",response = Hotel.class),
	@ApiResponse(code = 400, message = "Bad Request",response = Hotel.class)
	
	})
	@RequestMapping(value = "/hotels/{hotelId}", method = RequestMethod.DELETE,produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> deleteHotel(@PathVariable("hotelId") int hotelId) {
List<Hotel> hotelList = new ArrayList<Hotel>();
		
		ResponseEntity<Object> responseEntity=null;
		Hotel hotel=null;
		
		hotel = hotelDAOImpl.getHotel(hotelId);
		
		if(hotel!=null){
		hotelDAOImpl.deleteHotel(hotelId);
		
		
		hotelList.add(hotel);
		
		saveMetaData(true,"Hotel deleted details","14563");
		saveData(null, hotelList);
		saveResponse(data,metaData, null);
		
		responseEntity= new  ResponseEntity<Object>(response,HttpStatus.OK);
		
		}
		else{
			errorDetails.setCode("TRA2003");
			errorDetails.setDescription("Hotel id not found");
			saveMetaData(false,"Error Occured","TRA2002");
			saveResponse(null,metaData, errorDetails);
			
			
			responseEntity= new  ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
			
		}
		return responseEntity;
	}

	

	//Error Response....
	
	private void saveResponse(Data data, MetaData metaData,
			ErrorDetails errorDet) {
		response.setData(data);
		response.setMetaData(metaData);
		response.setError(errorDet);
	}

	private void saveData(ErrorDetails erroDet, List hotelList) {
		response.setError(erroDet);
		data.setHotels(hotelList);

	}

	private void saveMetaData(boolean success, String description,
			String responseId) {

		metaData.setSuccess(success);
		metaData.setDescription(description);
		metaData.setResponseId(responseId);
	}

}
