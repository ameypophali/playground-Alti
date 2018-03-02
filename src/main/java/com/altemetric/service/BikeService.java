package com.altemetric.service;

import com.altemetric.entity.Point;
import com.altemetric.entity.ResponseResult;
import com.altemetric.entity.Station;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class BikeService implements IBikeService{
    
	
    public double getDistance(Point p1, Point p2) {
        if (p1.getLatitude() == p2.getLatitude() && p1.getLongitude() == p2.getLongitude()) return 0;
        final int EARTH_RADIUS = 6371; //in kms
        final double KM_TO_MILES = 0.621371;
        double dLat = Math.toRadians(p1.getLatitude() - p2.getLatitude());
        double dLon = Math.toRadians(p1.getLongitude() - p2.getLongitude());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(p1.getLatitude())) *
                        Math.cos(Math.toRadians(p2.getLatitude())) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * b * KM_TO_MILES;
    }

	
    public List<Station> getStationsNearBy(Point point, List<Station> allstations,String type) {
        List<Station> nearStation = new ArrayList<Station>();
        final int distanceAllowed = 3;
        if(point==null) return nearStation;
        for(Station current : allstations){
        	if((type.equalsIgnoreCase("pickOff") && current.getFreeBikes()==0 ) || 
        			( type.equalsIgnoreCase("dropOff") && current.getEmptySlots() == 0 )  ) {
        		
        		continue;
        	}
        	
            double distance = getDistance(point,current.getPoint());
            Map<Double, Station> stationMap = new TreeMap<Double, Station>(new Comparator<Double>(d1,d2) {
            	return Double.compare(d2, d1);
            });
            if(distance<distanceAllowed){
                nearStation.add(current);
            }
        }
        return nearStation;
    }

	@Override
	public List<Station> sortStationByFreeBikes(List<Station> stations) {
		stations.sort((s1, s2)->Integer.compare(s2.getFreeBikes(), s1.getFreeBikes()));
		return stations;
	}

	@Override
	public List<Station> sortStationByFreeSolts(List<Station> stations) {
		stations.sort((s1, s2)->Integer.compare(s2.getEmptySlots(), s1.getEmptySlots()));
		return stations;
	}


	@Override
	public String getResponse(List<Station> stations) {
		List<ResponseResult> responseResult = new ArrayList<>();
		/*stations.forEach(stations->{
			
			
		});*/
		return null;
	}



    
}