package com.Payments.examples.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Invoicee {

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone;
	private String email;
	private String line1;
	private String line2;
	private String city;
	private String state;
	private Long zipcode;
	private String country;
	private Long amount;
	 private String razorpayInvoiceId;
	  private String invoiceUrl;
	   private String status;
	public Invoicee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoicee(Long id, String name, String phone, String email, String line1, String line2, String city,
			String state, Long zipcode, String country, Long amount, String razorpayInvoiceId, String invoiceUrl,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.amount = amount;
		this.razorpayInvoiceId = razorpayInvoiceId;
		this.invoiceUrl = invoiceUrl;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getZipcode() {
		return zipcode;
	}
	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getRazorpayInvoiceId() {
		return razorpayInvoiceId;
	}
	public void setRazorpayInvoiceId(String razorpayInvoiceId) {
		this.razorpayInvoiceId = razorpayInvoiceId;
	}
	public String getInvoiceUrl() {
		return invoiceUrl;
	}
	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
}
