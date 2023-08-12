package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String programLang;

    public Programmer(String programLang, int experience, boolean degre) {
        super(experience, degre);
        this.programLang = programLang;
    }
}