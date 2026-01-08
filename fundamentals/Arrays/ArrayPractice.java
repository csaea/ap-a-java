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

    }
}
