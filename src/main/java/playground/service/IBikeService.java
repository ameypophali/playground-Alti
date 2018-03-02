package playground.service;

import java.util.List;

import playground.entity.Point;

public interface IBikeService {
	int getDistance(Point p1, Point p2);
	List<Point> sortByDistance(List<Point> points);
}
