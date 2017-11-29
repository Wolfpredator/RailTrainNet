package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class RailwayNetwork {
    private static  volatile RailwayNetwork ourInstance = new RailwayNetwork();
    private final Map<String, RailwayStation> stationMap = new HashMap<>();

    public static RailwayNetwork getInstance() {
        return ourInstance;
    }

    private RailwayNetwork() {
    }

    public void createStation(String name) {
        stationMap.put(name, new RailwayStation(name));
    }

    public RailwayStation getStation(String name) {
        return stationMap.get(name);
    }

    public Set<String> getStationsName() {
        return stationMap.keySet();
    }


    public void setConnectionStation(String station1, String station2, int length) {
        RailwayStation railwayStation1 = getStation(station1);
        RailwayStation railwayStation2 = getStation(station2);
        railwayStation1.addConnection(railwayStation2, length);
    }


}
