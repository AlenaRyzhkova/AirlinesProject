package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the orders database table.
 * 
 */
@Embeddable
public class OrderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="orders_id", unique=true, nullable=false)
	private int ordersId;

	@Column(name="customers_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int customersId;

	public OrderPK() {
	}
	public int getOrdersId() {
		return this.ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getCustomersId() {
		return this.customersId;
	}
	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderPK)) {
			return false;
		}
		OrderPK castOther = (OrderPK)other;
		return 
			(this.ordersId == castOther.ordersId)
			&& (this.customersId == castOther.customersId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ordersId;
		hash = hash * prime + this.customersId;
		
		return hash;
	}
}