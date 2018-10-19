package edu.lcps.teals.pvhs.auto;


import edu.lcps.teals.pvhs.auto.types.*;

import java.util.ArrayList;
import java.util.List;

public class TestDriver4 {


    public static void main(String[] args) {

        List<Truck> trucks = new ArrayList();
        trucks.add(new F350XLT());
        trucks.add(new F150());

        TestDriver4 tester = new TestDriver4();
        tester.testDriveTrucks(trucks);

        List<Automobile> autos = new ArrayList();
        autos.addAll(trucks);
        autos.add(new SHO());

        //Will unique chars display?
        tester.testDrive(autos);

    }

    //Automobile is a Truck (parent relationship)
    public void testDrive(Automobile auto) {
        System.out.println(auto.getClass().getSimpleName());
        System.out.printf("  Make = %s%n  %s%n  %s%n  Top Speed = %s%n",
                auto.getManufacturer(),
                auto.accelerate(),
                auto.brake(),
                auto.getTopSpeed());
        if (auto instanceof PoliceCar) System.out.println("  !!Police Vehicle!!");
    }

    //Will trucks display without this method
    public void testDrive(Truck truck) {
        Automobile auto = truck;
        testDrive(auto);
        System.out.println(truck.getUniqueCharacteristics());
    }

    public void testDrive(LuxurySedan sedan) {
        Automobile auto = sedan;
        testDrive(auto);
        System.out.println(sedan.getUniqueCharacteristics());
    }

    //Would testDrive(List <Truck> trucks) work?
    public void testDriveTrucks(List<Truck> trucks) {
        for (Truck truck : trucks) {
            testDrive(truck);
        }
    }

    public void testDrive(List<Automobile> autos) {
        for (Automobile auto : autos) {
            testDrive(auto);
        }
    }

}
