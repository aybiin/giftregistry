package edu.sabanciuniv.it526.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.sabanciuniv.it526.domain.Event;
import edu.sabanciuniv.it526.domain.User;
import edu.sabanciuniv.it526.services.UserService;

@ManagedBean
@SessionScoped
public class JoinEventBean {
	
	private String eventCode;
	
    @EJB
    private UserService userService;
    @ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
    	
	public JoinEventBean() {
	}
	
	public JoinEventBean(String eventCode) {
		super();
		this.eventCode = eventCode;
	}

	public String joinEvent() {
	
		Event event = userService.getEventByEventCode(this.eventCode);
		User user = loginBean.getUser();
		userService.addGuestToEvent(event, user);
		
		return "logi";
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
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
