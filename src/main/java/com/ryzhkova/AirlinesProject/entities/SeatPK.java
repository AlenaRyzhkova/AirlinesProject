package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the seats database table.
 * 
 */
@Embeddable
public class SeatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="seats_id", unique=true, nullable=false)
	private int seatsId;

	@Column(name="aircrafts_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int aircraftsId;

	public SeatPK() {
	}
	public int getSeatsId() {
		return this.seatsId;
	}
	public void setSeatsId(int seatsId) {
		this.seatsId = seatsId;
	}
	public int getAircraftsId() {
		return this.aircraftsId;
	}
	public void setAircraftsId(int aircraftsId) {
		this.aircraftsId = aircraftsId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SeatPK)) {
			return false;
		}
		SeatPK castOther = (SeatPK)other;
		return 
			(this.seatsId == castOther.seatsId)
			&& (this.aircraftsId == castOther.aircraftsId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.seatsId;
		hash = hash * prime + this.aircraftsId;
		
		return hash;
	}
}