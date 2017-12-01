package model;

import defaulStation.Initializer;
import defaulStation.SaintPetersburgUndergroundBlue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class TrainTest {


    @Before
    public void setUp() throws Exception {
        new Initializer().work();

        //sameTrain = new Train(SaintPetersburgUndergroundBlue.PIONERSKAJA.getStationName(), SaintPetersburgUndergroundBlue.CHERNAJA_RECHKA.getStationName());
        //sameTrain = new Train(SaintPetersburgUndergroundBlue.PETROGRADSKAJA.getStationName(), SaintPetersburgUndergroundBlue.PIONERSKAJA.getStationName());
        //oppsositeTrain = new Train(SaintPetersburgUndergroundBlue.CHERNAJA_RECHKA.getStationName(), SaintPetersburgUndergroundBlue.PIONERSKAJA.getStationName());

    }

    @Test
    public void move() throws Exception {

    }

    @Test
    public void accident() throws Exception {
    }

}