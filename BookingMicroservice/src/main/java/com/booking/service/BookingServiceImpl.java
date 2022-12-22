package com.booking.service;

import com.booking.entity.Booking;
import com.booking.entity.Question;
import com.booking.repository.BookingRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepository;
	// todo
	@Override
	public JsonNode saveBooking(JsonNode json) throws IOException {
		var guestList = json.get("guests");
		System.out.println(guestList);
		return null;


	}

	// todo
	@Override
	public List<Question> getQuestion() {
		return null;
	}
}
