//encapsulation: the `package` command declares a package name, which must match the file system path. 
package com.mypetproject;

//tester class, where we will instantiate test objects and call methods
public class Main {

    //main method: the doorway to your java program, which the JVC needs to run your code.
    public static void main(String[] args) {

        Pet newAnimal = new Pet("cat", 1);
        newAnimal.getSpecies();

        Cat newCat = new Cat(7, "orange", "cat", 1);
        newCat.meow();

    }

}