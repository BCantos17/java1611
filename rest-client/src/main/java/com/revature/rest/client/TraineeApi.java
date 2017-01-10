package com.revature.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.revature.beans.Trainee;

/**
 *	Service that interfaces with Patrick's Trainee API (C) Revature
 */
public class TraineeApi {
	
	private String URL = 
			"http://10.255.184.248:9001/spring-rest/trainee/";
	private String GET_ALL_URL = 
			"http://10.255.184.248:9001/spring-rest/trainee/all/";

	/**
	 * Used to make REST calls to the API
	 */
	private RestTemplate rest = new RestTemplate(); 
	
	public void insert(Trainee trainee){
		ResponseEntity<Trainee> response = 
				rest.postForEntity(URL, trainee, Trainee.class);
		if(response.getStatusCode() == HttpStatus.CREATED)
			System.out.println("Insert successful");
		if(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR)
			System.out.println("Insert failed");
	}
	
	public Trainee find(int id){
		// append path param
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromHttpUrl(URL)
									.path(String.valueOf(id));
		String URI = builder.build().toUriString();
		ResponseEntity<Trainee> response = 
				rest.getForEntity(URI, Trainee.class);
		if(response.getStatusCode() == HttpStatus.NOT_FOUND)
			return null;
		else 
			return response.getBody();
	}
	
	public List<Trainee> getAll(){
		ResponseEntity<Trainee[]> response =
				rest.getForEntity(GET_ALL_URL, Trainee[].class);
		return Arrays.asList(response.getBody());
	}
	
	public void update(Trainee trainee){
		try {
			ResponseEntity<Trainee> response =
					rest.exchange(new URI(URL),
					HttpMethod.PUT, 
					new HttpEntity<Trainee>(trainee),
					Trainee.class);
			
			if(response.getStatusCode() == HttpStatus.NO_CONTENT)
				System.out.println("Update successful");
			if(response.getStatusCode() == HttpStatus.BAD_REQUEST)
				throw new IllegalArgumentException("Invalid input");
			
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
}






