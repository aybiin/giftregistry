package edu.sabanciuniv.it526.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Gift {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private Category category;
	private Status status;
	private int quantity;
	private String color;
	private String brand;
	private String model;
	private String url;
	private String imageUrl;
	private String details;
	private String comments;
	@OneToMany(mappedBy="gift")
	private List<Guest> guests;
	@ManyToMany(mappedBy="gifts")
	private List<Event> events;
	
	private enum Category { CATEGORY1, CATEGORY2, CATEGORY3, OTHER };
	private enum Status { NOT_SELECTED, SELECTED, RESERVED };
	
	public Gift() {
		// TODO Auto-generated constructor stub
	}

	public Gift(String name, Category category, Status status, int quantity, String color, String brand, String model,
			String url, String imageUrl, String details, String comments, List<Guest> guests, List<Event> events) {
		super();
		this.name = name;
		this.category = category;
		this.status = status;
		this.quantity = quantity;
		this.color = color;
		this.brand = brand;
		this.model = model;
		this.url = url;
		this.imageUrl = imageUrl;
		this.details = details;
		this.comments = comments;
		this.guests = guests;
		this.events = events;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	
}
