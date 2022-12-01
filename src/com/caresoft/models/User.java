package com.caresoft.models;

public class User {
	protected Integer id;
	protected int pin;

//	empty CONSTRUCTOR

	public User() {
	}

//	full CONSTRUCTOR

	public User(Integer id) {
		this.id = id;
	}

//	GETTERS AND SETTERS / OTHER METHODS

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}


}
