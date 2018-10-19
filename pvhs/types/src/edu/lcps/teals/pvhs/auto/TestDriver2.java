package edu.lcps.teals.pvhs.auto;


import edu.lcps.teals.pvhs.auto.pojo.F350;
import edu.lcps.teals.pvhs.auto.pojo.Taurus;

import java.util.ArrayList;
import java.util.List;

public class TestDriver2 extends TestDriver {

    private static List inventory = new ArrayList();

    public static void main(String[] args) {

        inventory.add(new F350());
        inventory.add(new Taurus());

        TestDriver2 tester = new TestDriver2();
        tester.testDrive(inventory);

    }

    public void testDrive(Taurus car) {
        //redundancy (cut-n-paste)
        System.out.println(car.getClass().getSimpleName());
        System.out.printf("  %s%n  %s%n  %s%n  %s%n",
                car.accelerate(),
                car.brake(),
                car.openTrunk(),
                car.openSunroof());
    }

    public void testDrive(List vehicles) {
        for (Object auto : inventory) {
            //bad coding practice
            if (auto instanceof F350)
                testDrive((F350) auto);
            else if (auto instanceof Taurus)
                testDrive((Taurus) auto);
            else
                System.out.printf("Unknown vehicle!!!%n%s", auto);
        }
    }
}
