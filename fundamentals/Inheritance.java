// INHERITANCE
// Below is a simplified example for INHERITANCE.
// If you want to create a superclass/subclass relationship, use INHERITANCE to directly share attributes *down* from super to sub classes.
// Use the 'extends' keyword to establish the super/sub relationship
// Now the sub class can access public attributes and methods from the super class!
// To test this, delete "extends A" from class B and read the errors.

class A {

    public String msg = "I am a public message from class A.";
    
    public void helloA() {
        System.out.println("Hello from Class A");
    }
    
}


class B extends A {

    public void goodbyeB() {
        System.out.println("Goodbye from Class B. " + msg);
    }
    
}

public class Inheritance {
    public static void main(String[] args) {
 
        B b = new B();

        b.helloA();   // prints: Hello from Class A
        b.goodbyeB();   // prints: Hello from Class B
    }
}


// Side note: If your classes have constructors, you can call: super() to use the with the correct number of paramaters.