package edu.lcps.teals.pvhs.auto.types;

public interface Truck extends Automobile {
    String haul();

    int getPayloadCapacity();

    void setPayloadCapacity(int payloadCapacity);

    int getTowingCapacity();

    void setTowingCapacity(int towingCapacity);
}
