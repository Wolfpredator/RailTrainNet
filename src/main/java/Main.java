
import defaulStation.Initializer;
import model.Train;
import service.LiveTimeSimulation;
import service.TrainXmlParser;
import service.XmlParser;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        new Initializer().work();
        new TrainXmlParser().getTrain();
      //  new Train("Парнас", "Академическая");
       // new Train("Технологический институт", "Парнас");
        final Thread myThread = new Thread(new LiveTimeSimulation());
        myThread.start();
    }

}


