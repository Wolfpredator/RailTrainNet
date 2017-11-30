package defaulStation;

import model.RailwayNetwork;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public final class Initializer {
    RailwayNetwork railwayNetwork;
    Random random;

    public Initializer() {
        railwayNetwork = RailwayNetwork.getInstance();
        random = new Random();
    }

    public void work() {
        initStations(SaintPetersburgUndergroundBlue.values());
        initStations(SaintPetersburgUndergroundGreen.values());
        initStations(SaintPetersburgUndergroundOrange.values());
        initStations(SaintPetersburgUndergroundRed.values());
        initStations(SaintPetersburgUndergroundPurple.values());

        initRelations(SaintPetersburgUndergroundBlue.values());
        initRelations(SaintPetersburgUndergroundGreen.values());
        initRelations(SaintPetersburgUndergroundOrange.values());
        initRelations(SaintPetersburgUndergroundRed.values());
        initRelations(SaintPetersburgUndergroundPurple.values());
    }


    private void initStations(final SaintPetersburgUnderground[] undergroundValues) {
        final Iterator<SaintPetersburgUnderground> iterator = Arrays.asList(undergroundValues).iterator();

        if (!iterator.hasNext()) return;

        while (iterator.hasNext()) {
            final String stationName = iterator.next().getStationName();
            createStation(stationName);
        }
    }

    public void initRelations(final SaintPetersburgUnderground[] undergroundValues){
        final Iterator<SaintPetersburgUnderground> iterator = Arrays.asList(undergroundValues).iterator();

        if (!iterator.hasNext()) return;

        String previousStationName = iterator.next().getStationName();

        while (iterator.hasNext()) {
            final String stationName = iterator.next().getStationName();

            createRelation(previousStationName, stationName);
            previousStationName = stationName;
        }
    }

    private void createStation(final String value) {
        railwayNetwork.createStation(value);
    }

    private void createRelation(final String previousStation, final String nextStation) {
        railwayNetwork.setConnectionStation(previousStation, nextStation, getDistance());
    }

    private int getDistance() {
        return random.nextInt(9) + 1;
    }
}