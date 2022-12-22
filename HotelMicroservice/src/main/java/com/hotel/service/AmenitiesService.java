package com.hotel.service;

import com.hotel.entity.Amenities;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AmenitiesService {

	Amenities saveAmenity(Amenities amenityName);

	List<Amenities> getAllAmenities();


}
