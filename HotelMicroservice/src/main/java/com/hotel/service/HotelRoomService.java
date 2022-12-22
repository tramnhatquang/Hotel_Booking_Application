package com.hotel.service;

import com.hotel.entity.HotelRoom;
import org.springframework.stereotype.Service;


@Service
public interface HotelRoomService {
	HotelRoom saveHotelRoom(HotelRoom hotelRoom);
}
