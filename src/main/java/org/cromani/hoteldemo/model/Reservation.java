package org.cromani.hoteldemo.model;

import java.time.LocalDate;
import java.util.List;

import org.cromani.hoteldemo.dto.ReservationUpdate;

public class Reservation {
	
	public Reservation(Integer id, String clientName, String roomNumber, List<LocalDate> reservationDates) {
		this.id = id;
		this.clientFullName = clientName;
		this.roomNumber = roomNumber;
		this.reservationDates = reservationDates;
	}
	
	private Integer id;
	private String clientFullName;
	private String roomNumber;
	private List<LocalDate> reservationDates;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClientFullName() {
		return clientFullName;
	}
	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public List<LocalDate> getReservationDates() {
		return reservationDates;
	}
	public void setReservationDates(List<LocalDate> reservationDates) {
		this.reservationDates = reservationDates;
	}
	
	public ReservationUpdate toReservationUpdate() {
		return new ReservationUpdate(id, clientFullName, roomNumber, 
				reservationDates.get(0).toString(), reservationDates.get(1).toString());
	}
}
