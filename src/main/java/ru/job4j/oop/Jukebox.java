package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox basic = new Jukebox();
        basic.music(1);
        basic.music(2);
        basic.music(3);
    }

    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Пусть бегут неуклюже");
            case 2 -> System.out.println("Спокойной ночи");
            default -> System.out.println("Песня не найдена");
        }
    }
}
