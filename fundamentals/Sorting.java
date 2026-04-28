import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {

        int[] swapNumbers = {9, 3};

        SortingAlgorithms swap = new SortingAlgorithms(swapNumbers);

        System.out.println("Before Swap: " + Arrays.toString(swapNumbers));
        swap.swapNumbers();
        System.out.println("After Swap: " + Arrays.toString(swapNumbers));

        int[] selectionNumbers = {9, 3, 1, 5, 10, 2, 4, 8, 7, 6};

        SortingAlgorithms selection = new SortingAlgorithms(selectionNumbers);
        selection.selectionSort();
        System.out.println("Selection SOrt:" + Arrays.toString(selectionNumbers));

    }
}


class SortingAlgorithms {

        //data or attributes 
        private int[] list;

        //constructor 
        public SortingAlgorithms(int[] newList) {
            this.list = newList;
        } 

        //behavior
       // int[] swapNumbers = {9, 3}; 
        public void swapNumbers() {
            int temp = list[0]; //9
            list[0] = list[1]; // 9 <-- 3
            list[1] = temp;
        }   

        public void selectionSort() {

            int n = list.length;
            System.out.println("length of list: " + n);

            //out loop
            for (int i = 0; i < n; i++) {
                
                int minIndex = i;

                //inner loop 
                for (int j = i + 1; j < n; j++){        
                    //conditional logic to compare values
                    if (list[j] < list[minIndex]){
                        minIndex = j;
                    }
                }

            int temp = list[i]; //9
            list[i] = list[minIndex]; // 9 <-- 3
            list[minIndex] = temp;

            }

        }

}

