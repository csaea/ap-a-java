//------------------
// RANDOM GENERATORS in JAVA
//------------------

// Research the difference between Pseudorandom Number Generators (PRNG) vs True Random Numbers (TRNG)
// Watch Tom Scott video on lava lamps and randomness: https://www.youtube.com/watch?v=1cUUfMeOijg
// Optional video: Computerphile Random Numbers with LFSR (Linear Feedback Shift Register): https://www.youtube.com/watch?v=Ks1pw1X22y4

import java.util.Random;

public class RandomLesson {
    public static void main(String[] args) {
        System.out.println("------\n\n");

        /*
        ** PRECURSOR CHALLENGE **
        Create your own Pseudorandom Number Generator (PRNG) that utilizes a seed to output a random number.
        The seed should be a floating-point number with five total digits (including those before and after the decimal), and it must be greater than 100.0.
        Perform at least 3 different math calculations on it (i.e., addition, subtraction, and division).
        Use Math library to round the float DOWN to an integer.
        BONUS CHALLENGE: Make your random number output between 1 and 10.
        */
        // Example solution      
        double seed = 12.4444;
        double step1 = seed / 6.7;
        double step2 = step1 - 800;
        double step3 = step2 + 180843;
        double step4 = step3 % 10;
        int result = (int) Math.floor(step4) + 1; // round down and add 1
        System.out.println(result);

        // **** Java's Built-In Math.random method ****
        // Java has a built-in Math method called 'random' which only produces a random double between 0.0 (inclusive) and 1.0 (exclusive).
        // These values can be scaled or shifted to create various random values.

        // Example: Random integer between 1 and 100 using Math.random
        int randomInt = (int)(Math.random() * 100) + 1; // multiply by 100, floor implicitly, then add 1
        System.out.println("Random integer between 1 and 100: " + randomInt);

        // Example: Random double between 0.0 and 10.0
        double randomDouble = Math.random() * 10;
        System.out.println("Random double between 0.0 and 10.0: " + randomDouble);

        // **** Java's Random Class **** //

        System.out.println("\n--- Random Class ---\n");

        Random rand = new Random();

        // Random integer between 1 and 100
        int randomInteger = rand.nextInt(100) + 1; // nextInt(100) gives 0-99, so add 1 for 1-100
        System.out.println(randomInteger);

        // Random float between 0 and 1
        double randomFloat = rand.nextDouble();
        System.out.println(randomFloat);

        // Random selection from an array
        String[] myArray = {"taco", "burrito", "enchilada", "quesadilla"};
        int randomIndex = rand.nextInt(myArray.length);
        String randomSelection = myArray[randomIndex];
        System.out.println(randomSelection);

    }
}
