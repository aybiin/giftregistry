package edu.sabanciuniv.it526.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.javafx.scene.control.skin.FXVK.Type;

import edu.sabanciuniv.it526.domain.Event;
import edu.sabanciuniv.it526.domain.EventOwner;
import edu.sabanciuniv.it526.domain.Guest;
import edu.sabanciuniv.it526.domain.User;

@Stateless
public class UserService {
	
	@PersistenceContext
	private EntityManager em;

	public User getUser(String email, String password) {
		
		List<User> users = em.createQuery
				("select u from User u where u.email=:email and u.password=:password", User.class)
		.setParameter("email", email)
		.setParameter("password", password)
		.getResultList();

		if(users.size()==1) {
			return users.get(0);
		}	
		return null;
	}
	
	public List<EventOwner> getEventOwner(int userId) {

		List<EventOwner> eventOwners = em.createQuery
				("select e from EventOwner e where e.user.id=:user_id", EventOwner.class)
		.setParameter("user_id", userId)
		.getResultList();
		
		return eventOwners;
	}
	
	public User findUser(int id) {	
		User user = em.find(User.class, id);
		return user;
	}

	public void register(String name, String lastName, String userName, String email, String password) {
		User user = new User(name, lastName, userName, email, password);
		em.persist(user);
	}
	
	public Event saveEvent(String name, Date date, Date deadline, String thankYouNote, String eventCode) {		
		Event event = new Event(name, date, deadline, thankYouNote, eventCode);
		em.persist(event);
		return event;
	}

	public EventOwner createOwner(User user, Event event) {
		EventOwner eventOwner = new EventOwner(user, event);
		em.persist(eventOwner);	
		return eventOwner;
	}

	public void addEventOwnerIdToEvent(EventOwner eventOwner, Event event) {
		eventOwner.getId();
		event.setOwner(eventOwner);
		em.merge(event);
	}

	public Event getEvent(EventOwner eventOwner) {
		return em.find(Event.class, eventOwner.getId());		
	}

	public Event getEventByEventCode(String eventCode) {
		
		List<Event> events = em.createQuery
				("select e from Event e where e.eventCode=:eventCode", Event.class)
		.setParameter("eventCode", eventCode)
		.getResultList();	
		if(events.size()==1) {
			return events.get(0);
		}	
		return null;		
	}

	public void addGuestToEvent(Event event, User user) {
		Guest guest = new Guest(user, event);
		em.persist(guest);
	}

	public List<Guest> getGuest(int userId) {
		
		List<Guest> guests = em.createQuery
				("select g from Guest g where g.user.id=:user_id", Guest.class)
		.setParameter("user_id", userId)
		.getResultList();
		
		return guests;
	}

	public Event getEventByGuest(Guest guest) {
		return em.find(Event.class, guest.getId());
	}

}
