package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderPK id;

	@Column(name="orders_status", nullable=false, length=45)
	private String ordersStatus;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customers_id", nullable=false, insertable=false, updatable=false)
	private Customer customer;

	public Order() {
	}

	public OrderPK getId() {
		return this.id;
	}

	public void setId(OrderPK id) {
		this.id = id;
	}

	public String getOrdersStatus() {
		return this.ordersStatus;
	}

	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}