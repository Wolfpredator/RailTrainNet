
import defaulStation.Init;
import defaulStation.SaintPetersburgUndergroundBlue;
import defaulStation.SaintPetersburgUndergroundRed;
import model.RailwayStation;
import model.Train;
import service.Navigator;
import service.SimulateLiveTime;

import java.util.LinkedList;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Main {


    public static void main(String[] args) {
        Thread myThread = new Thread(new SimulateLiveTime());
        myThread.start();
    }

}


