// If you want to create a superclass/subclass structure, use inheritance to directly share attributes *down* from super to sub classes.
// Use the 'extends' keyword to establish the super/sub relationship
// In the subclass, you can call the special method super() to access the superclass.

class A {
    public String msg = "I am a public message from class A.";
    
    public void greet() {
        System.out.println("Hello from Class A");
    }
}


class B extends A {

    public void goodbye() {
        System.out.println("Goodbye from Class B. " + msg);
    }
    
}

public class Inheritance {
    public static void main(String[] args) {
 
        B b = new B();

        b.greet();   // prints: Hello from Class A
        b.goodbye();   // prints: Hello from Class B
    }
}
