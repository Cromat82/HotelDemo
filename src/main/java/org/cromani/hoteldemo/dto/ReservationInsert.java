package org.cromani.hoteldemo.dto;

import java.time.LocalDate;
import java.util.Arrays;

import org.cromani.hoteldemo.model.Reservation;

public class ReservationInsert {
	public ReservationInsert(String clientFullName, String roomNumber, String startDate, String endDate) {
		this.clientFullName = clientFullName;
		this.roomNumber = roomNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	private String clientFullName;
	private String roomNumber;
	private String startDate;
	private String endDate;

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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public Reservation toReservationModel(Integer id) {
		return new Reservation(id, clientFullName,roomNumber, 
								Arrays.asList(LocalDate.parse(startDate), LocalDate.parse(endDate)));
	}
	
	public ReservationUpdate toReservationUpdate(Integer id) {
		return new ReservationUpdate(id, clientFullName, roomNumber, startDate, endDate);
	}
}
