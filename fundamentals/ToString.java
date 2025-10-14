// Java's built in toString() method returns the memory address of an object. 
// It is automatically called when we, for example, try to print the name of an object instance.   

class Car {

    String model;
    int year;
        
    // This custom method toString() overrides Java's built-in toString() method. 
    // Delete or comment-out this toString() method to see Java's built-in method at work. 
    public String toString() {
        return year + " " + model;
    }

}

public class ToString {

    public static void main(String[] args) {

        Car obj1 = new Car();
        obj1.model = "Nucleon";
        obj1.year = 1957;

        Car obj2 = new Car();
        obj2.model = "Fulgur";
        obj2.year = 1958;

        System.out.println(obj1.toString()); 
        System.out.println(obj2); 
        //returns Car@3d012ddd and Car@626b2d4a with Java's built-in method (your hex values will be different).
        //returns the object's values when we override toString() with our own method in the Car class. 

        //Note: you can actually delete the "toString()" called in this class (like I did for obj2). Java will automatically call it anyway.
    }
}    
