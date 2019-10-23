package edu.loudoun.jchs.reference.oop;

public class Civic extends Vehicle {

    private Engine engine = new CombustibleEngine(4,250);
    private int wheels = 4;

    public Civic() {

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
