// TESTER CLASS: separate class, holds main
public class RobotTester {

    // MAIN METHOD: program entry point
    public static void main(String[] args) {

        // OBJECT: specific instance of a class
        // INSTANTIATION: new + constructor call
        // ARGUMENTS: "Rover", "RX-77-B", 8.0
        Robot r1 = new Robot("Rover", "RX-77-B", 8.0);
        Robot r2 = new Robot("Unit", "TK-21", 3.0);

        // println CALLS toString AUTOMATICALLY
        System.out.println(r1);                  // Rover [RX-77-B]

        // ALIASING: two references, ONE object
        Robot r3 = r2;
        r3.setName("Scout");
        r3.turnOn();
        System.out.println(r2.getName());        // Scout
        System.out.println(r2.isOn());           // true

        // == : same object (reference)
        Robot r4 = new Robot("Rover", "RX-77-B", 8.0);
        System.out.println(r2 == r3);            // true
        System.out.println(r1 == r4);            // false: same data, different objects

        // == vs .equals() on Strings
        String s1 = "RX-77-B";
        String s2 = new String("RX-77-B");
        System.out.println(s1 == s2);            // false
        System.out.println(s1.equals(s2));       // true

        // indexOf: first occurrence, 0-based
        String word = "MISSISSIPPI";
        System.out.println(word.indexOf("SS"));  // 2
        System.out.println(word.indexOf("I"));   // 1
        System.out.println(word.indexOf("Q"));   // -1

        // CASE-SENSITIVITY
        System.out.println(r1.serialContains("77"));       // true
        System.out.println(r1.serialContains("rx"));       // false
        System.out.println(r1.hasSerial("RX-77-B"));       // true
        System.out.println(r1.hasSerial("rx-77-b"));       // false

        // CALLING A METHOD ON AN OBJECT
        r4.addBattery(2.5);         // OK: double argument
        r4.addBattery(2);           // OK: int WIDENS to double
        // r4.addBattery("2.5");    // ERROR: String is not a double
        // Robot.addBattery(2.5);   // ERROR: non-static method, needs an object
        System.out.println(r4.getBattery());   // 12.5

        // TRACING: track each object's state
        r2.chargeFrom(r1, 5.0);     // r1: 3.0   r2: 8.0
        r1.chargeFrom(r2, 9.0);     // GUARD FAILS: no change
        r1.chargeFrom(r2, 2.0);     // r1: 5.0   r2: 6.0
        System.out.println(r1.getBattery() + " " + r2.getBattery());  // 5.0 6.0
    }
}