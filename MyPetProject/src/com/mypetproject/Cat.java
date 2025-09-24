package com.mypetproject;

//Inheritance: the `extends` keyword declares Pet as the superclass of Cat. 
//With `extends `, the Cat class now `inherits` attributes and behaviros from Pet.  
public class Cat extends Pet {

    //attributes
    private int age;
    private String color;

    //constructor method
    public Cat(int age, String color, String species){
        //the super() method accesses the public variable in the superclass, Pet.java
        super(species);
        this.age = age;
        this.color = color;
    }

    //behaviors
    public void meow() {
        System.out.println("Mrkgnao! the " + color + " " + species + " cried." );
    }
}