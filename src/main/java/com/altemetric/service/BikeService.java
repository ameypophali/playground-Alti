package com.altimetric.service;

import com.altemetrix.entity.Point;
import com.altemetrix.entity.Station;

import java.util.List;

public class BikeService implements IBikeService{
    @Override
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

}
