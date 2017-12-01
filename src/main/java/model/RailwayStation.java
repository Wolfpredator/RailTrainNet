package model;

import java.util.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class RailwayStation {

    private final String name;
    private Map<RailwayStation, Railway> railwaysRelations = new HashMap<RailwayStation, Railway>();

    public String getName() {
        return name;
    }

    public Map<RailwayStation, Railway> getRelationsRailways() {
        return railwaysRelations;
    }

    public void addConnection(RailwayStation station, int lenght) {
        if (!railwaysRelations.containsKey(station) && !station.railwaysRelations.containsKey(this)) {
            Railway railway = new Railway(lenght, this, station);
            railwaysRelations.put(station, railway);
            station.railwaysRelations.put(this, railway);
        } else {
            System.out.println("не добавлен, уже есть");
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    public RailwayStation(String name) {
        this.name = name;
    }


}
