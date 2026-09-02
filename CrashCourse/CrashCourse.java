package CrashCourse;
// If your Java file isn't running, you *might* need to add the following line and uncomment it, at the top of your file: 
// package CrashCourse (the name of the folder that includes CrashCourse.java)

public class CrashCourse {     // class header

    public static void main(String[] args) {

        // comments 
        
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

        int d = 3 - 1;
        d += 7; // => 9

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

        boolean e = false; boolean f = true;

        // predict output: true or false? 
        System.out.println(!e);  //true
        System.out.println(e && f);// false
        System.out.println(e || f); //true
        System.out.println(e || f && !e); // true

        System.out.println( e && f); // short circuits after checking e -- java does not need to check f.









    }
}