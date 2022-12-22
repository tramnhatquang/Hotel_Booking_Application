package com.hotel.service;

import com.hotel.entity.Amenities;
import com.hotel.entity.HotelRoom;
import com.hotel.entity.RoomType;
import com.hotel.repository.AmenitiesRepository;
import com.hotel.repository.HotelRoomRepository;
import com.hotel.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class HotelRoomServiceImpl implements HotelRoomService{
	@Autowired
	HotelRoomRepository hotelRoomRepository;

	@Autowired
	RoomTypeRepository roomTypeRepository;

	@Autowired
	AmenitiesRepository amenitiesRepository;

	@Override
	public HotelRoom saveHotelRoom(HotelRoom hotelRoom) {
		RoomType rmType=hotelRoom.getType();
		RoomType roomTypeExists=roomTypeRepository.findByName(rmType.getName());

		if(roomTypeExists==null) {

			roomTypeExists=roomTypeRepository.save(rmType);
		}
		hotelRoom.setType(rmType);
		//hotelRoom.setRoomType(rmType.getName());
		Set<Amenities> amenitySet=hotelRoom.getAmenities();
		Iterator<Amenities> itr= amenitySet.iterator();
		Set<Amenities> amenitiesToBeAdded= new HashSet<>();
		while(itr.hasNext()) {
			Amenities am=itr.next();
			Amenities amExists= amenitiesRepository.findByName(am.getName());

			if(amExists ==null) {
				amExists= amenitiesRepository.save(am);
			}
			amenitiesToBeAdded.add(amExists);
		}
		hotelRoom.setHotelRoomAmenities(amenitiesToBeAdded);

		return hotelRoomRepository.save(hotelRoom);
	}

}
