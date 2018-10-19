package edu.lcps.teals.pvhs.auto.types;

public class F150 extends Pickup implements Truck {

    public F150() {
        //parent constructor
        super(1500, 5000);

        //vehicle overrides
        super.topSpeed = 95;
        super.accel = 7;
        super.brake = 125;
        super.manufacturer = "Ford";
    }

    public String getUniqueCharacteristics() {
        return String.format("  %s%n  Max Towing = %d%n", super.haul(), super.getTowingCapacity());
    }

    public String toString() {
        return super.toString();
    }
}
