package com.altemetric.service;

import com.altemetric.entity.Point;
import com.altemetric.entity.Station;

import java.util.List;

public interface IBikeService {
    double getDistance(Point p1, Point p2);
    List<Station> getStationsNearBy(Point point, List<Station> allstations,String type);
    List<Station> sortStationByFreeBikes(List<Station> stations);
    List<Station> sortStationByFreeSolts(List<Station> stations);
    public String getResponse(List<Station> stations,String type);
}