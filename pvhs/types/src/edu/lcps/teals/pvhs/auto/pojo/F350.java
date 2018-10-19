package edu.lcps.teals.pvhs.auto.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class F350 {

    private String transmissionType = "Manual";
    private String fuelType = "gasoline";
    private int fuelViscosity = 87;
    private int topSpeed = 95;
    private int payloadCapacity = 2311;
    private int towingCapacity = 8000;
    //redundant fields with POJOs
    private String manufacturer = "Ford";
    private int axles = 3;
    //non-exclusive properties
    private String operation = "commercial";


    public F350() {

    }

    public String accelerate() {
        return "0-60 = 10s";
    }

    public String brake() {
        return "60-0 = 200ft";
    }

    public String haul() {
        return String.format("Max Load = %d", getPayloadCapacity());
    }


    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getFuelViscosity() {
        return fuelViscosity;
    }

    public void setFuelViscosity(int fuelViscosity) {
        this.fuelViscosity = fuelViscosity;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
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


    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("transmissionType", transmissionType)
                .append("fuelType", fuelType)
                .append("fuelViscosity", fuelViscosity)
                .append("topSpeed", topSpeed)
                .append("payloadCapacity", payloadCapacity)
                .append("towingCapacity", towingCapacity)
                .append("manufacturer", manufacturer)
                .append("axles", axles)
                .append("operation", operation)
                .toString();
    }
}
