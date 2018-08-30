package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aircrafts database table.
 * 
 */
@Entity
@Table(name="aircrafts")
@NamedQuery(name="Aircraft.findAll", query="SELECT a FROM Aircraft a")
public class Aircraft implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aircrafts_id", unique=true, nullable=false)
	private int aircraftsId;

	@Column(name="aircrafts_model", nullable=false, length=45)
	private String aircraftsModel;

	//bi-directional many-to-one association to Flight
	@OneToMany(mappedBy="aircraft") //indicates that the entity in this side is the inverse of the relationship, and the owner resides in the "other" entity. 
	private List<Flight> flights;

	//bi-directional many-to-one association to Seat
	@OneToMany(mappedBy="aircraft")
	private List<Seat> seats;

	public Aircraft() {
	}

	public int getAircraftsId() {
		return this.aircraftsId;
	}

	public void setAircraftsId(int aircraftsId) {
		this.aircraftsId = aircraftsId;
	}

	public String getAircraftsModel() {
		return this.aircraftsModel;
	}

	public void setAircraftsModel(String aircraftsModel) {
		this.aircraftsModel = aircraftsModel;
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public Flight addFlight(Flight flight) {
		getFlights().add(flight);
		flight.setAircraft(this);

		return flight;
	}

	public Flight removeFlight(Flight flight) {
		getFlights().remove(flight);
		flight.setAircraft(null);

		return flight;
	}

	public List<Seat> getSeats() {
		return this.seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Seat addSeat(Seat seat) {
		getSeats().add(seat);
		seat.setAircraft(this);

		return seat;
	}

	public Seat removeSeat(Seat seat) {
		getSeats().remove(seat);
		seat.setAircraft(null);

		return seat;
	}

}