package com.mypetproject;

//Inheritance: the `extends` keyword declares Pet as the superclass of Cat. 
//With `extends `, the Cat class now `inherits` attributes and behaviors from Pet.  
public class Cat extends Pet {

    //attributes
    private int age;
    private String color;

    //constructor method
    public Cat(int age, String color, String species, int id){
        //the super() method accesses the public variable in the superclass, Pet.java. It's like calling Pet(), so it needs the correct number of arguments!
        super(species, id);
        this.age = age;
        this.color = color;
    }

    //behaviors
    public void meow() {
        System.out.println("Mrkgnao! the " + color + " " + species + " cried." );
    }
}