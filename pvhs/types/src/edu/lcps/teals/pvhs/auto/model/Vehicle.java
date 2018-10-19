package edu.lcps.teals.pvhs.auto.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

//Could make abstract
public class Vehicle {
    //default values should be used with caution
    protected String transmissionType = "Automatic";
    protected String fuelType = "gasoline";
    protected int topSpeed;
    protected String manufacturer;
    protected int axles = 2;
    //non-exclusive properties
    protected String operation;

    protected double accel;
    protected int brake;

    public String accelerate() {
        return String.format("0-60 = %.1fs", accel);
    }

    public String brake() {
        return String.format("60-0 = %dft", brake);
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("transmissionType", transmissionType)
                .append("fuelType", fuelType)
                .append("topSpeed", topSpeed)
                .append("manufacturer", manufacturer)
                .append("axles", axles)
                .append("operation", operation)
                .append("accel", accel)
                .append("brake", brake)
                .toString();
    }
}
