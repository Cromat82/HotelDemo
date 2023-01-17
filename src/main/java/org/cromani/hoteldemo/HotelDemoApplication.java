package org.cromani.hoteldemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.cromani.hoteldemo.model.Reservation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class HotelDemoApplication {

	@Bean(name= {"reservationsBean"})
	@Scope("singleton")
	public Map<Integer, Reservation> reservations() {
		return new ConcurrentHashMap<Integer, Reservation>();
	};
	
	public static void main(String[] args) {
		SpringApplication.run(HotelDemoApplication.class, args);
	}
}
