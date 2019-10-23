package edu.loudoun.jchs.reference.oop;

public class CombustibleEngine extends Engine {

    private int cylinders;
    private int horsepower;

    public CombustibleEngine(int cylinders, int horsepower) {
        this.cylinders=cylinders;
        this.horsepower=horsepower;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

}
