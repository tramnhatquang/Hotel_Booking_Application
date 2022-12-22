package com.hotel.service;

import com.hotel.entity.Amenities;
import com.hotel.repository.AmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenitiesServiceImpl implements AmenitiesService {


	@Autowired
    AmenitiesRepository amenitiesRepository;

	@Override
	public Amenities saveAmenity(Amenities amenityName) {
		return amenitiesRepository.save(amenityName);
	}

	@Override
	public List<Amenities> getAllAmenities() {
		return amenitiesRepository.findAll();
	}
}
