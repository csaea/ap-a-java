public class ArrayPractice {
    public static void main(String args[]) {

        // For LOOP TO DETERMINE THE MINIMUM ELEMENT IN AN ARRAY

        int[] array = { -20, 19, 1, 5, -1, 27, 19, 5 };
        int min = array[0]; // initialize the current minimum
        for (int index = 0; index < array.length; index++)
        if (array[index] < min)
        min = array[index];
        System.out.println("ALGO 1 - The minimum of this array is: " + min);

        // FOR LOOP TO FIND AN ELEMENT IN AN ARRAY

        int target = 6; // see if this value is in the array
        int[] numbers = { 0, 2, 4, 6, 8 };
        boolean targetFound = false;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == target) {
                targetFound = true;
                break;
            }
        }
        System.out.println("ALGO 2 - Target Found: " + targetFound);

        // HOW TO DETERMINE IF ALL ELEMENTS ARE THE SAME

        int[] nums = { 0, 0, 0, 1, 0 };
        boolean allSame = true;
        for (int index = 1; index < nums.length; index++) {
            if (nums[0] != nums[index]) {
                allSame = false;
                break;
            }
        }
        System.out.println("ALGO 3 - All elements the same? " + allSame);




        // Write the code that will find and display the median (middle number) of an array. 
        // Note: If the array has an even number of elements, average the middle two numbers. 

        int[] data = {1, 2, 4, 6, 7, 9, 10};
        double midpoint = (data.length)/2;
        double median = 0;
        if (data.length % 2 == 1){
            median = data[(int) midpoint];
        } else {
            int midnum1 = data[(int) (midpoint - 1)];
            int midnum2 = data[(int) midpoint];
            median = (midnum1 + midnum2)/2;
        }
        System.out.println("Median: " + median);

        int[] med = new int[]{13, 4, 12, 9, 3, 4};
        int len = med.length;
        if (len % 2 == 1){
            System.out.println(med[len/2]);
        }
        else{
            System.out.println( ((med[(len/2)-1]) + (med[len/2]))  / 2.0  );
        }



    }
}
