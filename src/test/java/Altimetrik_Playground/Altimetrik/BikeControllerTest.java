package Altimetrik_Playground.Altimetrik;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class BikeControllerTest {
	public final String localString  = "http://10.0.1.60:8080/getLocations?type=dropOff&latitude=5&longitude=-73.90";
	@Test
	public void getLocationTest() {
		String responseString = "";
		RestTemplate restTemplate = new RestTemplate();
		String actualOutput = restTemplate.getForObject(localString, String.class);
		assertEquals(responseString, actualOutput);
	}
}
