package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Едет по рельсам");
    }

    @Override
    public void sound() {
        System.out.println("Тудух-тудух ");
    }
}
