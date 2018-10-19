package edu.lcps.teals.pvhs.auto;


import edu.lcps.teals.pvhs.auto.model.F350;
import edu.lcps.teals.pvhs.auto.model.Taurus;
import edu.lcps.teals.pvhs.auto.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class TestDriver3 {

    private static List<Vehicle> inventory = new ArrayList();

    public static void main(String[] args) {

        inventory.add(new F350());
        inventory.add(new Taurus());

        TestDriver3 tester = new TestDriver3();
        tester.testDrive(inventory);

    }

    public void testDrive(Vehicle auto) {
        //fidelity loss - trunk, sunroof, payload
        System.out.println(auto.getClass().getSimpleName());
        System.out.printf("  Make = %s%n  %s%n  %s%n  Top Speed = %s%n",
                auto.getManufacturer(),
                auto.accelerate(),
                auto.brake(),
                auto.getTopSpeed());
    }

    public void testDrive(List vehicles) {
        for (Vehicle auto : inventory) {
            testDrive(auto);
        }
    }

}
