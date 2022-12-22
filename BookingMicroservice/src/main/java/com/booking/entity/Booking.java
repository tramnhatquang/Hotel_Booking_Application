package com.booking.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	@Column(nullable = false)
	private int hotelId; //communicates with hotel management to fetch hotel details
	@Column(nullable = false)
	private int hotelRoomId;
	@Column(nullable = false)
	private int noRooms;
	@ManyToMany
	private Set<Guest> guests;
	@Column(nullable = false)
	private Timestamp checkInDate;
	@Column(nullable = false)
	private Timestamp checkOutDate;
	@Column(nullable = false)
	private Timestamp bookedOnDate;
	@Column(nullable = false)
	private String status; //cancelled, completed (can be simply compared), upcoming
	@Column(nullable = false)
	private float price;

	@Column(nullable = false)
	private float discount;
	@Column(nullable = false)
	private Boolean reviewed;

	@Column(nullable = false)
	private String customerEmail; //identify the customer who booked
	@Column(nullable = false)
	private String roomType;

	@Column(nullable = false)
	private String hotelName;

	public Booking() {
		super();

	}

	public Boolean getReviewed() {
		return reviewed;
	}

	public void setReviewed(Boolean reviewed) {
		this.reviewed = reviewed;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getNoRooms() {
		return noRooms;
	}

	public void setNoRooms(int noRooms) {
		this.noRooms = noRooms;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getHotelRoomId() {
		return hotelRoomId;
	}

	public void setHotelRoomId(int hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}

	public Set<Guest> getGuests() {
		return guests;
	}

	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}

	public Timestamp getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Timestamp checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Timestamp getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Timestamp checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Timestamp getBookedOnDate() {
		return bookedOnDate;
	}

	public void setBookedOnDate(Timestamp bookedOnDate) {
		this.bookedOnDate = bookedOnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getcustomerEmail() {
		return customerEmail;
	}

	public void setcustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "Booking{" +
				"bookingId=" + bookingId +
				", hotelId=" + hotelId +
				", hotelRoomId=" + hotelRoomId +
				", noRooms=" + noRooms +
				", guests=" + guests +
				", checkInDate=" + checkInDate +
				", checkOutDate=" + checkOutDate +
				", bookedOnDate=" + bookedOnDate +
				", status='" + status + '\'' +
				", price=" + price +
				", discount=" + discount +
				", reviewed=" + reviewed +
				", customerEmail='" + customerEmail + '\'' +
				", roomType='" + roomType + '\'' +
				", hotelName='" + hotelName + '\'' +
				'}';
	}
}