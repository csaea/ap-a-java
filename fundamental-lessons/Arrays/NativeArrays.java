import java.util.Arrays;

/**
 * Native Arrays in Java: Code-Along Demo
 * Topics: declaring, default values, indexes, length, out-of-bounds,
 * parts of a for loop, enhanced for, skipping ahead, going backward.
 */

public class NativeArrays {

        public static void main(String[] args) {

            int[] scores = new int[5];

            System.out.println("Default values: " + Arrays.toString(scores));

            int[] nums = {3, 7, 1, 9, 4};

            System.out.println("Initializer list: " + Arrays.toString(nums));

            String[] names = new String[3];
            boolean[] flags = new boolean[3];
            double[] prices = new double[3];

            System.out.println("String defaults:  " + Arrays.toString(names));
            System.out.println("boolean defaults: " + Arrays.toString(flags));
            System.out.println("double defaults:  " + Arrays.toString(prices));

            // ===== 2. INDEXES AND LENGTH =====

            // Indexes start at 0. The last index is length - 1.
            System.out.println("\nFirst element nums[0]: " + nums[0]);
            System.out.println("Length (a field, no parentheses): " + nums.length);
            System.out.println("Last element nums[nums.length - 1]: " + nums[nums.length - 1]);

            nums[2] = 6;

            // // ===== 3. OUT OF BOUNDS =====
            // System.out.println(nums[5]);
            // System.out.println(nums[-1]);

        // ===== 4. PARTS OF A FOR LOOP =====
        //   for (initialization; condition; update)
        //   initialization -> runs once, sets the starting index
        //   condition      -> checked before every pass; loop stops when false
        //   update         -> runs after every pass

        // int[] nums = {3, 7, 6, 9, 4};

        for (int i = 0; i < nums.length; i++) {

                System.out.println(" index " + i + " -> value " + nums[i]);

        }

       // ===== 5. ENHANCED FOR LOOP =====
    
        // Gives you each VALUE, no index. Good for reading, not for changing.

        for (int i : nums) {
            System.out.println(" enhanced value " + i);
        }


        // Challenge 1: Double It
        // Multiply every element by 2, then print the array.
        int[] challengeOne = {3, 7, 1, 9, 4};
        // TODO: your loop here


        // EXAMPLE: Modified for loop that prints only even elements
        for (int i = 0; i < nums.length; i += 2) {

                System.out.println(" index " + i + " -> value " + nums[i]);

        }

         // Challenge 2: Every Other
        // Use i += 2 to add 10 to only the elements at even indexes, then print.
        int[] challengeTwo = {3, 7, 1, 9, 4};
        // TODO: your loop here

        // Challenge 3: Replace Negatives
        // Change every negative number to 0, then print.
        int[] temps = {5, -3, 8, -1, 0, -7};
        // TODO: your loop here
        // HINTS: use an if statement in each pass of the loop
        // redefine element value like this: nums[2] = 6;

        // Challenge: Curve the Scores
        int[] scorings = {85, 62, 97, 45, 70, 99};
        // Add 5 to every score, but no score can go above 100. 

        for (int i = 0; i < scorings.length; i++) {
                scorings[i] = Math.min(scorings[i] + 5, 100);
                // if (scorings[i] > 100) {
                //         scorings[i] = 100;
                // }
        }

        System.out.println(Arrays.toString(scorings));


        // Challenge: Find the Highest
        // int[] temps = {58, 71, 64, 80, 77, 69};
        // Use a loop to find the highest temperature and the index it's at, then print both. Use Math.max()!

        int highest = temps[0];
        int highestIndex = 0;
        
        for (int i = 1; i < temps.length; i++) {
                // deals with value
                highest = Math.max(highest, temps[i]);

                // deals with the index
                if (highest == temps[i]) {
                        highestIndex = i;
                }
                
        }

        // Challenge: Random Fill
        // int[] nums = new int[10];
        // Loop 10 times. Each time, use Math.random() to get a random number from 1 to 100 and a random index from 0 to 9, then put the number at that index. Print the array. 
        // Then answer: why are some spots still 0?






        }
}