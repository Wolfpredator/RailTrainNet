package service;

import defaulStation.Initializer;
import defaulStation.SaintPetersburgUnderground;
import defaulStation.SaintPetersburgUndergroundBlue;
import model.RailwayNetwork;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class NavigatorTest {
    Navigator navigator;
    @Before
    public void setUp(){
        new Initializer().work();
    navigator = new Navigator();
    }

    @Test
    public void testGetRoute() throws Exception {
        LinkedList list = navigator.getRoute(SaintPetersburgUndergroundBlue.PETROGRADSKAJA.getStationName(), SaintPetersburgUndergroundBlue.PARNAS.getStationName());
        assertNotNull(list);
        assertEquals(SaintPetersburgUndergroundBlue.PETROGRADSKAJA.getStationName(), list.pollFirst().toString());
        assertEquals(SaintPetersburgUndergroundBlue.PARNAS.getStationName(), list.pollLast().toString());
    }

    @Test
    public void testGetRouteNull() throws  Exception {
        String unreachableStation = "Недосягаемая станция";
        RailwayNetwork.getInstance().createStation(unreachableStation);
        assertNull(navigator.getRoute("Парнас", unreachableStation));
    }

}