package model;

import java.util.ArrayList;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Railway {
    private final int distance;
    private final ArrayList<RailwayStation> stations = new ArrayList<RailwayStation>(2);

    public Railway(int distance, RailwayStation station1, RailwayStation station2) {
        stations.add(station1);
        stations.add(station2);
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }


    public ArrayList<RailwayStation> getStations() {
        return stations;
    }

    public RailwayStation getAnotherStation(RailwayStation railwayStation) {
        if (stations.get(0) == railwayStation) return stations.get(1);
        return stations.get(0);
    }

}
