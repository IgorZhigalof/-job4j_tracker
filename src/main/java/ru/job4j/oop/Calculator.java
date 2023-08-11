package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int y) {
        return y / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double sumAllOperation(int y) {
        return sum(y) + minus(y) + this.multiply(y) + this.divide(y);
    }

    public static void main(String[] args) {
        int y = 10;
        Calculator calculator = new Calculator();
        System.out.println(calculator.sumAllOperation(y));
        System.out.println(calculator.multiply(y));
        System.out.println(calculator.divide(y));
        System.out.println(sum(y));
        System.out.println(minus(y));
    }
}