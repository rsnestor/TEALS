package edu.lcps.teals.pvhs.auto.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Taurus {

    private String transmissionType = "Automatic";
    private String fuelType = "gasoline";
    private int fuelViscosity = 87;
    private int topSpeed = 125;
    //redundant fields with POJOs
    private String manufacturer = "Ford";
    private int axles = 2;
    //non-exclusive properties
    private String operation = "private";


    public Taurus() {

    }

    public String accelerate() {
        return "0-60 = 6.5s";
    }

    public String brake() {
        return "60-0 = 130ft";
    }

    public String openTrunk() {
        return "Trunk lid [OPEN]";
    }

    public String openSunroof() {
        return "Sunroof [OPEN]";
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

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("transmissionType", transmissionType)
                .append("fuelType", fuelType)
                .append("fuelViscosity", fuelViscosity)
                .append("topSpeed", topSpeed)
                .append("manufacturer", manufacturer)
                .append("axles", axles)
                .append("operation", operation)
                .toString();
    }

}
