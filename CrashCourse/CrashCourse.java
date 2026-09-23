package CrashCourse;
// If your Java file isn't running, you *might* need to add the following line at the top of your file: 
// package CrashCourse (the name of the folder that includes CrashCourse.java)

import java.util.ArrayList;   // lets us use ArrayList, which isn't built in by default

public class CrashCourse {     // class header. Always PascalCase. The file name must match: CrashCourse.java

    // main is where every Java program starts running
    public static void main(String[] args) {

        // Comments 
        // Java ignores comments. Use them to explain your code.
        
        /*  Multiline 
         Comment
         Here
         */

        // Every statement in Java ends with a semicolon ;
        System.out.print("Hello");      // print stays on the same line
        System.out.println("World"); // println moves to a new line after printing
        System.out.println("Hello world");

        // VARIABLE DECLARATIONS:
        // Java makes you state the data type of every variable, and it can never change.
        // primitive variables:

        int a; // integer
        double b; // decimal, or float
        boolean c; // true or false;
        
        a = 4;
        b = 5.5;
        c = false; // lowercase

        // Arithmetic Operators 
        // + - / *  %
        // += -= /=  %=  (compound assignment operators)
        // % gives the remainder. int / int drops the decimal: 7 / 2 is 3

        int d = 3 - 1; // d => 2
        d += 7; // d => 9   (same as d = d + 7)

        System.out.println("d is equal to " + d);

        // increment and decrement by one:
        // --  ++
        d--; // 9 - 1 = 8
        d--; // 8 - 1 = 7
        d++; // 7 + 1 = 8
        System.out.println("d is NOW equal to " + d); // => 8

        //COMPARISONS (always returns true or false)
        //  <  >   <=   >=   ==   !=
        // == checks if two values are equal. A single = assigns a value.
        System.out.println(4 < 5);
        System.out.println(7 == 4);
        System.out.println(1 != 2);

        // LOGICAL OPERATORS 
        // In order of precedence: NOT:  !   AND: &&   OR: ||
        // ! flips a boolean, && needs BOTH sides true, || needs AT LEAST ONE true

        boolean f = false; boolean t = true;

        // predict output: true or false? 
        System.out.println(!f);  //true
        System.out.println(f && t);// false
        System.out.println(f || t); //true
        System.out.println(f || t && !f); // true

        System.out.println(f && t); // short circuits to FALSE after checking f && -- java does not need to check t.
        System.out.println(t || (f && t)); //short circuits after checking the first t.

        // CASTING (converting)
        // Put the new data type in parentheses before the value.
        int g = (int)5.5;   // truncates (chops off) the decimal => 5
        System.out.println(g);
        double h = (double)5/6;   // 5 becomes 5.0 first, so the division keeps its decimal
        System.out.println(h);

        // STRINGS 
        // Strings are not "primitive" data types, so we use a class Data Type String.
        // Strings use double quotes "". Join them with + (concatenation).
        String s1 = "Goodnight";
        String s2 = " and ";
        String s3 = "Goodbye";
        String result = s1 + s2 + s3;
        result += ", Cowboy.";
        System.out.println(result + "\n");   // \n adds a new line

        // ARRAYS
        // An array holds many values of ONE data type. Its size is fixed once created.
        int[] arry1 = new int[10];   // 10 slots, each starts at 0
        System.out.println(arry1);   // printing an array directly shows a memory address, not its values
        System.out.println("length: " + arry1.length);

        // assign values to positions in arry1
        // Indexes start at 0, so the last index is length - 1
        arry1[0] = 11;
        arry1[1] = 2;

        System.out.println("Remainder: " + arry1[0] % arry1[1]);

        int[] arry2 = {34, 52, 3, 64, 32};   // creates and fills an array in one line
        System.out.println("arry2 memory address: " + arry2);

        //2D arrays (grid or a table or a matrix)
        // An array of arrays. Always [row] first, then [column].

        int[][] arryGrid1 = new int[4][3]; //[rows][columns]
        // 0 0 0
        // 0 0 0
        // 0 0 0
        // 0 0 0

        System.out.println("Rows: " + arryGrid1.length);
        System.out.println("Columns: " + arryGrid1[0].length);

        int[][] arryGrid2 = { {7,8,9}, 
                              {4,5,6}, 
                              {1,2,3} };

        System.out.println(arryGrid2[2][2]); //access number 3
        System.out.println(arryGrid2[0][1] + arryGrid2[2][2]); //accesses two values and adds them

        System.out.println(arryGrid2);

        //ARRAYLISTS
        // Can be any size. Lots of  built-in functions to help. 
        // Avoid primitive data types. Special classes for Integer, Double, Boolean, String. Called "wrapper classes"
        // add puts an item at the end, remove(index) deletes, add(index, value) inserts,
        // set(index, value) replaces, get(index) reads, size() counts the items

        ArrayList<String> arryLst = new ArrayList<>();

        arryLst.add("Word 1");
        arryLst.add("Word 2");
        arryLst.add("Word 3");
        arryLst.remove(0);
        arryLst.add(0, "Word 4");
        arryLst.set(2, "Word 5");

        System.out.println(arryLst);   // unlike arrays, ArrayLists print their values
        System.out.println(arryLst.size());
        System.out.println(arryLst.get(2));

        // Math class
        // These methods RETURN a value. Nothing shows up unless you print it or store it in a variable.
        Math.max(5,9); //max value => returns 9
        Math.min(7,3); // min value => returns 3
        Math.sqrt(14); // square root
        Math.abs(-67);   // absolute value

        // CONDITIONALS

        // if    else if    else 
        // Java checks top to bottom and runs only the FIRST block that is true.
        // The condition goes in ( ) and the code to run goes in { }

         boolean tru = true; boolean fal = false; 
         
         if(tru) {
            System.out.println("Reached first condition");
        } else if (!fal){
            System.out.println("Reached second condition");
        }  
         else {
            System.out.println("Reached else");
         }

         // ITERATION
         // Iteration means repeating code with a loop.

         // while loop 
         // Repeats while the condition is true. Something inside must change, or it loops forever.

         int x = 5;

         while (x < 10) {
            System.out.print(x + " ");
            x++;
         }

         System.out.println();

         // for loop
         // initialize variable at index; conditional; increment/decrement
         // This one counts 0, 1, 2, 3, 4 and stops when i < 5 becomes false
         for(int i = 0; i < 5; i++) {
            System.out.println(i);
         }

         // enhanced for loop (only for reading values)
         // Reads each item in order: "for each String s in animals"
         ArrayList<String> animals = new ArrayList<>();
         animals.add("Sheep");
         animals.add("Deer");
         animals.add("Moose");
         System.out.println("ArrayList: " + animals);

         for (String s : animals) {
            System.out.println("We saw a " + s);
         }

         // printing values of an array with iteration
         // Loop through every index, from 0 to length - 1

         double[] arry = {5.1, 2.2, 5.3, 3.4, 8.5};
         System.out.println("Memory address: " + arry);

        double element = arry[2];

         for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
         }

        // Nested loops print a 2D array: the outer loop picks a row,
        // the inner loop walks across that row's columns
        int[][] arryMatrix = {  { 0, 32, 12 }  ,   { 7, 13, 22  } ,  { 6, 77, 100  }  };
        System.out.println(arryMatrix);

        for(int row = 0; row < arryMatrix.length; row++) {
            for(int col = 0; col < arryMatrix[row].length; col++) {
                System.out.print(arryMatrix[row][col] + " ");
            }
            System.out.println();   // new line after each row
        }

    }
}