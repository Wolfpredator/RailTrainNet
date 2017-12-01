package defaulStation;

import model.ParseStationNode;
import model.RailwayNetwork;
import service.XmlParser;

import java.util.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public final class Initializer {
    RailwayNetwork railwayNetwork;
    Random random;
    XmlParser xmlParser;
    Map<String, ArrayList<ParseStationNode>> dataFromXml;

    public Initializer() {
        railwayNetwork = RailwayNetwork.getInstance();
        random = new Random();
        xmlParser = new XmlParser();
    }

    public void work() {
        dataFromXml = xmlParser.getData();
        if (dataFromXml == null) initDefault();
        else {
            initDataFromXml();
        }


    }

    private void initDefault() {
        initDefaultStations(SaintPetersburgUndergroundBlue.values());
        initDefaultStations(SaintPetersburgUndergroundGreen.values());
        initDefaultStations(SaintPetersburgUndergroundOrange.values());
        initDefaultStations(SaintPetersburgUndergroundRed.values());
        initDefaultStations(SaintPetersburgUndergroundPurple.values());

        initDefaultRelations(SaintPetersburgUndergroundBlue.values());
        initDefaultRelations(SaintPetersburgUndergroundGreen.values());
        initDefaultRelations(SaintPetersburgUndergroundOrange.values());
        initDefaultRelations(SaintPetersburgUndergroundRed.values());
        initDefaultRelations(SaintPetersburgUndergroundPurple.values());
    }


    private void initDefaultStations(final SaintPetersburgUnderground[] undergroundValues) {
        final Iterator<SaintPetersburgUnderground> iterator = Arrays.asList(undergroundValues).iterator();

        if (!iterator.hasNext()) return;

        while (iterator.hasNext()) {
            final String stationName = iterator.next().getStationName();
            createStation(stationName);
        }
    }

    public void initDefaultRelations(final SaintPetersburgUnderground[] undergroundValues) {
        final Iterator<SaintPetersburgUnderground> iterator = Arrays.asList(undergroundValues).iterator();

        if (!iterator.hasNext()) return;

        String previousStationName = iterator.next().getStationName();

        while (iterator.hasNext()) {
            final String stationName = iterator.next().getStationName();

            createRelation(previousStationName, stationName);
            previousStationName = stationName;
        }
    }

    private void initDataFromXml() {
        Set<String> stations = dataFromXml.keySet();
        for (String name :
                stations) {
            createStation(name);
        }
        for (String name :
                stations) {
            ArrayList<ParseStationNode> parseStationNodeArrayList = dataFromXml.get(name);
            for (ParseStationNode parseStationNode :
                    parseStationNodeArrayList) {
                createRelation(name, parseStationNode.getStationName(), parseStationNode.getDistance());
            }

        }
    }

    private void createStation(final String value) {
        railwayNetwork.createStation(value);
    }

    private void createRelation(final String previousStation, final String nextStation) {
        railwayNetwork.setConnectionStation(previousStation, nextStation, getDistance());
    }

    private void createRelation(final String hostStation, final String slaveStation, int distance) {
        railwayNetwork.setConnectionStation(hostStation, slaveStation, distance);
    }

    private int getDistance() {
        return 3;//random.nextInt(9) + 1;
    }
}