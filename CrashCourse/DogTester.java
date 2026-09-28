/*
 * DogTester: client class that creates Dog objects and calls their methods.
 *
 * Private fields are invisible here; only public methods are reachable.
 * Inside Dog, "this" means whichever object called the method,
 * so fido.bark() and rex.bark() use different name fields.
 *
 * Compile: javac Dog.java DogTester.java
 * Run:     java DogTester
 */

public class DogTester
{
    public static void main(String[] args)
    {
        // Constructor: arguments land in parameters, then this.field = parameter
        Dog fido = new Dog("Fido", "Mr. Mack", "Dachshund");

        Dog rex = new Dog("Rex", "Ms. Lee", "Beagle");

        // Print-only behaviors: same method, different object, different name
        // fido.name;
        fido.getName();
        fido.setName("Didi");
        fido.getName();
        // Now we have access to the otherwise private name, from the getter
        String dogName = fido.getName();
        System.out.println("From Tester Class: " + dogName);
        System.out.println("Good doggo," + fido.getName() + "!");
        System.out.println("Uppercase: " + fido.getName().toUpperCase());


        fido.bark();
        rex.bark();
        fido.scratch();
        rex.bite();

        fido.eat(12.5);

        for (int i = 0; i <= 3; i++)
        {
            fido.fetch();
        }

        fido.sleep();
        fido.sleep();
        rex.sleep();

        rex.leaveHome();
        rex.comeHome();

        // Age
        fido.haveBirthday();
        fido.haveBirthday();
        rex.haveBirthday();

        fido.changeOwner("Dr. Wigglesworth");
    }
}