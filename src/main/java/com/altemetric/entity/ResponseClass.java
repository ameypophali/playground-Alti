package com.altemetric.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseClass {
	
	String name;
	
	@JsonProperty("stations")
	List<Station> stations = new ArrayList<Station>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Station> getStationList() {
		return stations;
	}
	public void setStationList(List<Station> stations) {
		this.stations = stations;
	}
	
	

}
