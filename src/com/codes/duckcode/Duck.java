package com.codes.duckcode;

public abstract class Duck {
    private FlyBehaviour flyBehaviour;
    private QuackBehaviour quackBehaviour;
    public Duck(FlyBehaviour flyBehaviour, QuackBehaviour quackBehaviour){
        this.quackBehaviour = quackBehaviour;
        this.flyBehaviour = flyBehaviour;
    }
    public abstract void display();
    public void performFly(){
        flyBehaviour.fly();
    }
    public void performQuack(){
        quackBehaviour.quack();
    }
    public void swim(){
        System.out.println("All ducks float");
    }
    public void setFlyBehaviour(FlyBehaviour fb){
        flyBehaviour = fb;
    }
    public void setQuackBehaviour(QuackBehaviour qb){
        quackBehaviour =qb;
    }
}
