package com.caresoft.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.interfaces.HIPAACompliantAdmin;
import com.caresoft.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents;
	
//	CONSTRUCTOR
	public AdminUser(int id, String role) {
		this.employeeID = id;
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
		
	}
	
//	MAIN METHODS
	public boolean accessAuthorized(Integer confirmedAuthID) {
		return false;
	}
	
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
	public ArrayList<String> reportSecurityIncidents() {

		return securityIncidents;
	}

	public boolean assignPin(int pin) {
		String pinString = Integer.toString(pin);
		if (pinString.length() < 6) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	public boolean accessAuthorized(int pin) {
		if (this.pin != pin) {
			this.authIncident();
			return false;
		}
		return true;
	}

	//	GETTERS AND SETTERS

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
