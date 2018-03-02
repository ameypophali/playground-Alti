package Altimetrik_Playground.Altimetrik;

import com.altemetric.entity.Point;
import com.altemetric.entity.Station;
import com.altemetric.service.BikeService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;

public class BikeServiceTest {
    private static BikeService bikeService;
    @BeforeClass
    public static void onceExecutedBeforeAll() {
        bikeService = new BikeService();
    }

    @Test
    public void testGetDistance() {
        Point p1 = new Point(40.7829,73.9654);
        Point p2 = new Point(40.7590, 73.9845);
        double distance = bikeService.getDistance(p1, p2);
        Assert.assertEquals(distance,1.93, 0.05);
    }

    @Test
    public void testGetDistanceSamePoints() {
        Point p1 = new Point(40.7590,73.9845);
        Point p2 = new Point(40.7590, 73.9845);
        double distance = bikeService.getDistance(p1, p2);
        Assert.assertEquals(distance,0, 0.05);
    }

    @Test
    public void testGetStationsNearZero(){
        Point p1 = new Point(40.7829,73.9654);
        Station station1 = new Station("A", 10, 0, 0, "abcd", 40.7829, 73.9654, new Point(40.7829,73.9654));
        Station station2 = new Station("B", 10, 10, 11, "bcdf", 40.7829, 73.9654, new Point(40.7829,73.9654));
        List<Station> allStations = Arrays.asList(station1, station2);
        List<Station> stationList = bikeService.getStationsNearBy(p1, allStations, "pickOff");
        Assert.assertEquals(stationList.size(),1, 0);
        Assert.assertThat(stationList, contains(station2));
    }

    @Test
    public void testGetStationNear(){
        Point p1 = new Point(40.7829,73.9654);
        Station station1 = new Station("A", 10, 19, 20, "abcd", 40.8, 74, new Point(40.8,74));
        Station station2 = new Station("B", 10, 10, 11, "bcdf", 40.7929, 73.9854, new Point(40.7829,73.9654));

        List<Station> allStations = Arrays.asList(station1, station2);
        List<Station> stationList = bikeService.getStationsNearBy(p1, allStations, "pickOff");
        Assert.assertEquals(stationList.size(),2, 0);
        Assert.assertThat(stationList, contains(station1, station2));
    }

    @Test
    public void testsortStationByFreeBikes(){
        Point p1 = new Point(40.7829,73.9654);
        Station station1 = new Station("A", 10, 19, 20, "abcd", 40.8, 74, new Point(40.8,74));
        Station station2 = new Station("B", 10, 10, 11, "bcdf", 40.7929, 73.9854, new Point(40.7829,73.9654));
        List<Station> allStations = Arrays.asList(station1, station2);
        List<Station> result = bikeService.sortStationByFreeBikes(allStations);
        Assert.assertThat(result, contains(station1, station2));
    }

    @Test
    public void testsortStationByFreeSlots(){
        Point p1 = new Point(40.7829,73.9654);
        Station station1 = new Station("A", 10, 19, 20, "abcd", 40.8, 74, new Point(40.8,74));
        Station station2 = new Station("B", 10, 10, 11, "bcdf", 40.7929, 73.9854, new Point(40.7829,73.9654));
        List<Station> allStations = Arrays.asList(station1, station2);
        List<Station> result = bikeService.sortStationByFreeSolts(allStations);
        Assert.assertThat(result, contains(station1, station2));
    }
}