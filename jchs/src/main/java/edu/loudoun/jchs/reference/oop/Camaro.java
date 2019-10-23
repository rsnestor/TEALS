package edu.loudoun.jchs.reference.oop;

public class Camaro extends Vehicle {

    private Engine engine = new CombustibleEngine(8,450);
    private int wheels = 4;

    public Camaro() {

    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }




}
