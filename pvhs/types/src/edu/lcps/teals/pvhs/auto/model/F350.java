package edu.lcps.teals.pvhs.auto.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class F350 extends Vehicle {

    private int payloadCapacity = 2311;
    private int towingCapacity = 8000;


    public F350() {
        super.transmissionType = "Manual";
        super.topSpeed = 95;
        super.manufacturer = "Ford";
        super.axles = 3;
        super.operation = "Commercial";

        super.accel = 10;
        super.brake = 200;
    }

    public String haul() {
        return String.format("Max Load = %d", getPayloadCapacity());
    }

    public int getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(int payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    public int getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(int towingCapacity) {
        this.towingCapacity = towingCapacity;
    }


    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append(super.toString())
                .append("payloadCapacity", payloadCapacity)
                .append("towingCapacity", towingCapacity)
                .toString();
    }
}
