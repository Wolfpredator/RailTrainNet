package model;

import defaulStation.SaintPetersburgUnderground;
import service.Navigator;
import service.TrainOnline;

import java.util.LinkedList;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Train  {

    private RailwayStation currentStation;
    private RailwayStation nextStation;
    private LinkedList<RailwayStation> route;
    private int distance;
    private int currentPosition;
    private TrainOnline trainOnline;

    public Train(final SaintPetersburgUnderground from, final SaintPetersburgUnderground to) {
                this(from.getStationName(), to.getStationName());
            }


    public Train(LinkedList<RailwayStation> route) {
        this.route = route;
        initDate();
    }

    public Train(String from, String to) {

        this(new Navigator().getRoute(from, to));
    }


    private void initDate(){
        if (route == null){
            System.out.println("Невозможно двигаться по данному маршруту");
            return;
        }
        currentStation = route.pollFirst();
        nextStation = route.pollFirst();
        initDistance();
        trainOnline = TrainOnline.getInstance();
        trainOnline.subscribe(this);
    }


    public void move() {
        if (nextStation == currentStation) {
            if (route.isEmpty()) {
                System.out.println("финишировал");
                trainOnline.unsubscribe(this);
                return;
            }
            nextStation();
            return;
        }
        currentPosition++;
        if (currentPosition == distance) arrivedToStation();
    }

    private void initDistance() {
        Railway railway = currentStation.getRelationsRailways().get(nextStation);
        distance = railway.getDistance();
        currentPosition = 0;
    }

    private void arrivedToStation() {
        currentStation = nextStation;
    }

    private void nextStation() {
        nextStation = route.pollFirst();
        initDistance();
    }


    public boolean checkAccident(Train secondTrain) {
         if (moveToEachOther(secondTrain) || stayAtSameStation(secondTrain)){
            trainOnline.unsubscribe(this);
            trainOnline.unsubscribe(secondTrain);
            System.out.println("Столкновение");
            return true;
        }
        return false;
    }

    private boolean stayAtSameStation(Train train) {
        return currentStation == nextStation && train.nextStation == train.currentStation && train.nextStation == nextStation;
    }

    private boolean moveToEachOther(Train train) {
        return currentStation == train.nextStation && nextStation == train.currentStation;
    }

    @Override
    public String toString() {
        return "еду из " + currentStation + " в " + nextStation + " проехал: " + currentPosition + "/" + distance;
    }
}
