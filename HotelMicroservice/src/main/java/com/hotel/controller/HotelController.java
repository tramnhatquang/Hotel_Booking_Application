package com.hotel.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.hotel.entity.Hotel;
import com.hotel.repository.AmenitiesRepository;
import com.hotel.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class HotelController {

	@Autowired
	HotelServiceImpl hotelServiceImpl;
	@Autowired
	private AmenitiesRepository amenitiesRepository;

	/**
	 * Returns a list of Hotels that are searched by state, hotel name, and city
	 *
	 * @param searchText the given search text
	 * @return a list of Hotels that are searched by state, hotel name, and city
	 */
	@GetMapping("/searchHotels/{searchText}")
	public List<Hotel> searchHotels(@PathVariable String searchText) {
		return hotelServiceImpl.searchHotels(searchText);
	}

	/**
	 * Returns all the available hotels
	 *
	 * @return all the available Hotels
	 */
	@GetMapping("/searchHotels/all")
	public List<Hotel> returnAllHotels() {
		return hotelServiceImpl.returnAllHotels();
	}


	/**
	 * @param hotelName the given hotel Name
	 * @return all the room types based on the given
	 */
	@GetMapping("/getRoomTypes/{hotelName}")
	public Set<String> getRoomTypes(@PathVariable String hotelName) {
		return hotelServiceImpl.getAllRoomTypes(hotelName);
	}

	/**
	 * Returns all amenities of a given hotel name
	 *
	 * @param hotelName the given hotel name
	 * @return all amenities of a given hotel name
	 */
	@GetMapping("/getAmenities/{hotelName}")
	public Set<String> getAllAmenities(@PathVariable String hotelName) {
		return hotelServiceImpl.getAllAmenities(hotelName);
	}

	@PostMapping("/filter")
	public List<Hotel> getFiltered(@RequestBody JsonNode json) {
		// set of integers
		Set<Integer> ratingSet = new HashSet<>();
		// set of amenities
		Set<String> amenitiesSet = new HashSet<>();

		// append ratings into the set
		if (json.get("oneStar").asInt() > 0) {
			ratingSet.add(1);
		}
		if (json.get("twoStar").asInt() > 0) {
			ratingSet.add(2);
		}
		if (json.get("threeStar").asInt() > 0) {
			ratingSet.add(3);
		}
		if (json.get("fourStar").asInt() > 0) {
			ratingSet.add(4);
		}
		if (json.get("fiveStar").asInt() > 0) {
			ratingSet.add(5);
		}
		for (int rating: ratingSet)
			System.out.println(rating);

		double priceRange = json.get("priceRange").asDouble();

		// check amenities
		if (json.get("amenity_swimming_pool") != null) {
			amenitiesSet.add(json.get("amenity_swimming_pool").asText());
		}
		if (json.get("amenity_mini_bar") != null) {
			amenitiesSet.add(json.get("amenity_mini_bar").asText());
		}
		if (json.get("amenity_restaurant") != null) {
			amenitiesSet.add(json.get("amenity_restaurant").asText());
		}
		if (json.get("amenity_garden") != null) {
			amenitiesSet.add(json.get("amenity_garden").asText());
		}
		if (json.get("amenity_spa") != null) {
			amenitiesSet.add(json.get("amenity_spa").asText());
		}
		if (json.get("amenity_fitness_center") != null) {
			amenitiesSet.add(json.get("amenity_fitness_center").asText());
		}
		if (json.get("amenity_parking") != null) {
			amenitiesSet.add(json.get("amenity_parking").asText());
		}
		if (json.get("amenity_breakfast") != null) {
			amenitiesSet.add(json.get("amenity_breakfast").asText());
		}

		if (ratingSet.isEmpty())
			ratingSet = null;
		if (amenitiesSet.isEmpty())
			amenitiesSet =  null;

		return  hotelServiceImpl.getFiltered(ratingSet, amenitiesSet, priceRange);
	}


	@GetMapping("/findNoHotelRooms/{hotelName}")
	public int getNoHotelRoomsByHotelName(@PathVariable String hotelName) {
		return hotelServiceImpl.findNoHotelRooms(hotelName);
	}

	@GetMapping("/findNoHotelRooms/{hotelName}/{roomType}")
	public int getNoHotelRoomsByHotelNameAndRoomType(@PathVariable String hotelName, @PathVariable String roomType) {
		return hotelServiceImpl.findNoHotelRoomsByType(hotelName, roomType);
	}

	@GetMapping("/getDiscountByHotelName/{hotelName}")
	public double getDiscountByHotelName(@PathVariable String hotelName) {
		return hotelServiceImpl.getDiscountByHotelName(hotelName);
	}

	@GetMapping("/getHotelPriceByHotelName/{hotelName}")
	public double geHotelPriceByHotelName(@PathVariable String hotelName) {
		return hotelServiceImpl.getHotelPriceByHotelName(hotelName);
	}
}

