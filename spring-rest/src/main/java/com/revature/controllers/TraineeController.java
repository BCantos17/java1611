package com.revature.controllers;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Trainee;
import com.revature.data.TraineeDAO;

@Controller
public class TraineeController {
	
	@Autowired
	private TraineeDAO dao;
	public void setDao(TraineeDAO dao) {
		this.dao = dao;
	}
	
	@ResponseBody
	@RequestMapping(value="trainee", method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> insert(
			@RequestBody @Valid Trainee trainee){
		dao.insert(trainee);
		return new ResponseEntity<Serializable>(corsHeaders(), 
				HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value="trainee", method=RequestMethod.PUT,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> update(
			@RequestBody @Valid Trainee trainee){
		dao.update(trainee);
		return new ResponseEntity<Serializable>(corsHeaders(), HttpStatus.NO_CONTENT);
	}
	
	@ResponseBody
	@RequestMapping(value="trainee/{identifier}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainee> get(@PathVariable("identifier") int id){
		Trainee result = dao.get(id);
		if(result == null){
			return new ResponseEntity<Trainee>(result, corsHeaders(),
					HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Trainee>(result, corsHeaders(),
					HttpStatus.OK);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="trainee/all",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainee>> getAll(){
		List<Trainee> result = dao.getAll();
		if(result == null){
			return new ResponseEntity<List<Trainee>>(result, corsHeaders(),
					HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<Trainee>>(result, corsHeaders(),
					HttpStatus.OK);
		}
	}
	
	public MultiValueMap<String, String> corsHeaders(){
		MultiValueMap<String, String> headers = 
				new LinkedMultiValueMap<String, String>();
		headers.put("Access-Control-Allow-Origin",
				Arrays.asList(new String[]{"*"}));
		headers.put("Access-Control-Allow-Methods",
				Arrays.asList(new String[]{"POST", "GET", "OPTIONS"}));
		headers.put("Access-Control-Allow-Headers",
				Arrays.asList(new String[]{"X-PINGOTHER", "Content-Type"}));
		headers.put("Access-Control-Max-Age",
				Arrays.asList(new String[]{"10"}));
		return headers;
	}
}
