package com.hotel.service;

import com.hotel.entity.RoomType;
import com.hotel.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{

	@Autowired
	RoomTypeRepository roomTypeRepository;

	@Override
	public RoomType saveRoomType(RoomType roomType) {
		return roomTypeRepository.save(roomType);
	}

	@Override
	public List<RoomType> getAllRoomTypes() {
		return roomTypeRepository.findAll();
	}

}
