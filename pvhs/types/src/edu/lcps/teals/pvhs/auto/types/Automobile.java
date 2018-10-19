package edu.lcps.teals.pvhs.auto.types;

public interface Automobile {
    String accelerate();

    String brake();

    String getTransmissionType();

    void setTransmissionType(String transmissionType);

    int getTopSpeed();

    void setTopSpeed(int topSpeed);

    String getFuelType();

    void setFuelType(String fuelType);

    String getManufacturer();

    void setManufacturer(String manufacturer);

    int getAxles();

    void setAxles(int axles);

    String getOperation();

    void setOperation(String operation);

    String getUniqueCharacteristics();

    @Override
    String toString();
}
