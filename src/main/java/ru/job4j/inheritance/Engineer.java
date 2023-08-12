package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int experience;

    public Engineer(int experience, boolean degre) {
        super(degre);
        this.experience = experience;
    }
}