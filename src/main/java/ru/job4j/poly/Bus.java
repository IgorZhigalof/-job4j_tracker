package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Moving forward ");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("There's " + amount + " passengers");
    }

    @Override
    public double refuel(double quantity) {
        System.out.println("Refueled " + quantity + "liters of fuel");
        return quantity * 1000;
    }
}
