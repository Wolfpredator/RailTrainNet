import defaulStation.Init;
import defaulStation.SaintPetersburgUndergroundBlue;
import model.Train;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class TestTrain {
    Train sameTrain;
    Train sameTrain2;
    Train sameTrain3;
    Train oppsositeTrain;

    @Before
    public void init() {
        new Init().initDefault();
        sameTrain = new Train(SaintPetersburgUndergroundBlue.PIONERSKAJA.getStation(), SaintPetersburgUndergroundBlue.CHERNAJA_RECHKA.getStation());
        sameTrain = new Train(SaintPetersburgUndergroundBlue.PETROGRADSKAJA.getStation(), SaintPetersburgUndergroundBlue.PIONERSKAJA.getStation());
        oppsositeTrain = new Train(SaintPetersburgUndergroundBlue.CHERNAJA_RECHKA.getStation(), SaintPetersburgUndergroundBlue.PIONERSKAJA.getStation());

    }

    @Test
    public void testOppositeAccident() {
        System.out.println(sameTrain.accident(oppsositeTrain));
        assertTrue(sameTrain.accident(oppsositeTrain));
    }

    @Test
    public void testInOneStationAccident() {
        System.out.println(sameTrain2.accident(sameTrain3));
        assertTrue(sameTrain2.accident(sameTrain3));

    }
}
