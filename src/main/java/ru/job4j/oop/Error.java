package ru.job4j.oop;

public class Error {
    private String message;
    private boolean active;
    private int status;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(this.active + ", " + this.status + ", " + this.message);
    }

    public static void main(String[] args) {
        Error test = new Error();
        Error cusByHot = new Error(false, 454, "System doesn't like hot");
        Error cusByWater = new Error(true, 422, "System doesn't like water");
        Error cusByCold = new Error(true, 453, "System doesn't like cold");
            test.printInfo();
            cusByHot.printInfo();
            cusByWater.printInfo();
            cusByCold.printInfo();
    }
}
