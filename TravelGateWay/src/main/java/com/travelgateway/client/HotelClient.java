package com.travelgateway.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HotelClient {
	private final static String hotelMicroserviceURL = "http://localhost:8383/";


	/**
	 * Returns a JsonNode object that contains info about the "searchHotels/searchtext" coming from
	 * HotelMicroservice controller
	 *
	 * @param searchText the given String search
	 * @return a JsonNode object that contains info about the "searchHotels/searchtext" coming from
	 * HotelMicroservice controller
	 */
	public JsonNode searchHotels(String searchText) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity =
				restTemplate.getForEntity(hotelMicroserviceURL + "searchHotels/" + searchText, Object.class);
		Object objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}


	public JsonNode getRoomTypes(String searchText) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity =
				restTemplate.getForEntity(hotelMicroserviceURL + "getRoomTypes/" + searchText, Object.class);
		Object objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}

	/**
	 * Returns the json node posting to the hotel microservice
	 *
	 * @param json the given json node from the user
	 * @return the Json node posting to the hotel microservice
	 */
	public JsonNode filter(JsonNode json) {
		System.out.println("Inside Hotel Rest Client for post call filter");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(hotelMicroserviceURL + "filter/", request,
				Object.class);
		Object objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}


	public JsonNode getNoRoomTypesByHotelName(String hotelName, String roomType) {
		System.out.println("Inside Hotel Rest Client for get no of room types ");


		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity =
				restTemplate.getForEntity(hotelMicroserviceURL + "findNoHotelRooms/" + hotelName + "/" + roomType,
						Object.class);
		Object objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}

	public JsonNode getDiscountByHotelName(String hotelName) {
		System.out.println("Inside Hotel Rest Client for get hotel's discount ");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity(hotelMicroserviceURL + "getDiscountByHotelName/" + hotelName,
				Object.class);
		Object objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}


	public JsonNode getHotelPriceByHotelName(String hotelName) {
		System.out.println("Inside Hotel Rest Client for get HOTEL's PRICE ");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity(hotelMicroserviceURL + "getHotelPriceByHotelName/" + hotelName,
				Object.class);
		Object objects = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(objects, JsonNode.class);
	}


}