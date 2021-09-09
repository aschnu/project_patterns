package main.java.car;

public class Charger implements Car {

    @Override
    public void drive() {
        System.out.println("Charger drives");
    }

    @Override
    public void hold() {
        System.out.println("Charger stops");
    }

}
