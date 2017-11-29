package model;

import model.RailwayStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class NavigatorNode {
    private int value;
    private RailwayStation fromStation;

    public NavigatorNode(int lenght, RailwayStation fromStation) {
        this.value = lenght;
        this.fromStation = fromStation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RailwayStation getStation() {
        return fromStation;
    }

    public void setStation(RailwayStation fromStation) {
        this.fromStation = fromStation;
    }

    public void set(int value, RailwayStation fromStation) {
        setValue(value);
        setStation(fromStation);
    }

    @Override
    public String toString() {
        return "NavigatorNode{" +
                "value=" + value +
                ", railwayStation='" + fromStation.getName() + '\'' +
                '}';
    }
}
