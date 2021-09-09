package main.java.creator;

import main.java.car.Car;
import main.java.car.Charger;

public class ChargerCreator extends CarCreator {

    @Override
    public Car createCar() {
        return new Charger();
    }

}
