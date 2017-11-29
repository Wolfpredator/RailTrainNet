
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
/*        new Init().initDefault();
        Navigator navigator = new Navigator();
        System.out.println(navigator.getRoute(SaintPetersburgUndergroundBlue.PARNAS.getStation(), SaintPetersburgUndergroundRed.AKADEMICHESKAJA.getStation()));
        LinkedList<RailwayStation> route = navigator.getRoute(SaintPetersburgUndergroundBlue.PARNAS.getStation(), SaintPetersburgUndergroundRed.AKADEMICHESKAJA.getStation());
        Train train = new Train(route);
        System.out.println(train);

        for (int i = 0; i < 200; i++) {
            train.move();
            System.out.println(train.toString());
        }
*/


    }

}


