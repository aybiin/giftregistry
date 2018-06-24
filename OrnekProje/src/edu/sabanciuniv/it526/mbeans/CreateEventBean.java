package edu.sabanciuniv.it526.mbeans;

import java.util.Date;
import java.util.UUID;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import edu.sabanciuniv.it526.domain.Event;
import edu.sabanciuniv.it526.domain.EventOwner;
import edu.sabanciuniv.it526.domain.User;
import edu.sabanciuniv.it526.services.UserService;


@ManagedBean
@SessionScoped
public class CreateEventBean {
	
	private String name;
	private Date date;
	private Date deadline;
	private String thankYouNote;
	private String eventCode;
	
	@EJB
	private UserService userService;
    @ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	public CreateEventBean() {
		// TODO Auto-generated constructor stub
	}

	public CreateEventBean(String name, Date date, Date deadline, String thankYouNote) {
		super();
		this.name = name;
		this.date = date;
		this.deadline = deadline;
		this.thankYouNote = thankYouNote;
	}
	
	public String saveEvent() {
		
		String eventCode = UUID.randomUUID().toString().replace("-", "");
		Event event = userService.saveEvent(this.name, this.date, this.deadline, this.thankYouNote, eventCode);	
		User user = userService.findUser(loginBean.getUser().getId());	 
		EventOwner eventOwner = userService.createOwner(user, event);		
		userService.addEventOwnerIdToEvent(eventOwner, event);
		
		return "sendevent";	
	} 
	
	 public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
	     
	 public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
