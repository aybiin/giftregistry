package edu.sabanciuniv.it526.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private Type type;
	private Date date;
	private Date deadline;
	private String thankYouNote;
	private String eventCode;
	@OneToOne
	private EventOwner owner;
	@OneToMany(mappedBy="event")
	private List<Guest> guests;
	@ManyToMany
	private List<Gift> gifts;

	private enum Type { WEDDING, ENGAGEMENT, BIRTHDAY, BABY_SHOWER, 
		CIRCUMCISION, HENNA, FAMILY_EVENT, BUSINESS, OTHER};
	
	public Event() {
		super();
	}

	public Event(String name, Date date, Date deadline, String thankYouNote, String eventCode) {
		super();
		this.name = name;
		//this.type = type;
		this.date = date;
		this.deadline = deadline;
		this.thankYouNote = thankYouNote;
		this.eventCode = eventCode;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getThankYouNote() {
		return thankYouNote;
	}

	public void setThankYouNote(String thankYouNote) {
		this.thankYouNote = thankYouNote;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public EventOwner getOwner() {
		return owner;
	}

	public void setOwner(EventOwner owner) {
		this.owner = owner;
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	public List<Gift> getGifts() {
		return gifts;
	}

	public void setGifts(List<Gift> gifts) {
		this.gifts = gifts;
	}

	
}
