package com.bookservice.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity(name="book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "author",nullable = false,length = 180)
	private String author;
	@Column(name="launch_date",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date lauchDate;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false,length = 250)
	private String title;
	@Transient
	private String currency;
	@Transient
	private String enviroment;
	public Book() {

	}
	public Book(Long id, String author, Date lauchDate, Double price, String title, String currency,
			String enviroment) {
		super();
		this.id = id;
		this.author = author;
		this.lauchDate = lauchDate;
		this.price = price;
		this.title = title;
		this.currency = currency;
		this.enviroment = enviroment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getLauchDate() {
		return lauchDate;
	}
	public void setLauchDate(Date lauchDate) {
		this.lauchDate = lauchDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getEnviroment() {
		return enviroment;
	}
	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, currency, enviroment, id, lauchDate, price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(currency, other.currency)
				&& Objects.equals(enviroment, other.enviroment) && Objects.equals(id, other.id)
				&& Objects.equals(lauchDate, other.lauchDate) && Objects.equals(price, other.price)
				&& Objects.equals(title, other.title);
	}
	
	
	
	
}
