/**
 * Dog: blueprint for Dog objects.
 * Built from the Designing a Class: Dog exemplar.
 */
package CrashCourse;

public class Dog
{
    //  Attributes (instance variables) -- private because they are only used in THIS class. 
    private String name;
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

        age = 0;
        weight = 0.0;
        isHungry = true;
        isHome = true;
        energyLevel = 100;
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

    public void eat(double foodPounds)
    {
        if (isHungry)
        {
            weight += foodPounds;
            isHungry = false;
        }
        else
        {
            System.out.println(name + " is not hungry.");
        }
    }

    public void runAway()
    {
        isHome = false;
        if (energyLevel >= 30)
        {
            energyLevel -= 30;
        }
        else
        {
            energyLevel = 0;
        }
    }

    public void comeHome()
    {
        isHome = true;
    }


    public void sleep()
    {
        if (energyLevel <= 50)
        {
            energyLevel += 50;
        }
        else
        {
            energyLevel = 100;
        }
    }

    public void haveBirthday()
    {
        age++;
    }


    public void changeOwner(String newOwnerName)
    {
        ownerName = newOwnerName;
    }


}