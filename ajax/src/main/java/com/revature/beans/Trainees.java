package com.revature.beans;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trainees {

	@JsonProperty
	private Set<Trainee> trainees;

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

	public Trainees(Set<Trainee> trainees) {
		super();
		this.trainees = trainees;
	}

	public Trainees() {
		super();
	}

	@Override
	public String toString() {
		return "Trainees [trainees=" + trainees + "]";
	}
	
	
	
}
