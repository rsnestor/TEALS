package edu.lcps.teals.pvhs.auto.types;

public class F350XLT extends Pickup implements Truck {

    public F350XLT() {
        //parent constructor
        super(4500, 13000);

        //vehicle overrides
        super.fuelType = "Diesel";
        super.topSpeed = 105;
        super.accel = 14;
        super.brake = 220;
        super.manufacturer = "Ford";
    }

    public String getUniqueCharacteristics() {
        return String.format("  %s%n  Max Towing = %d%n", super.haul(), super.getTowingCapacity());
    }

    public String toString() {
        return super.toString();
    }
}
