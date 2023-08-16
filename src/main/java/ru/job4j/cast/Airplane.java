package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Летит по воздуху");
    }

    @Override
    public void sound() {
        System.out.println("Вжууууууууххх");
    }
}
