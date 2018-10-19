package edu.lcps.teals.pvhs.auto.model;

public class Taurus extends Vehicle {

    public Taurus() {
        super.accel = 6.5;
        super.brake = 130;
        super.manufacturer = "Ford";
        super.operation = "Private";
        super.topSpeed = 125;

    }

    public String openTrunk() {
        return "Trunk lid [OPEN]";
    }

    public String openSunroof() {
        return "Sunroof [OPEN]";
    }

    public String toString() {
        return super.toString();
    }

}
