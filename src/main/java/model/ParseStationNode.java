package model;

public class ParseStationNode {

    String stationName;
    int distance;

    public String getStationName() {
        return stationName;
    }

    public int getDistance() {
        return distance;
    }

    public ParseStationNode(String stationName, int distance) {
        this.stationName = stationName;
        this.distance = distance;
    }
}
