package com.codes.duckcode;

public class MiniDuckSimualator {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        //duck.setFlyBehaviour(new FlyRocketPowered());
        duck.performFly();
        duck.performQuack();
        duck.display();
    }
}
