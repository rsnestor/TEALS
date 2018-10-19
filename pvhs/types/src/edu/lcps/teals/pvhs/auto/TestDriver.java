package edu.lcps.teals.pvhs.auto;


import edu.lcps.teals.pvhs.auto.pojo.F350;

import java.util.ArrayList;
import java.util.List;

public class TestDriver {

    private static List<F350> inventory = new ArrayList();

    public TestDriver() {
    }

    public static void main(String[] args) {

        inventory.add(new F350());

        TestDriver tester = new TestDriver();
        tester.testDrive(inventory);
    }

    public void testDrive(F350 truck) {
        System.out.println(truck.getClass().getSimpleName());
        System.out.printf("  %s\n  %s\n  %s\n",
                truck.accelerate(),
                truck.brake(),
                truck.haul());
    }

    public void testDrive(List<F350> vehicles) {
        for (F350 auto : inventory) {
            testDrive(auto);
        }
    }
}