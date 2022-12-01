package com.caresoft.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.interfaces.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {
//	creates object of ArrayList type to hold all patient notes. ArrayList gives us access to its methods.
	private ArrayList<String> patientNotes;

//	FULL CONSTRUCTOR

	public Physician(Integer id) {
		this.id = id;
	}

//	IMPLEMENT HIPAA COMPLIANT USER (METHODS)

	public boolean assignPin(int pin) {
		String pinString = Integer.toString(pin);
		if (pinString.length() != 4) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id != this.pin) {
			return false;
		}
		return true;
	}

//	MAIN METHODS

	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

//    GETTERS / SETTERS

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
}
