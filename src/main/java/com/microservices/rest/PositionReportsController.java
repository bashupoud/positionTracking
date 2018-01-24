package com.microservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.Data;
import com.microservices.Position;
import com.microservices.FlightNotFoundException;

@RestController
public class PositionReportsController 
{
	@Autowired
	private Data data;
	
	@RequestMapping(method=RequestMethod.GET,value="/flights/{flightName}")
	public ResponseEntity<Position> getLatestReportForVehicle(@PathVariable String flightName)
	{
	/*	try{
			Thread.sleep(500);
			
		}
		catch(Exception e){
			
		}
		if(Math.random()<0.75)
			throw new RuntimeException("PROBLEMS! GIVEN UP");*/
		
		System.out.println("Received Request");
		try 
		{
			Position position = data.getLatestPositionFor(flightName);
			return new ResponseEntity<Position>(position, HttpStatus.OK);
		} 
		catch (FlightNotFoundException e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
