package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the flights database table.
 * 
 */
@Embeddable
public class FlightPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="flights_id", unique=true, nullable=false)
	private int flightsId;

	@Temporal(TemporalType.DATE)
	@Column(name="flights_date", unique=true, nullable=false)
	private java.util.Date flightsDate;

	public FlightPK() {
	}
	public int getFlightsId() {
		return this.flightsId;
	}
	public void setFlightsId(int flightsId) {
		this.flightsId = flightsId;
	}
	public java.util.Date getFlightsDate() {
		return this.flightsDate;
	}
	public void setFlightsDate(java.util.Date flightsDate) {
		this.flightsDate = flightsDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FlightPK)) {
			return false;
		}
		FlightPK castOther = (FlightPK)other;
		return 
			(this.flightsId == castOther.flightsId)
			&& this.flightsDate.equals(castOther.flightsDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.flightsId;
		hash = hash * prime + this.flightsDate.hashCode();
		
		return hash;
	}
}