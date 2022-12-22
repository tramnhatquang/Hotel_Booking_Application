package com.hotel.service;

import com.hotel.entity.RoomType;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RoomTypeService {
	RoomType saveRoomType(RoomType roomType);
	List<RoomType> getAllRoomTypes();
}
