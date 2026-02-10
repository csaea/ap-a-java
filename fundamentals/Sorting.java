import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {

        int[] selectionNumbers = {9, 3, 1, 5, 10, 2, 4, 8, 7, 6};
        int[] insertionNumbers = {9, 3, 1, 5, 10, 2, 4, 8, 7, 6};
        int[] mergeNumbers = {9, 3, 1, 5, 10, 2, 4, 8, 7, 6};

        System.out.println("Unsorted Lists: " + Arrays.toString(selectionNumbers));

        // test SelectionSort
        SortingAlgorithms selection = new SortingAlgorithms(selectionNumbers);
        selection.selectionSort();

        System.out.println("Selection Sort: " + Arrays.toString(selectionNumbers));

        // test InsertionSort
        SortingAlgorithms insertion = new SortingAlgorithms(insertionNumbers);
        insertion.insertionSort();

        System.out.println("Insertion Sort: " + Arrays.toString(insertionNumbers));

        // test MergeSort
        SortingAlgorithms merge = new SortingAlgorithms(mergeNumbers);
        merge.mergeSort();

        System.out.println("Merge Sort: " + Arrays.toString(mergeNumbers));
    }
}

class SortingAlgorithms {

    //only attribute will be the list that is passed down into this class from the tester class
    private int[] list;

    public SortingAlgorithms(int[] list) {
        this.list = list;
    }

    public void selectionSort() {

        // store size of list so we can loop over it
        int s = list.length;
        System.out.println("list.size() returns: " + s);

        // use nested for loops to compare two index values in list
        // i and j are common variables used to store two different index positions.
        for (int i = 0; i < s - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < s; j++) { //why i + 1? bc we don't need to compare i with itself. 
                // comparing  logic: directly compare integers using < and if current j is less than minIndex, make that the new minIndex. Why?
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            // swapping logic inside nested for loop
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    public void insertionSort() {
        int n = list.length;

        for (int i = 1; i < n; i++) {
            int key = list[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }

    public void mergeSort() {
        mergeSortHelper(list, 0, list.length - 1);
    }

    private void mergeSortHelper(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Clean up remaining elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}
