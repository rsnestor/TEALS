package edu.lcps.teals.pvhs.auto.types;

import edu.lcps.teals.pvhs.auto.model.Vehicle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//F350 changed to abstract class
public abstract class Pickup extends Vehicle {

    private int payloadCapacity;
    private int towingCapacity;

    //Constructor forces population of payload & towing
    public Pickup(int payloadCapacity, int towingCapacity) {
        this.payloadCapacity = payloadCapacity;
        this.towingCapacity = towingCapacity;
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

    abstract public String getUniqueCharacteristics();

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append(super.toString())
                .append("payloadCapacity", payloadCapacity)
                .append("towingCapacity", towingCapacity)
                .toString();
    }
}
