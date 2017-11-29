package defaulStation;

import model.RailwayNetwork;

import java.util.Random;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Init {
    RailwayNetwork railwayNetwork = RailwayNetwork.getInstance();
    Random random;

    public void initDefault() {
        random = new Random();
        initStation();

    }

    private void initStation() {
        SaintPetersburgUndergroundBlue[] blues = SaintPetersburgUndergroundBlue.values();
        for (int i = 0; i < blues.length; i++) {
            railwayNetwork.createStation(blues[i].getStation());
        }
        SaintPetersburgUndergroundGreen[] greens = SaintPetersburgUndergroundGreen.values();
        for (int i = 0; i < greens.length; i++) {
            railwayNetwork.createStation(greens[i].getStation());
        }
        SaintPetersburgUndergroundOrange[] oranges = SaintPetersburgUndergroundOrange.values();
        for (int i = 0; i < oranges.length; i++) {
            railwayNetwork.createStation(oranges[i].getStation());
        }
        SaintPetersburgUndergroundPurple[] purples = SaintPetersburgUndergroundPurple.values();
        for (int i = 0; i < purples.length; i++) {
            railwayNetwork.createStation(purples[i].getStation());
        }
        SaintPetersburgUndergroundRed[] reds = SaintPetersburgUndergroundRed.values();
        for (int i = 0; i < reds.length; i++) {
            railwayNetwork.createStation(reds[i].getStation());
        }
        initRelation();
    }

    private void initRelation() {
        SaintPetersburgUndergroundBlue[] blues = SaintPetersburgUndergroundBlue.values();
        for (int i = 1; i < blues.length; i++) {
            railwayNetwork.setConnectionStation(blues[i - 1].getStation(), blues[i].getStation(), getDistance());
        }
        SaintPetersburgUndergroundGreen[] greens = SaintPetersburgUndergroundGreen.values();
        for (int i = 1; i < greens.length; i++) {
            railwayNetwork.setConnectionStation(greens[i - 1].getStation(), greens[i].getStation(), getDistance());
        }
        SaintPetersburgUndergroundOrange[] oranges = SaintPetersburgUndergroundOrange.values();
        for (int i = 1; i < oranges.length; i++) {
            railwayNetwork.setConnectionStation(oranges[i - 1].getStation(), oranges[i].getStation(), getDistance());
        }
        SaintPetersburgUndergroundPurple[] purples = SaintPetersburgUndergroundPurple.values();
        for (int i = 1; i < purples.length; i++) {
            railwayNetwork.setConnectionStation(purples[i - 1].getStation(), purples[i].getStation(), getDistance());
        }
        SaintPetersburgUndergroundRed[] reds = SaintPetersburgUndergroundRed.values();
        for (int i = 1; i < reds.length; i++) {
            railwayNetwork.setConnectionStation(reds[i - 1].getStation(), reds[i].getStation(),getDistance() );

        }
    }
    private int getDistance(){
      return random.nextInt(9)+1;
    }
}
