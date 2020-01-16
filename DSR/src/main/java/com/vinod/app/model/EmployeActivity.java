package com.vinod.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="EmployeActivity")
public class EmployeActivity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="Activity_Category")
	private String activityCategory;
	
	@Column(name="Activity_Desciption")
	private String activityDescription;
	

	@Column(name="Logged_Date")
	private String loggedDate;
	
	@Column(name="Duration")
	private long duration;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Employe_Id")
	private Employee employe;
	
	
	
	public EmployeActivity() {
		super();
	}
	
	public EmployeActivity(String activityCategory, String activityDescription, String loggedDate, long duration) {
		super();
		this.activityCategory = activityCategory;
		this.activityDescription = activityDescription;
		this.loggedDate = loggedDate;
		this.duration = duration;
	}


	public EmployeActivity(String activityCategory, String activityDescription, String loggedDate, long duration,
			Employee employe) {
		super();
		this.activityCategory = activityCategory;
		this.activityDescription = activityDescription;
		this.loggedDate = loggedDate;
		this.duration = duration;
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "EmployeActivity [id=" + id + ", activityCategory=" + activityCategory + ", activityDescription="
				+ activityDescription + ", loggedDate=" + loggedDate + ", duration=" + duration + ", employe=" + employe
				+ "]";
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getLoggedDate() {
		return loggedDate;
	}

	public void setLoggedDate(String loggedDate) {
		this.loggedDate = loggedDate;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
	} 
	
	
	
}
