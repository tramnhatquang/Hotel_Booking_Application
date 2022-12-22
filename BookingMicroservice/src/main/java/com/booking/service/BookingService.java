package com.booking.service;

import com.booking.entity.Question;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface BookingService {

	JsonNode saveBooking(JsonNode json) throws IOException;
	List<Question> getQuestion();

}
