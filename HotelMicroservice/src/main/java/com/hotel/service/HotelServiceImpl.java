package com.hotel.service;

import com.hotel.entity.Amenities;
import com.hotel.entity.Hotel;
import com.hotel.entity.HotelRoom;
import com.hotel.entity.RoomType;
import com.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HotelServiceImpl implements HotelService {

	// auto-wiring repositories
	@Autowired
	HotelRepository hotelRepository;



	/**
	 * Returns a list of hotels based on the given hotel's name, state, or city where the hotel is located
	 *
	 * @param searchText the given search Tex
	 * @return a list of hotels based on the given hotel's name, state, or city where the hotel is located
	 */
	@Override
	public List<Hotel> searchHotels(String searchText) {
		searchText = "%" + searchText + "%";
		return hotelRepository.findByHotelNameIgnoreCaseLikeOrCityIgnoreCaseLikeOrStateIgnoreCaseLike(searchText,
				searchText, searchText);
	}

	/**
	 * Returns all the available hotels
	 * @return all the available hotels
	 */
	@Override
	public List<Hotel> returnAllHotels() {
		return hotelRepository.findAll();
	}

	/**
	 * Returns all the Room types' names given a specific hotel Name
	 * @param hotelName the given String
	 * @return all the Room types' names given a specific hotel Name
	 */
	@Override
	public Set<String> getAllRoomTypes(String hotelName) {
//		hotelName = "%" + hotelName + "%";
		Set<String> hotelRoomTypeList = new HashSet<>();
		var hotel = hotelRepository.findByHotelName(hotelName);

		System.out.println("Inside the Hotel Service Get Room Types");

		var hotelRooms = hotel.getHotelRooms();
		// loop through each hotelRoom and append its type into a list
		for (HotelRoom hotelRoom : hotelRooms) {
			hotelRoomTypeList.add(hotelRoom.getType().getName());
		}

		return hotelRoomTypeList;
	}

	/**
	 * Returns all the amenities of a given hotel
	 * @param hotelName the given hotel name
	 * @return all the amenities of a given hotel
	 */
	@Override
	public Set<String> getAllAmenities(String hotelName) {
		Hotel hotel = hotelRepository.findByHotelName(hotelName);

		// traverse thr the hotel and append all the amenities into a set
		Set<String> amenitiesSetString = new HashSet<>();
		Set<Amenities> amenitiesSet = hotel.getAmenities();
		for (Amenities a: amenitiesSet) {
			amenitiesSetString.add(a.getName());
		}
		return amenitiesSetString;
	}

	@Override
	public List<Hotel> getFiltered(Set<Integer> ratingsSet, Set<String> amenitiesSet, double priceRange) {
		return hotelRepository.findByRatingPriceAndAmenities(ratingsSet, amenitiesSet, priceRange);
	}

	/**
	 * Returns the number of hotel rooms
	 * @param hotelName the given hotel name
	 * @return number of hotel rooms
	 */
	@Override
	public Integer findNoHotelRooms(String hotelName) {
		Hotel hotel = hotelRepository.findByHotelName(hotelName);
		return hotel.getHotelRooms().size();
	}

	@Override
	public Double getDiscountByHotelName(String hotelName) {
		Hotel hotel = hotelRepository.findByHotelName(hotelName);
		return hotel.getDiscount();
	}

	@Override
	public Double getHotelPriceByHotelName(String hotelName) {
		Hotel hotel = hotelRepository.findByHotelName(hotelName);
		return hotel.getAveragePrice();
	}

	/**
	 * @param hotelName
	 * @param roomType
	 * @return
	 */
	@Override
	public Integer findNoHotelRoomsByType(String hotelName, String roomType) {
		// get the hotel
		Hotel hotel = hotelRepository.findByHotelName(hotelName);

		// get room type
		Set<HotelRoom> hotelRoomSet = hotel.getHotelRooms();
		int count = 0;
		for (HotelRoom hotelRoom: hotelRoomSet) {
			if (hotelRoom.getType().getName().equals(roomType))
				count += hotelRoom.getNoRooms();
		}
		return count;


	}
}
