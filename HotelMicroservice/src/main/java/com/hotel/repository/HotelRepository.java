package com.hotel.repository;

import com.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	List<Hotel> findByHotelNameIgnoreCaseLikeOrCityIgnoreCaseLikeOrStateIgnoreCaseLike(String searchTextName,
																					   String searchTextCity,
																					   String searchTextState);


	Hotel findByHotelNameIgnoreCaseLike(String hotelName);

	Hotel findByHotelName(String hotelName);

	@Query(value = "SELECT * FROM HOTELS H JOIN HOTELS_AMENITIES HA on H.HOTELID = HA.HOTEL_HOTELID JOIN AMENITIES A2 on A2.A_ID = HA.AMENITIES_A_ID WHERE H.STARRATING IN :ratingsSet AND H.AVERAGEPRICE <= :priceRange AND A2.NAME IN :amenitiesSet", nativeQuery = true)
	List<Hotel> findByRatingPriceAndAmenities(@Param("ratingsSet")Set<Integer> ratingsSet, @Param("amenitiesSet") Set<String> amenitiesSet, @Param("priceRange")double priceRange);



}
