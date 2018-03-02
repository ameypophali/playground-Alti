package com.altemetric.entity;

public class ResponseResult {
	
	public ResponseResult(Station station,int result) {
		this.nameOfStation =station.getName();
		this.latitude = station.getLatitude();
		this.longitude = station.getLongitude();
		this.typeResult = result;
	}
	
	String nameOfStation;
	double latitude;
	double longitude;
	int typeResult;
	public String getNameOfStation() {
		return nameOfStation;
	}
	public void setNameOfStation(String nameOfStation) {
		this.nameOfStation = nameOfStation;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getTypeResult() {
		return typeResult;
	}
	public void setTypeResult(int typeResult) {
		this.typeResult = typeResult;
	}
	
	
	

}
