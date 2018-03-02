package com.altemetric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller()
public class BikeController {
    public final String endPoint = "https://api.citybik.es/v2/networks/citi-bike-nyc";
	@RequestMapping("/getLocations")
	@ResponseBody
	public String getEmployees(@RequestParam("type") String type, @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude)
	{
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(endPoint, String.class);
	    System.out.println(result);
	    return result;
	}
	
	public String testController() {
		
	}

}
