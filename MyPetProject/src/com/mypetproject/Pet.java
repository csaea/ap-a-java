package com.mypetproject;

public class Pet {

    //attribute fields:
    public String species;
    public int id;

    //constructor method:
    public Pet(String species, int id) {
        this.species = species; 
        this.id = id; 
    }    
        //the first 'this.species' refers to the VARIABLE 'species' in THIS class for each new object.
        //the second 'species' refers to the PARAMTER, whose value was entered when creating the new object: ex., Pet("cat").  

    //behaviors:
    public void getSpecies(){
        System.out.println("This pet is a: " + species + " \nId: " + id);
    }
}
