package CrashCourse;
// If your Java file isn't running, you *might* need to add the following line at the top of your file: 
// package CrashCourse (the name of the folder that includes CrashCourse.java)

import java.util.ArrayList;

public class CrashCourse {     // class header. Always PascalCase. 

    public static void main(String[] args) {

        // Comments 
        
        /*  Multiline 
         Comment
         Here
         */

        System.out.print("Hello");
        System.out.println("World"); // prints on a new line
        System.out.println("Hello world");

        // VARIABLE DECLARATIONS:
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

        int d = 3 - 1; // d => 2
        d += 7; // d => 9

        System.out.println("d is equal to " + d);

        // increment and decrement by one:
        // --  ++
        d--; // 9 - 1 = 8
        d--; // 8 - 1 = 7
        d++; // 7 + 1 = 8
        System.out.println("d is NOW equal to " + d); // => 8

        //COMPARISONS (always returns true or false)
        //  <  >   <=   >=   ==   !=
        System.out.println(4 < 5);
        System.out.println(7 == 4);
        System.out.println(1 != 2);

        // LOGICAL OPERATORS 
        // In order of presedence: NOT:  !   AND: &&   OR: ||

        boolean f = false; boolean t = true;

        // predict output: true or false? 
        System.out.println(!f);  //true
        System.out.println(f && t);// false
        System.out.println(f || t); //true
        System.out.println(f || t && !f); // true

        System.out.println(f && t); // short circuits to FALSE after checking f && -- java does not need to check t.
        System.out.println(t || (f && t)); //short circuits after checking the first t.

        // CASTING (converting)
        int g = (int)5.5;
        System.out.println(g);
        double h = (double)5/6;
        System.out.println(h);

        // STRINGS 
        // Strings are not "primitive" data types, so we use a class Data Type String.
        String s1 = "Goodnight";
        String s2 = " and ";
        String s3 = "Goodbye";
        String result = s1 + s2 + s3;
        result += ", Cowboy.";
        System.out.println(result + "\n");

        int[] arry1 = new int[10];
        System.out.println(arry1);
        System.out.println("length: " + arry1.length);

        // assign values to positions in arry1
        arry1[0] = 11;
        arry1[1] = 2;

        System.out.println("Remainder: " + arry1[0] % arry1[1]);

        int[] arry2 = {34, 52, 3, 64, 32};
        System.out.println("arry2 memory address: " + arry2);

        //2D arrays (grid or a table or a matrix)

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

        ArrayList<String> arryLst = new ArrayList<>();

        arryLst.add("Word 1");
        arryLst.add("Word 2");
        arryLst.add("Word 3");
        arryLst.remove(0);
        arryLst.add(0, "Word 4");
        arryLst.set(2, "Word 5");

        System.out.println(arryLst);
        System.out.println(arryLst.size());
        System.out.println(arryLst.get(2));

        // Math class
        Math.max(5,9); //max value => returns 9
        Math.min(7,3); // min value => returns 3
        Math.sqrt(14); // square root
        Math.abs(-67);   // absolute value

        // CONDITIONALS

        // if    else if    else 

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

         // while loop 

         int x = 5;

         while (x < 10) {
            System.out.print(x + " ");
            x++;
         }

         System.out.println();

         // for loop
         // initialize variable at index; conditional; increment/decrement
         for(int i = 0; i < 5; i++) {
            System.out.println(i);
         }

         // enhanced for loop (only for reading values)
         ArrayList<String> animals = new ArrayList<>();
         animals.add("Sheep");
         animals.add("Deer");
         animals.add("Moose");
         System.out.println("ArrayList: " + animals);

         for (String s : animals) {
            System.out.println("We saw a " + s);
         }

         // printing values of an array with iteration

         double[] arry = {5.1, 2.2, 5.3, 3.4, 8.5};
         System.out.println("Memory address: " + arry);

        double element = arry[2];

         for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
         }

        int[][] arryMatrix = {  { 0, 32, 12 }  ,   { 7, 13, 22  } ,  { 6, 77, 100  }  };
        System.out.println(arryMatrix);

        for(int row = 0; row < arryMatrix.length; row++) {
            for(int col = 0; col < arryMatrix[row].length; col++) {
                System.out.print(arryMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}