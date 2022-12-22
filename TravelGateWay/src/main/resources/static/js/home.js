// Starting DOM by using jQuery

$(function () {


	// Behaviors of the main search Button
	$("#searchBtn").click(function () {


		// clear the hotel table whenever I click the search button
		$("#hotelTable").empty()

		let searchText = $("#searchLocation").val();

		// append the table head and its headers
		$("#hotelTable").append(
			"<thead>" +
			"<tr><td>Image</td>" +
			"<td>Hotel Name</td>" +
			"<td>City/State</td>" +
			"<td>Average Price</td>" +
			"<td>Review Rating</td>" +
			"<td>Availability</td>" +
			"</tr>" + "</thead>>"
		)


		// Check the validity of the booking data
		let checkInDate = new Date($('#checkInDate').val())
		let checkOutDate = new Date($('#checkOutDate').val())

		// check if the check-out date is either equal or after the check-in date
		if (checkOutDate < checkInDate) {
			alert('Check out date must be either or after the check-in date. Please try again')
			return
		}


		$.ajax({
			type: "GET",
			url: "http://localhost:8282/searchHotels/" + searchText,
			success: function (result) {
				$.each(result, function (key, val) {
					$("#hotelTable").append(
						"<tr>" +
						"<td><img height='200' width='200' src=" + val.imageURL + " + </td>" +
						"<td>" + val.hotelName + "</td>" +
						"<td>" + val.city + ", " + val.state + "</td>" +
						"<td>" + val.averagePrice + "</td>" +
						"<td>" + val.starRating + "</td>" +
						"<td><a href='#' class='select'>Check Availability</a></td>" +
						"</tr>"
					)
				});
			},
			error: function (e) {
				console.log("Error: ", e)
			}
		})

	});


	// Behaviors of the filter button
	$('#filterBtn').click(function () {

		// clear the hotel table list
		$('#hotelTable').empty()

		// Star rating
		let oneStar = $("#1_star_rating").val();
		let twoStar = $("#2_star_rating").val();
		let threeStar = $("#3_star_rating").val();
		let fourStar = $("#4_star_rating").val();
		let fiveStar = $("#5_star_rating").val();

		// Amenities
		let swimmingPool = $('#amenity_swimming_pool').val()
		let miniBar = $('#amenity_mini_bar').val()
		let restaurant = $('#amenity_restaurant').val()
		let garden = $('#amenity_garden').val()
		let spa = $('#amenity_spa').val()
		let fitnessCenter = $('#amenity_fitness_center').val()
		let parking = $('#amenity_parking').val()
		let breakfast = $('#amenity_breakfast').val()


		// filter time
		if (!$("#1_star_rating").is(":checked")) {
			oneStar = 0;
		}

		if (!$("#2_star_rating").is(":checked")) {
			twoStar = 0;
		}

		if (!$("#3_star_rating").is(":checked")) {
			threeStar = 0;
		}

		if (!$("#4_star_rating").is(":checked")) {
			fourStar = 0;
		}

		if (!$("#5_star_rating").is(":checked")) {
			fiveStar = 0;
		}


		//Amenities
		if (!$('#amenity_swimming_pool').is(':checked')) {
			swimmingPool = null
		}
		if (!$('#amenity_mini_bar').is(':checked')) {
			miniBar = null
		}
		if (!$('#amenity_restaurant').is(':checked')) {
			restaurant = null
		}
		if (!$('#amenity_garden').is(':checked')) {
			garden = null
		}
		if (!$('#amenity_spa').is(':checked')) {
			spa = null
		}
		if (!$('#amenity_fitness_center').is(':checked')) {
			fitnessCenter = null
		}
		if (!$('#amenity_parking').is(':checked')) {
			parking = null
		}
		if (!$('#amenity_breakfast').is(':checked')) {
			breakfast = null
		}

		// Price range
		let priceRange = $('#priceRange').val()
		let formData = {
			'oneStar': oneStar,
			'twoStar': twoStar,
			'threeStar': threeStar,
			'fourStar': fourStar,
			'fiveStar': fiveStar,
			'priceRange': priceRange,
			'amenity_swimming_pool': swimmingPool,
			'amenity_mini_bar': miniBar,
			'amenity_restaurant': restaurant,
			'amenity_garden': garden,
			'amenity_spa': spa,
			'amenity_fitness_center': fitnessCenter,
			'amenity_parking': parking,
			'amenity_breakfast': breakfast,
		}

		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://localhost:8282/filter",
			data: JSON.stringify(formData),
			datatype: 'json',
			success: function (result) {

				// console.log("success");

				// append the table head and its headers
				$("#hotelTable").append(
					"<thead>" +
					"<tr><td>Image</td>" +
					"<td>Hotel Name</td>" +
					"<td>City/State</td>" +
					"<td>Average Price</td>" +
					"<td>Review Rating</td>" +
					"</tr> +" +
					"</thead>"
				)
				$.each(result, function (key, val) {
					$("#hotelTable").append(
						"<tr>" +
						"<td><img height='200' width='200' src=" + val.imageURL + " + </td>" +
						"<td>" + val.hotelName + "</td>" +
						"<td>" + val.city + ", " + val.state + "</td>" +
						"<td>" + val.averagePrice + "</td>" +
						"<td>" + val.starRating + "</td>" +
						"</tr>"
					)
				});
			},
			error: function (e) {
				console.log("error +", e)
			}

		});

	})


	// Behavior of the Check Availability Button
	$('#hotelTable').on('click', '.select', function () {
		let hotelName = $(this).parent().parent().children("td").eq(1).text();


		if ($('#noGuests').length === 0) {
			alert('Please enter number of guests')
			return;
		} else if ($('#noRooms').length === 0) {
			alert('Please enter number of rooms')
			return;
		} else if ($('#checkInDate').length === 0) {
			alert('Please enter the check-in date')
			return;
		} else if ($('#checkOutDate').length === 0) {
			alert('Please enter the check-out date')
			return;
		}


		$("#modal_hotelName").val(hotelName);
		$("#modal_noGuests").val($('#noGuests').val());
		$("#modal_checkInDate").val($('#checkInDate').val());
		$("#modal_checkOutDate").val($('#checkOutDate').val());
		$("#modal_noRooms").val($('#noRooms').val())

		// Get the room types for a specific hotel
		$.ajax({
			type: "GET",
			url: "http://localhost:8282/getRoomTypes/" + hotelName,
			success: function (result) {
				console.log(result)
				for (let i = 0; i < result.length; i++) {
					$('#select_roomTypes').append("<option>" + result[i] + "</option>")
				}
			},
			error: function (e) {
				console.log("Error: ", e)
			}
		})

		// use the bootstrap method to show the modal
		// pop up the modal
		$('#myModal').modal()

	})

	// Behaviors of the search button in the myModal
	$('.btn-searchHotelRooms').click(function () {
		// close the main modal
		$('#myModal').modal('hide')

		// check if we have valid available rooms
		let hotelID = $('#modal_hotelId').val()
		let hotelName = $("#modal_hotelName").val();
		let noGuests = $("#modal_noGuests").val();
		let checkInDate = $("#modal_checkInDate").val();
		let checkOutDate = $("#modal_checkOutDate").val();
		let roomType = $("#select_roomTypes").val();
		let noRooms = $("#modal_noRooms").val();

		// get number of available rooms with the given hotel name and room type
		$.ajax({
			type: "GET",
			url: "http://localhost:8282/getNoRoomTypesByHotelName/" + hotelName + "/" + roomType,
			success: function (result) {
				let noAvailableRooms = result
				console.assert(noRooms <= noAvailableRooms)

				if (noRooms > noAvailableRooms) {
					alert('There is not available room of this type')
					alert('Please choose a different type of room or lesser numbers of room type')
					$('#myModal').modal('show')

				} else {
					// we have enough rooms to move on the booking part

					// get the discount
					$.ajax({
						type: 'GET',
						url: "http://localhost:8282/getDiscountByHotelName/" + hotelName,
						success: function (result) {
							let discountPercentage = result

							// get the hotel price
							$.ajax({
								type: 'GET',
								url: 'http://localhost:8282/getHotelPriceByHotelName/' + hotelName,
								success: function (result) {
									let hotelPrice = result
									$('#booking_hotelId').val(hotelID)
									$("#booking_hotelName").val(hotelName);
									$("#booking_noGuests").val(noGuests);
									$("#booking_noRooms").val(noRooms);
									$("#booking_checkInDate").val(checkInDate);
									$("#booking_checkOutDate").val(checkOutDate);
									$("#booking_roomType").val(roomType);


									// append number of guests into the booking confirmation form
									for (let i = 1; i <= noGuests; i++) {
										$("#guestTable").append("<tr><td><input type='text' class='firstName' id='firstName'></td><td><input type='text' class='lastName' id='lastName' ></td><td><input type='text' class='gender' id='gender'></td><td><input type='text' class='age' id='age'></td></tr>")

									}
									let discountPrice = hotelPrice * noRooms *  discountPercentage / 100
									let remainingPrice = hotelPrice * noRooms - discountPrice
									// append booking discount and total price
									$('#booking_original_price').text(hotelPrice * noRooms)
									$('#booking_discount').text(discountPrice)
									$('#booking_price').text(remainingPrice)
									// pop up the booking modal
									$('#bookingHotelRoomModal').modal();

								}, error: function (e) {
									console.log('Error: ', e)
									alert('Error in the get API of hotel price')
								}
							})

						},
						error: function (e) {
							alert('Error in  Discount function of the GET API')
							console.log('Error: ', e)
							return null
						}
					})
				}
			},
			error: function (e) {
				alert('Error in the get no room type by hotel name in the GET API')
				console.log('Error: ', e)
				return null;
			}

		})

	})


	// Behaviors of the confirmation booking
	$('#confirmation-booking').click(function () {

		// get booking info
		let hotelId = $("#booking_hotelId").val();
		let hotelName = $("#booking_hotelName").val();
		let noGuests = $("#booking_noGuests").val();
		let noRooms = $("#booking_noRooms").val();
		let checkInDate = $("#booking_checkInDate").val();
		let checkOutDate = $("#booking_checkOutDate").val();
		let roomType = $("#booking_roomType").val();
		let discount = $("#booking_discount").val();
		let price = $("#booking_price").val();
		let customerPhoneNumber = $('#booking_customerMobile').val()
		let customerEmail = $('#booking_customerEmail').val()
		let guestList = [];


		// get the name of each guest
		$(".firstName").each(function () {
			let firstName = $.val();
			let lastName = $.parent().parent().children('td').eq(1).children('input').val();
			let gender = $.parent().parent().children('td').eq(2).children('input').val();
			let age = $.parent().parent().children('td').eq(3).children('input').val();
			console.log(firstName, lastName, gender, age)
			guestList.push(new Guest(firstName, lastName, gender, age));
		});


		formData = {
			"hotelId": hotelId,
			"hotelName": hotelName,
			"noGuests": noGuests,
			"noRooms": noRooms,
			"guests": guestList,
			"checkInDate": checkInDate,
			"checkOutDate": checkOutDate,
			"roomType": roomType,
			"price": price,
			"discount": discount,
			'customerPhoneNumber': customerPhoneNumber,
			'customerEmail': customerEmail,
		}
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "http://localhost:8282/saveBooking",
			data: JSON.stringify(formData),
			datatype: 'json',
			success: function (result) {
				console.log("Upcoming Booking record created ");
				alert("Your booking is successfully completed! Look for your email confirmation")
			},
			error: function (e) {
				alert("Please LogIn to confirm a booking!");
			}

		});
	});

	$('.btn-edit-booking').click(function () {
		$('#bookingHotelRoomModal').modal("hide");
		$('#myModal').modal();
	})

})

function Guest(firstName, lastName, gender, age) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.age = age;

}