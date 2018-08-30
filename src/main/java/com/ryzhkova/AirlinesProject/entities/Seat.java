package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seats database table.
 * 
 */
@Entity
@Table(name="seats")
@NamedQuery(name="Seat.findAll", query="SELECT s FROM Seat s")
public class Seat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeatPK id;

	//bi-directional many-to-one association to Aircraft
	@ManyToOne
	@JoinColumn(name="aircrafts_id", nullable=false, insertable=false, updatable=false)
	private Aircraft aircraft;

	public Seat() {
	}

	public SeatPK getId() {
		return this.id;
	}

	public void setId(SeatPK id) {
		this.id = id;
	}

	public Aircraft getAircraft() {
		return this.aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

}