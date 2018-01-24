package com.microservices;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.stereotype.Repository;

@Repository
// Just a standin for a proper database
public class Data 
{
	Map<String,Queue<Position>> positionQueues;
	
	public Data()
	{
		positionQueues = new HashMap<>();
	}
	
	public void updatePosition(Map<String,String> data)
	{
		String flightName = data.get("vehicle");
		Queue<Position> positions = positionQueues.get(flightName);
		if (positions == null) 
		{
			positions = new PriorityQueue<Position>();
			positionQueues.put(flightName, positions);
		}
		Position newPosition = new Position(data.get("lat"), data.get("long"), data.get("time"));
		positions.add(newPosition);
	}
	
	public Position getLatestPositionFor(String flightName) throws FlightNotFoundException
	{
		Queue<Position> queue = positionQueues.get(flightName);
		if (queue == null) throw new FlightNotFoundException();
		return queue.peek();
	}
}
