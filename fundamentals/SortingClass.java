import java.util.Arrays;

public class SortingClass {
    public static void main(String[] args) {


        
    }
}

class SortingAlgorithms {

    //this attribute will be the Array that is passed down into this class from the tester class
    private int[] list;

    public SortingAlgorithms(int[] list) {
        this.list = list;
    }

    int[] swapNumbers = {9, 3};

    public void swapNumbers() {

        int temp = swapNumbers[0]; //saves 9 in its own variable
        swapNumbers[0] = swapNumbers[1]; // both are 3
        swapNumbers[1] = temp; // // 3, 9

    }

    int[ ] ints = {47, 83, 12, 29, 61};

    public void selectionSort() {

        int s = ints.length; //5

        //out loop
        for (int i = 0; i < s - 1; i++) {
            int minIndex = i;

              //inner loop
              for (int j = i + 1; j < s; j++) {

                //conditional 
                if (ints[j] < ints[minIndex]) {
                        minIndex = j;
                }

                int temp = ints[i];
                ints[i] = ints[minIndex];
                ints[minIndex] = temp;

              }

   
    

        }
      

        //swap logic


    }
    
    
}
