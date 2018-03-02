package com.altemetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.altemetric.entity.Network;
import com.altemetric.entity.Point;
import com.altemetric.entity.ResponseClass;
import com.altemetric.entity.Station;
import com.altemetric.service.BikeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BikeController {
    public final String endPoint = "https://api.citybik.es/v2/networks/citi-bike-nyc";
    @Autowired
    BikeService bikeService;
   @RequestMapping("/getLocations")
   @ResponseBody
   public String getEmployees(@RequestParam("type") String type, @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude)
   {
	   String result="";
	   	try {
	   	   RestTemplate restTemplate = new RestTemplate();
	       result = restTemplate.getForObject(endPoint, String.class);
	       ObjectMapper mapper = new ObjectMapper(); 
	       Network response = mapper.readValue(result, Network.class);
	       Point requestedPoint = new Point(Double.parseDouble(latitude),Double.parseDouble(longitude));
	       List<Station> outputStation = bikeService.getStationsNearBy(requestedPoint, response.getNetwork().getStationList(),type);
	       /*	       if(type.equalsIgnoreCase("pickOff")) {
	    	   outputStation = bikeService.sortStationByFreeBikes(outputStation);
	       }else if(type.equalsIgnoreCase("dropOff")) {
	    	   outputStation = bikeService.sortStationByFreeSolts(outputStation);
	       }*/
	       result = bikeService.getResponse(outputStation, type);
	       return result;
	   	}catch(Exception exp) {
	   		exp.printStackTrace();
	   		return null;
	   	}
   }
   
   @ResponseBody
   @RequestMapping("/test")
   public String testController() {
      return "[{test:test},{class:Test}]";
   }

}