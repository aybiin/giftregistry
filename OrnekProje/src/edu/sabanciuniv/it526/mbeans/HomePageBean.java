package edu.sabanciuniv.it526.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
public class HomePageBean {

   
    public String createEvent() {
        return "createevent";      
    }
       
    public String joinEvent() {   
        return "joinevent";
    }
   
    public String myOwnEvents() {
    	return "sendevent";      
    }
      
    public String attendee() {   
        return "myattendedevents";
    }
   
}


