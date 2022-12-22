package com.hotel.repository;

import com.hotel.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Integer> {
	HotelRoom findByHotelRoomId(int id);
}
