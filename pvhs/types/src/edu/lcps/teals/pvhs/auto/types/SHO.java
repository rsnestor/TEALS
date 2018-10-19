package edu.lcps.teals.pvhs.auto.types;

import edu.lcps.teals.pvhs.auto.model.Taurus;

public class SHO extends Taurus implements LuxurySedan, PoliceCar {

    public SHO() {
        super.accel = 3.9;
        super.brake = 120;
        super.topSpeed = 155;
    }

    public String race() {
        return "Qtr Mile [14.2s]";
    }

    public String toString() {
        return super.toString();
    }

    public String getUniqueCharacteristics() {
        return String.format("  %s%n  %s%n  %s%n", this.openTrunk(), this.openSunroof(), this.race());
    }

}
