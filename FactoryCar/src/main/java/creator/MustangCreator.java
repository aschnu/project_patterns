package main.java.creator;

import main.java.car.Car;
import main.java.car.Mustang;

public class MustangCreator extends CarCreator {

    @Override
    public Car createCar() {
        return new Mustang();
    }
}
