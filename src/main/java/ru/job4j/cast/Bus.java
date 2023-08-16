package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Едет по дороге");
    }

    @Override
    public void sound() {
        System.out.println("Бжжжжжж ");
    }
}
