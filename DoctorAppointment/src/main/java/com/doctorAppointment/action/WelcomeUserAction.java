package com.doctorAppointment.action;

import org.apache.struts2.ServletActionContext;


public class WelcomeUserAction{


	
	private String firstname;
	
	private String lastname;
	
	private String scheduleAppointment;
	
	private String doctor;
	
	private String comments;
	 
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

	

	// all struts logic here
	public String execute() {

		DoctorDetail d=new DoctorDetail();
		d.setComments(comments);
		d.setDoctor(doctor);
		d.setFirstname(firstname);
		d.setLastname(lastname);
		d.setScheduleAppointment(scheduleAppointment);
		
		ServletActionContext.getRequest().getSession().setAttribute("doctorDetail", d);
		return "SUCCESS";

	}
}