package com.altemetric.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {
	public ResponseClass network;

	public ResponseClass getNetwork() {
		return network;
	}

	public void setNetwork(ResponseClass network) {
		this.network = network;
	}
	
}
