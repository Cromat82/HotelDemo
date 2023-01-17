package org.cromani.hoteldemo.dto;

import java.time.LocalDate;
import java.util.Arrays;

import org.cromani.hoteldemo.model.Reservation;

public class ReservationUpdate {
	public ReservationUpdate(Integer id, String clientFullName, String roomNumber, String startDate, String endDate) {
		this.id = id;
		this.clientFullName = clientFullName;
		this.roomNumber = roomNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	private Integer id;
	private String clientFullName;
	private String roomNumber;
	private String startDate;
	private String endDate;
	
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
	
	public Reservation toReservationModel() {
		return new Reservation(this.id, this.clientFullName, this.roomNumber, 
								Arrays.asList(LocalDate.parse(this.startDate), LocalDate.parse(this.endDate)));
	}
}
