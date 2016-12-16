package com.revature.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Trainee;
import com.revature.beans.Trainees;
public class JSONConverter {

	public Trainee getTrainee(String json) throws Exception{
		return new ObjectMapper().readValue(json, Trainee.class);
	}
	
	public String getJSON(Trainee obj) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(obj);
	}
	public Trainees getTrainees(String json) throws Exception{
		return new ObjectMapper().readValue(json, Trainees.class);
	}
	
	public String getJSONs(Trainees obj) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(obj);
	}
}
