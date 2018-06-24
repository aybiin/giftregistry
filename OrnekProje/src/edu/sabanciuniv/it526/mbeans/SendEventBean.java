package edu.sabanciuniv.it526.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import edu.sabanciuniv.it526.domain.Event;
import edu.sabanciuniv.it526.domain.EventOwner;
import edu.sabanciuniv.it526.other.EmailSendM;
import edu.sabanciuniv.it526.services.UserService;


@ManagedBean
@ViewScoped
public class SendEventBean {
	
	private String inviteeEmail;
	private EmailSendM emailSend;
	private List<EventOwner> eventOwners;
	private List<Event> events;
	
	@EJB
	private UserService userService;
    @ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
    
    @PostConstruct
    public void init() {	
    	events = new ArrayList<Event>();
    	eventOwners = userService.getEventOwner(loginBean.getUser().getId());
    	for (EventOwner eventOwner : eventOwners) {
			Event event = userService.getEvent(eventOwner);
			events.add(event);
		}   
    }
	
	public SendEventBean() {
		// TODO Auto-generated constructor stub
	}

	public SendEventBean(String inviteeEmail) {
		super();
		this.inviteeEmail = inviteeEmail;
	}

	public String sendEvent(String inviteeEmail, String eventName, String eventCode) {
		String name = loginBean.getUser().getName();
		String lastName = loginBean.getUser().getLastName(); 
		emailSend = new EmailSendM();
		emailSend.sendEmail(inviteeEmail, name, lastName, eventName, eventCode);	
		return "login";	
	}

	public String getInviteeEmail() {
		return inviteeEmail;
	}

	public void setInviteeEmail(String inviteeEmail) {
		this.inviteeEmail = inviteeEmail;
	}
	
	public EmailSendM getEmailSend() {
		return emailSend;
	}

	public void setEmailSend(EmailSendM emailSend) {
		this.emailSend = emailSend;
	}

	public List<EventOwner> getEventOwners() {
		return eventOwners;
	}

	public void setEventOwners(List<EventOwner> eventOwners) {
		this.eventOwners = eventOwners;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
