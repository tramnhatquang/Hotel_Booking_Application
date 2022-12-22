package com.booking.entity;

import jakarta.persistence.*;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int questionId;
	private int bookingId;
	private String question;


	@Override
	public String toString() {
		return "Question{" +
				"questionId=" + questionId +
				", bookingId=" + bookingId +
				", question='" + question + '\'' +
				'}';
	}

	public int getBookingId() {
		return bookingId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

}