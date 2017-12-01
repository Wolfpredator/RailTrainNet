
import defaulStation.Initializer;
import defaulStation.SaintPetersburgUndergroundBlue;
import model.Railway;
import model.RailwayNetwork;
import model.Train;
import service.LiveTimeSimulation;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Main {


    public static void main(String[] args) {
        new Initializer().work();
        RailwayNetwork railwayNetwork = RailwayNetwork.getInstance();
        System.out.println(railwayNetwork.getStationsName());
        new Train(SaintPetersburgUndergroundBlue.PARNAS, SaintPetersburgUndergroundBlue.PIONERSKAJA);
        new Train(SaintPetersburgUndergroundBlue.PETROGRADSKAJA, SaintPetersburgUndergroundBlue.PARNAS);
        final Thread myThread = new Thread(new LiveTimeSimulation());
        myThread.start();
    }

}


