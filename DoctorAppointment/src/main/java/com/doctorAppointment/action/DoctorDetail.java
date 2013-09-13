package com.doctorAppointment.action;

public class DoctorDetail {

	private String firstname;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getScheduleAppointment() {
		return scheduleAppointment;
	}

	public void setScheduleAppointment(String scheduleAppointment) {
		this.scheduleAppointment = scheduleAppointment;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	private String lastname;
	
	private String scheduleAppointment;
	
	private String doctor;
	
	private String comments;
}
