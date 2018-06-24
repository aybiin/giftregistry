package edu.sabanciuniv.it526.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.sabanciuniv.it526.domain.User;
import edu.sabanciuniv.it526.services.UserService;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	private String email;
	private String password;
	private User user;
	
	@EJB
	private UserService userService;
	
	public String login() {
 
		user = userService.getUser(email, password);
		
		if(user==null) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Wrong credentials!"));
			return "login";
		}	
	
		if(this.email.equals(userService.getUser(email, password).getEmail()) 
				&& this.password.equals(userService.getUser(email, password).getPassword())) {
			return "user/homepage";			
		}else { 
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("User does not exist. Please log in first."));
			return "login";
		}
	}
 
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String userName) {
		this.email = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
