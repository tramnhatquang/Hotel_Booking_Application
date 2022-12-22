package com.hotel.service;

import com.hotel.entity.Hotel;
import com.hotel.entity.RoomType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface HotelService {
//	Hotel saveHotel(Hotel hotel);

	List<Hotel> searchHotels(String searchText);
	List<Hotel> returnAllHotels();
	Set<String> getAllRoomTypes(String hotelName);
	Set<String> getAllAmenities(String hotelName);

	List<Hotel> getFiltered(Set<Integer> ratingsSet, Set<String> amenitiesSet, double priceRange);

	Integer findNoHotelRooms(String hotelName);
	Integer findNoHotelRoomsByType(String hotelName, String roomType);
	Double getDiscountByHotelName(String hotelName);

	Double getHotelPriceByHotelName(String hotelName);

}
