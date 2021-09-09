package main.java;

import main.java.car.Car;
import main.java.creator.CarCreator;
import main.java.creator.ChargerCreator;
import main.java.creator.MustangCreator;

public class FactoryCar {

    private static Car mustang;

    private final CarCreator mustangCreator = new MustangCreator();
    private final CarCreator chargerCreator = new ChargerCreator();

    public static void main(String[] args) {
        FactoryCar fc = new FactoryCar();
        fc.createCars();
        fc.driveCar(mustang);
    }

    private void createCars() {
        mustang = mustangCreator.createCar();
    }

    private void driveCar(Car car) {
        car.drive();
        car.hold();
    }

}
