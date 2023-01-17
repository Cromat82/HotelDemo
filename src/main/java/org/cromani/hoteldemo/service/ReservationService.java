package org.cromani.hoteldemo.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.cromani.hoteldemo.dto.ReservationInsert;
import org.cromani.hoteldemo.dto.ReservationUpdate;
import org.cromani.hoteldemo.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	
	@Autowired
	private ApplicationContext appContext;
	
	private final Integer MAX_ID_NUMBER = 1000000;
	
	public Integer createReservation(ReservationInsert reservationDTO) {
		Map<Integer, Reservation> reservations = getReservationsBean();
		
		Integer newReservationId = null;
		while(newReservationId == null || reservations.containsKey(newReservationId)) {
			newReservationId = createId();
		}
		
		Reservation newReservation =  reservationDTO.toReservationModel(newReservationId);
		reservations.put(newReservationId, newReservation);
		return newReservationId;
	}
	
	public List<ReservationUpdate> getAllReservations() {
		Map<Integer, Reservation> reservations = getReservationsBean();
		
		return reservations.values().stream().map(r -> {
			return r.toReservationUpdate();
		}).collect(Collectors.toList());
	}
	
	public boolean updateReservation(ReservationUpdate reservationDTO) {
		Map<Integer, Reservation> reservations = getReservationsBean();
		Integer id = reservationDTO.getId();
		if (reservations.get(id) != null) {
			reservations.put(id, reservationDTO.toReservationModel());
			return true;
		} else {
			return false;
		}
	}
	
	private Map<Integer, Reservation> getReservationsBean() {
		Map<Integer, Reservation> reservationsBean =  (Map<Integer, Reservation>) appContext.getBean("reservationsBean");
		return reservationsBean;
	}
	
	private Integer createId() {
		return ThreadLocalRandom.current().nextInt(0, MAX_ID_NUMBER);
	}
}
