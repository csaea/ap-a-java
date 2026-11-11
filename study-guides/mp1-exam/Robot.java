// CLASS: blueprint / template
// CLASS HEADER
public class Robot {

    // ATTRIBUTES / DATA: private instance variables
    private String name;
    private String serial;
    private double battery;
    private boolean isOn;

    // STATIC VARIABLE: belongs to the CLASS, shared by all Robots
    private static int robotCount = 0;

    // CONSTRUCTOR: no return type, same name as class
    // PARAMETERS: name, serial, battery
    public Robot(String name, String serial, double battery) {
        // THIS: instance variable vs. parameter
        this.name = name;
        this.serial = serial;
        this.battery = battery;
        // DEFAULT STATE: every Robot starts off
        this.isOn = false;

        // STATIC UPDATE: every new Robot bumps the shared count
        robotCount++;

    }

    // MATH.RANDOM(): returns a double from 0.0 (inclusive) up to 1.0 (exclusive),
    // a different value each call. Multiplying by 10 stretches that range to
    // 0.0 up to 10.0.
    //
    // MATH.MAX(a, b): compares two numbers and returns the larger one.
    // Here it compares 0 with (battery - drain). If the result would be
    // negative, Math.max returns 0 instead, so battery never goes below zero.

    // This method drains a random amount of battery (0 to 10) without letting it drop below zero.
    public void randomDrain() {
        double drain = Math.random() * 10;
        battery = Math.max(0, battery - drain);
    }

    // STATIC METHOD: called on the class -> Robot.getRobotCount()
    public static int getRobotCount() {
        return robotCount;
    }

    // GETTER / ACCESSOR: return type matches variable
    public String getName() {
        return name;
    }

    public double getBattery() {
        return battery;
    }

    // BOOLEAN GETTER: "is" naming
    public boolean isOn() {
        return isOn;
    }

    // SETTER / MUTATOR: void, PARAMETER receives ARGUMENT
    public void setName(String newName) {
        name = newName;
    }

    // BEHAVIOR / METHOD: void, changes state
    public void turnOn() {
        isOn = true;
    }

    // METHOD SIGNATURE: name + parameter list (double)
    public void addBattery(double amt) {
        battery = battery + amt;
    }

    // OBJECT AS PARAMETER: pulls from another Robot
    // CONDITIONAL GUARD: donor must have MORE than amt
    public void chargeFrom(Robot donor, double amt) {
        if (donor.getBattery() > amt) {
            donor.addBattery(-amt);   // DOT OPERATOR: call on other object
            battery = battery + amt;
        }
    }

    // indexOf: returns index, or -1 if not found
    // CASE-SENSITIVE
    public boolean serialContains(String part) {
        return serial.indexOf(part) >= 0;
    }

    // .equals(): compares contents, not references
    public boolean hasSerial(String s) {
        return serial.equals(s);
    }

    // toString: OVERRIDES Object's version
    // STRING CONCATENATION
    public String toString() {
        return name + " [" + serial + "]";
    }
}