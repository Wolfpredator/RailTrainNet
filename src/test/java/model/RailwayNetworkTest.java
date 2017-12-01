package model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class RailwayNetworkTest {
    RailwayNetwork railwayNetwork;

    @Before
     public void setUp(){
     railwayNetwork = RailwayNetwork.getInstance();
    }

    @Test
    public void testCreateStation() throws Exception {
        railwayNetwork.createStation("test");
        assertNotNull(railwayNetwork.getStationsName().size());
    }

    @Test
    public void testGetStation() throws Exception {
        assertEquals(new RailwayStation("test").getName(), railwayNetwork.getStation("test").getName());
    }

    @Test
    public void testGetStationsName() throws Exception {
        assertNotNull(railwayNetwork.getStationsName());
    }

    @Test
    public void setConnectionStation() throws Exception {
        railwayNetwork.createStation("test");
        railwayNetwork.createStation("test1");
        railwayNetwork.setConnectionStation("test","test1", 8);
        RailwayStation railwayStation = railwayNetwork.getStation("test");
        assertTrue(railwayStation.getRelationsRailways().containsKey(railwayNetwork.getStation("test1")));
    }

}