package edu.sabanciuniv.it526.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Guest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Gift gift;
	@ManyToOne
	private Event event;

	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(User user, Event event) {
		super();
		this.user = user;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvents(Event event) {
		this.event = event;
	}


}
