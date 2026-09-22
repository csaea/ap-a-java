/*
 * Dog class: blueprint for Dog objects.
 * Built from the Designing a Class: Dog exemplar.
 * 
 * To use an interactive shell, type jshell in terminal
 * Create a Dog object with: Dog fido = new Dog("Fido", "Mr. Mack", "Dachshund")
 * use dot operator followed by methods() and variables
 * To exit the shell, type /exit
 */

public class Dog
{
    //  Attributes (instance variables) -- private because they are only used in THIS class. 
    public String name;
    private String ownerName;
    private String breed;
    private int age;
    private double weight;
    private boolean isHungry;
    private boolean isHome;
    private int energyLevel;

    //  Constructor 
    public Dog(String name, String ownerName, String breed)
    {
        this.name = name;
        this.ownerName = ownerName;
        this.breed = breed;

        age = 0; // Java defaults to this
        weight = 0.0; // Java defaults to this 
        isHungry = true; // Java defaults to false, so I'm modifying it here 
        isHome = true;
        energyLevel = 100; 

        System.out.println("name: " + this.name + "\nownerName: " + this.ownerName + "\nbreed: " + this.breed);
    }


    //  Behaviors that only print -- they change nothing 
    public void bark()
    {
        System.out.println(name + " says: Woof!");
    }

    public void scratch()
    {
        System.out.println(name + " scratches the couch.");
    }

    public void bite()
    {
        System.out.println(name + " bites!");
    }

    //  Behaviors that modify attributes 


    public void fetch()
    {
        System.out.println("Go fetch!");
        if (energyLevel >= 15)
        {
            energyLevel -= 15;
            weight--;
            isHungry = true;
        }
        else
        {
            energyLevel = 0;
            weight--;
            isHungry = true;
        }
        System.out.println("energy: " + energyLevel);
    }

    public void leaveHome()
    {
        isHome = false;
        isHungry = true;
        System.out.println("Is " + name + " home? " + isHome);
    }

    public void comeHome()
    {
        isHome = true;
        isHungry = true;
        System.out.println("Is " + name + " home? " + isHome);
    }

    
    public void haveBirthday()
    {
        age++;
        isHungry = true;
        System.out.println("age: " + age);
    }


    public void sleep()
    {
        System.out.println("energy: " + energyLevel);
        if (energyLevel <= 30)
        {
            energyLevel += 30;
            weight -= 2.0;
        }
        else
        {
            energyLevel = 100;
        }
        System.out.println("energy: " + energyLevel);
    }

       public void eat(double foodPounds)
    {
        if (isHungry)
        {
            weight += foodPounds;
            isHungry = false;
        }
        else if (weight <= 10.0)
        {
            System.out.println(name + " is full but underweight, so eats anyway.");
            weight += foodPounds;
        }
        else
        {
            System.out.println(name + " is not hungry.");
        }
        System.out.println("weight: " + weight);
    }


    public void changeOwner(String newOwnerName)
    {
        System.out.println("Previous owner: " + ownerName);
        ownerName = newOwnerName;
        System.out.println("New owner: " + ownerName);
        isHungry = true;
    }


}