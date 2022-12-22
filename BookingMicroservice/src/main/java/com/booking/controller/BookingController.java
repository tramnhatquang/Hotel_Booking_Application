package com.booking.controller;

import com.booking.entity.Booking;
import com.booking.service.BookingServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class BookingController {

	@Autowired
	BookingServiceImpl bookingService;

	@PostMapping("/saveBooking")
	public JsonNode saveBooking(@RequestBody JsonNode json) throws IOException {
		return bookingService.saveBooking(json);
	}
}
