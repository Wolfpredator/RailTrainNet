
import defaulStation.Initializer;
import model.Train;
import service.LiveTimeSimulation;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        new Initializer().work();
        new Train("Парнас", "Академическая");
        new Train("Технологический институт", "Парнас");
        final Thread myThread = new Thread(new LiveTimeSimulation());
        myThread.start();
    }

}


