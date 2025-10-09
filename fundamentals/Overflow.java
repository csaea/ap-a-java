public class Overflow {

    public static void main (String[] args) {

        // Start with example of 3 bits. 2 ^ 3 = 8 possible values. 0 - 7.
        // What happens when I want to represent 8? 
        // I'd get an overflow error. 
        // Programs are designed to reset after overflow. 

        // Integer overflow for int (32 bits)
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Max int: " + maxInt);
        int overflowInt = maxInt + 1;  // wraps around to the minimum int
        System.out.println("After overflow: " + overflowInt);

        //Why? Integers are stored in fixed 32 bits using two's complement.
        // When the highest bit flips, it becomes negative.
        // There’s no warning—just arithmetic pretending nothing happened.

        System.out.println();

        double huge = 1e308; // close to Double.MAX_VALUE
        System.out.println("Huge double: " + huge);
        // double overflowDouble = 1e309;  // exceeds range
        double overflowDouble = 1e308 * 2;  // exceeds range
        System.out.println("After overflow: " + overflowDouble); // prints Infinity
        //not really infinity, just "beyond what Java can represent".

        System.out.println();

        // return to example of 3 bits. Add a bit to front to sign positive or negative. 
        // 2 ^ 3 = 8 possible values. 0 - 7.
        // What happens when I want to represent 8? I'd need another bit.
        // Programs are designed to reset after overflow. 

        double tiny = Double.MIN_VALUE; // close to Double.MIN_VALUE

        
        // Why?
        // When a value’s magnitude drops below what 52 bits of precision can encode,
        // it collapses quietly to zero. A vanishing act in binary.
 
    }

}