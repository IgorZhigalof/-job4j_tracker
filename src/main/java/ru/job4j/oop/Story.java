package ru.job4j.oop;

public class Story {


    private static void ballsStory() {
        Ball ball = new Ball();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Fox fox = new Fox();
        wolf.tryEat(ball);
        hare.tryEat(ball);
        fox.tryEat(ball);
    }

    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Girl girl = new Girl();
        Wolf wolf = new Wolf();
        girl.help(petya);
        wolf.eat(girl);
        petya.kill(wolf);
        ballsStory();
    }
}