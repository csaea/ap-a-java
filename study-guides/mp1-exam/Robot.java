// CLASS: blueprint / template
// CLASS HEADER
public class Robot {

    // ATTRIBUTES / DATA: private instance variables
    private String name;
    private String serial;
    private double battery;
    private boolean isOn;

    // CONSTRUCTOR: no return type, same name as class
    // PARAMETERS: name, serial, battery
    public Robot(String name, String serial, double battery) {
        // THIS: instance variable vs. parameter
        this.name = name;
        this.serial = serial;
        this.battery = battery;
        // DEFAULT STATE: every Robot starts off
        this.isOn = false;
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