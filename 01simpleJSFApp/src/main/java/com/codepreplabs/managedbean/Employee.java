package com.codepreplabs.managedbean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class Employee {

	private String firstame;
	private String lastname;
	private String sex;
	private Date dob;
	private String email;
	private String department;

	public String getFirstame() {
		return firstame;
	}

	public void setFirstame(String firstame) {
		this.firstame = firstame;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void checkEmail(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {

		String emailId = (String) value;
		if (-1 == emailId.indexOf("@")) {
			FacesMessage message = new FacesMessage("Invalid email address");
			throw new ValidatorException(message);
		}
	}

	public String addEmployee() {

		boolean added = true;
		FacesMessage status = null;
		String outcome = null;

		if (added) {
			status = new FacesMessage("Successfully added new user");
			outcome = "done";
		} else {
			status = new FacesMessage("Failed to add new user");
			outcome = "register";
		}

		FacesContext.getCurrentInstance().addMessage(null, status);
		return outcome;
	}

}
