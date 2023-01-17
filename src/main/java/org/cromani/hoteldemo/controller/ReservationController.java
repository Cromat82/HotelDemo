package org.cromani.hoteldemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cromani.hoteldemo.dto.ReservationInsert;
import org.cromani.hoteldemo.dto.ReservationUpdate;
import org.cromani.hoteldemo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createReservation(@ModelAttribute ReservationInsert reservationInsert) throws JsonProcessingException {
		Integer newReservationId = reservationService.createReservation(reservationInsert);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reservationId", newReservationId);
		return ResponseEntity.ok(new ObjectMapper().writeValueAsString(map));
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> GetAllReservations() throws JsonProcessingException {
		List<ReservationUpdate> reservations = reservationService.getAllReservations();
		if (reservations.size() == 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "no reservations");
			return ResponseEntity.ok(new ObjectMapper().writeValueAsString(map));
		}
		return ResponseEntity.ok(reservations);
	}
	
	@PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateReservation(@ModelAttribute ReservationUpdate reservationUpdate) throws JsonProcessingException {
		String result = reservationService.updateReservation(reservationUpdate) ? "reservation updated" : "reservation not found";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return ResponseEntity.ok(new ObjectMapper().writeValueAsString(map));
	}
}
