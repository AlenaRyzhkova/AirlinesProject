package com.ryzhkova.AirlinesProject.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customers_id", unique=true, nullable=false)
	private int customersId;

	@Temporal(TemporalType.DATE)
	@Column(name="customers_birthdate", nullable=false)
	private Date customersBirthdate;

	@Column(name="customers_docnum", nullable=false, length=45)
	private String customersDocnum;

	@Column(name="customers_email", nullable=false, length=45)
	private String customersEmail;

	@Column(name="customers_firstname", nullable=false, length=45)
	private String customersFirstname;

	@Column(name="customers_lastname", nullable=false, length=45)
	private String customersLastname;

	@Column(name="customers_login", nullable=false, length=45)
	private String customersLogin;

	@Column(name="customers_password", nullable=false, length=45)
	private String customersPassword;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	private List<Order> orders;

	public Customer() {
	}

	public int getCustomersId() {
		return this.customersId;
	}

	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}

	public Date getCustomersBirthdate() {
		return this.customersBirthdate;
	}

	public void setCustomersBirthdate(Date customersBirthdate) {
		this.customersBirthdate = customersBirthdate;
	}

	public String getCustomersDocnum() {
		return this.customersDocnum;
	}

	public void setCustomersDocnum(String customersDocnum) {
		this.customersDocnum = customersDocnum;
	}

	public String getCustomersEmail() {
		return this.customersEmail;
	}

	public void setCustomersEmail(String customersEmail) {
		this.customersEmail = customersEmail;
	}

	public String getCustomersFirstname() {
		return this.customersFirstname;
	}

	public void setCustomersFirstname(String customersFirstname) {
		this.customersFirstname = customersFirstname;
	}

	public String getCustomersLastname() {
		return this.customersLastname;
	}

	public void setCustomersLastname(String customersLastname) {
		this.customersLastname = customersLastname;
	}

	public String getCustomersLogin() {
		return this.customersLogin;
	}

	public void setCustomersLogin(String customersLogin) {
		this.customersLogin = customersLogin;
	}

	public String getCustomersPassword() {
		return this.customersPassword;
	}

	public void setCustomersPassword(String customersPassword) {
		this.customersPassword = customersPassword;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}

}