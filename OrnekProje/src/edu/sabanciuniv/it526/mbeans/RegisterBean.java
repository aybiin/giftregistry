package edu.sabanciuniv.it526.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.sabanciuniv.it526.services.UserService;


@ManagedBean
@SessionScoped
public class RegisterBean {
	
	private String name;
	private String lastName;
	private String userName;
	private String email;
	private String password;

	@EJB
	private UserService userService;
	
	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}
	

	public RegisterBean(String name, String lastName, String userName, String email, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String save() {

		userService.register(this.name, this.lastName, this.userName, this.email, this.password);
		return "login";
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
