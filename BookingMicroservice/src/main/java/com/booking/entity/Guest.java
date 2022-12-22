package com.booking.entity;

import jakarta.persistence.*;


@Entity
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int guestId;
	//	private int bookingId;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private int age;

	@Override
	public String toString() {
		return "Guest{" +
				"guestId=" + guestId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				'}';
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
