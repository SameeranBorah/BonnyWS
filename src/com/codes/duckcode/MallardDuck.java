package com.codes.duckcode;

public class MallardDuck extends Duck {
    public MallardDuck(){
        super(new FlyWithWings(), new Quack());
    }
    public void display(){
        System.out.println("I am a real Mallard duck");
    }
}
