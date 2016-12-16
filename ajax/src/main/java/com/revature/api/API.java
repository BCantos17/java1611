package com.revature.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.beans.Trainee;
import com.revature.beans.Trainees;
import com.revature.data.TraineeDAO;

public class API extends HttpServlet{
	
	private Trainee readTrainee(HttpServletRequest req) throws IOException{
		InputStream requestBody = req.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(requestBody));
		try {
			return new JSONConverter()
					.getTrainee(reader.readLine());	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		new TraineeDAO().insert(readTrainee(req));
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		new TraineeDAO().update(readTrainee(req));
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		new TraineeDAO().delete(readTrainee(req));
	}
	
	public void getById(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		Trainee result = new TraineeDAO().getById(Integer.parseInt(req.getParameter("id")));
		String json = null;
		try {
			json = new JSONConverter().getJSON(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		resp.setContentType("application/json");
		resp.getWriter().print(json);
	}

	public void getAll(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		Trainees result = new TraineeDAO().getAll();
		String json = null;
		try {
			json = new JSONConverter().getJSONs(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		resp.setContentType("application/json");
		resp.getWriter().print(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		switch(req.getRequestURI()){
			case "/ajax/insert":{
				insert(req, resp);
				break;
			}
			case "/ajax/update":{
				update(req, resp);
				break;
			}
			case "/ajax/delete":{
				delete(req, resp);
				break;
			}
			case "/ajax/getById":{
				getById(req, resp);
				break;
			}
			case "/ajax/getAll":{
				getAll(req, resp);
				break;
			}
			default:{
				throw new RuntimeException();
			}
		
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
