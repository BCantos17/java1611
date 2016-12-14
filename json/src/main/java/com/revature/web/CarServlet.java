package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Car;
import com.revature.beans.Example;
import com.revature.beans.Passenger;
import com.revature.json.parser.JSONConverter;

@WebServlet(urlPatterns={"car.do"})
public class CarServlet extends HttpServlet{
	// "datastore"
	Car car = Example.load();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = new JSONConverter().getJSON(car);
		resp.setContentType("application/json");
		resp.getWriter().print(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// extract the Passenger from request body
		InputStream requestBody = req.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(requestBody));
		try {
			Passenger obj = new JSONConverter()
					.getPassenger(reader.readLine());
			// add to the car
			car.getPassengers().add(obj); // middle-tier/DAO
			resp.getWriter().println("{'message':'Success!'}");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("{'message':'Failure!'}");
		}
	}
	
}





