package com.travelgateway.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.travelgateway.client.BookingClient;
import com.travelgateway.client.HotelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GatewayController {
	@Autowired
	HotelClient hotelClient;

	@Autowired
	BookingClient bookingClient;


	@PostMapping("/filter")
	public JsonNode filter(@RequestBody JsonNode json) {
		return hotelClient.filter(json);
	}

	@GetMapping("/searchHotels/{searchText}")
	public JsonNode searchHotels(@PathVariable String searchText) {
		System.out.println("Searching for " + searchText + " in Gateway");
		return hotelClient.searchHotels(searchText);
	}


	@GetMapping("/getRoomTypes/{hotelName}")
	public JsonNode getRoomTypes(@PathVariable String hotelName) {
		System.out.println("Searching for all room types of hotel " + hotelName + " in Gateway");
		return hotelClient.getRoomTypes(hotelName);
	}

	@GetMapping("/getNoRoomTypesByHotelName/{hotelName}/{roomType}")
	public JsonNode getNoRoomTypesByHotelName(@PathVariable String hotelName, @PathVariable String roomType) {
		System.out.println("Searching for number of room types in Gateway Controller");
		return hotelClient.getNoRoomTypesByHotelName(hotelName, roomType);
	}

	@GetMapping("/getDiscountByHotelName/{hotelName}")
	public JsonNode getDiscountByHotelName(@PathVariable String hotelName) {
		return hotelClient.getDiscountByHotelName(hotelName);
	}

	@GetMapping("/getHotelPriceByHotelName/{hotelName}")
	public JsonNode getHotelPriceByHotelName(@PathVariable String hotelName) {
		return hotelClient.getHotelPriceByHotelName(hotelName);
	}

	@PostMapping("/confirmBooking")
	public JsonNode confirmBooking(@RequestBody JsonNode json) {
		return bookingClient.saveBooking(json);
	}
}
