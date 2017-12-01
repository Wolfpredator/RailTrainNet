package service;

import model.NavigatorNode;
import model.Railway;
import model.RailwayNetwork;
import model.RailwayStation;

import java.util.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Navigator {

    private final Integer START_STATION = 0;
    private final Integer NOT_VISITED = Integer.MAX_VALUE / 2;

    private RailwayNetwork railwayNetwork = RailwayNetwork.getInstance();
    private Map<String, NavigatorNode> visited;

    public LinkedList getRoute(String from, String to) {

        RailwayStation start = railwayNetwork.getStation(from);
        RailwayStation finish = railwayNetwork.getStation(to);

        makeVisitedMap();
        visited.put(from, new NavigatorNode(START_STATION, start));

        makeNavigateMap(start, finish);

        return makeRoadList(start, finish);
    }

    private void makeNavigateMap(RailwayStation currentStation, RailwayStation finish) {
        Map<RailwayStation, Railway> railwayRelations = currentStation.getRelationsRailways();
     //   if (!(currentStation == finish)) {
            for (Map.Entry<RailwayStation, Railway> entry : railwayRelations.entrySet()) {
                RailwayStation nextStation = entry.getValue().getAnotherStation(currentStation);

                int valueNextStation = visited.get(nextStation.getName()).getValue();
                int valueCurrentStation = visited.get(currentStation.getName()).getValue();
                int railwayValue = entry.getValue().getDistance();

                if (valueCurrentStation + railwayValue < valueNextStation) {

                    NavigatorNode navigatorNode = visited.get(nextStation.getName());
                    navigatorNode.set(valueCurrentStation + railwayValue, currentStation);

                    visited.put(nextStation.getName(), navigatorNode);

                    makeNavigateMap(nextStation, finish);
                }
            }
        }
  //  }

    private void makeVisitedMap() {
        visited = new HashMap<>();
        Iterator stationIterator = railwayNetwork.getStationsName().iterator();
        while (stationIterator.hasNext()) {
            String station = (String) stationIterator.next();
            NavigatorNode navigatorNode = new NavigatorNode(NOT_VISITED, railwayNetwork.getStation(station));
            visited.put(station, navigatorNode);
        }
    }

    private LinkedList<RailwayStation> makeRoadList(RailwayStation startStation, RailwayStation finishStation) {
        LinkedList<RailwayStation> roadList = new LinkedList();
        RailwayStation currentStation = finishStation;
        while (!(currentStation == startStation)) {
            roadList.addFirst(currentStation);
            NavigatorNode navigatorNode = visited.get(currentStation.getName());
            if(currentStation == navigatorNode.getStation()){
                System.out.println("Невозможно проложить маршрут");
                return null;
            }
            currentStation = navigatorNode.getStation();
        }
        roadList.addFirst(currentStation);
        return roadList;
    }

}
