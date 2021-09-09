package main.java.car;

public class Mustang implements Car {

    @Override
    public void drive() {
        System.out.println("Mustang drives");
    }

    @Override
    public void hold() {
        System.out.println("Mustang stops");
    }

}
