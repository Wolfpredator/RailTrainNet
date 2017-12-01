package model;

import defaulStation.Initializer;
import defaulStation.SaintPetersburgUndergroundBlue;
import static  org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class TrainTest {

    Train sameTrain;
    Train sameTrain1;
    Train train;


    @Before
    public void setUp() throws Exception {
        new Initializer().work();

        sameTrain = new Train("Парнас", "Пионерская");
        sameTrain1 = new Train("Парнас", "Пионерская");
        train = new Train("Удельная", "Пионерская");

    }

    @Test
    public void move() throws Exception {
       train.move();
       int temp = train.getCurrentPosition();
       temp++;
       train.move();
       assertEquals(temp, train.getCurrentPosition());

    }

    @Test
    public void accident() throws Exception {
    assertFalse(sameTrain.checkAccident(sameTrain1));
    sameTrain.move();//для значение длинны железной дороги между станциями = 3
    sameTrain.move();
    sameTrain.move();
    sameTrain1.move();
    sameTrain1.move();
    sameTrain1.move();
    assertTrue(sameTrain.checkAccident( sameTrain1));
    }

}