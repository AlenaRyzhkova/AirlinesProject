package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the flights database table.
 * 
 */
@Entity
@Table(name="flights")
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FlightPK id;

	@Column(name="flights_depature", nullable=false, length=255)
	private String flightsDepature;

	@Column(name="flights_destination", nullable=false, length=255)
	private String flightsDestination;

	//bi-directional many-to-one association to Aircraft
	@ManyToOne
	@JoinColumn(name="aircrafts_id", nullable=false) //indicates that this entity is the owner of the relationship
	private Aircraft aircraft;

	public Flight() {
	}

	public FlightPK getId() {
		return this.id;
	}

	public void setId(FlightPK id) {
		this.id = id;
	}

	public String getFlightsDepature() {
		return this.flightsDepature;
	}

	public void setFlightsDepature(String flightsDepature) {
		this.flightsDepature = flightsDepature;
	}

	public String getFlightsDestination() {
		return this.flightsDestination;
	}

	public void setFlightsDestination(String flightsDestination) {
		this.flightsDestination = flightsDestination;
	}

	public Aircraft getAircraft() {
		return this.aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

}