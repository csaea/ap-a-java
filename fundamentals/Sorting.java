import java.util.Arrays;

/*
 * SORTING ALGORITHMS REFERENCE  -  AP CS A
 * ----------------------------------------
 * This file demonstrates the three sorting algorithms in the AP CS A subset:
 *      1. Selection Sort
 *      2. Insertion Sort
 *      3. Merge Sort
 *
 * For each algorithm you should be able to:
 *      - Trace the algorithm by hand on a small array.
 *      - State its time complexity (Big-O) for best, average, and worst cases.
 *      - State its space complexity.
 *      - Identify which kind of input each algorithm handles efficiently.
 *
 * Conventions used throughout this file:
 *      - "n" = the number of elements in the array (list.length).
 *      - "i", "j", "k" are loop indices (they point AT array slots, they are
 *        not the values stored in those slots).
 *      - The "sorted region" grows on the LEFT side of the array as we work,
 *        and the "unsorted region" shrinks on the right.
 */
public class Sorting {
    public static void main(String[] args) {
        // Pre-lesson: simply swapping two values in an array.
        // Swapping requires a TEMPORARY variable because the first assignment
        // would otherwise overwrite the value we still need on the next line.
        int[] swapNumbers = {9, 3};

        // Each algorithm receives its own copy of the same starting data 
        int[] selectionNumbers = {9, 3, 1, 5, 10, 2, 4, 8, 7, 6};
        int[] insertionNumbers = {9, 3, 1, 5, 10, 2, 4, 8, 7, 6};
        int[] mergeNumbers     = {9, 3, 1, 5, 10, 2, 4, 8, 7, 6};

        // Arrays.toString(...) prints an array in human-readable form.
        // Plain System.out.println(array) would print the array's memory address (something like "[I@1540e19d").
        System.out.println("Unsorted ListS:   " + Arrays.toString(selectionNumbers));

        // ---- Pre-lesson: Swap ----
        // Before tackling a full sort, confirm that the swap building block
        // works as intended. Every comparison-based sort in this file relies
        // on the ability to exchange two array elements without losing data.
        SortingAlgorithms swap = new SortingAlgorithms(swapNumbers);

        System.out.println("Before Swap:     " + Arrays.toString(swapNumbers));
        swap.swapNumbers();
        System.out.println("After Swap:      " + Arrays.toString(swapNumbers));
        System.out.println();   // blank line separates the pre-lesson from the sorts
 

        // ---- Selection Sort ----
        SortingAlgorithms selection = new SortingAlgorithms(selectionNumbers);
        selection.selectionSort();
        System.out.println("Selection Sort:  " + Arrays.toString(selectionNumbers));

        // ---- Insertion Sort ----
        SortingAlgorithms insertion = new SortingAlgorithms(insertionNumbers);
        insertion.insertionSort();
        System.out.println("Insertion Sort:  " + Arrays.toString(insertionNumbers));

        // ---- Merge Sort ----
        SortingAlgorithms merge = new SortingAlgorithms(mergeNumbers);
        merge.mergeSort();
        System.out.println("Merge Sort:      " + Arrays.toString(mergeNumbers));
    }
}

class SortingAlgorithms {
    // The array we operate on.
    // IMPORTANT: this field stores a REFERENCE to the original array passed
    // into the constructor, not a copy. 
    private int[] list;

    // constructor
    public SortingAlgorithms(int[] list) {
        this.list = list;
    }

    /*
     * SWAP  -  a building block used by Selection Sort.
     * -------------------------------------------------
     * To exchange two values you CANNOT simply write:
     *      list[0] = list[1];
     *      list[1] = list[0];   // BUG: list[0] was just overwritten,

     * You must first save one value to a temporary variable.
     */
    public void swapNumbers() {
        int temp = list[0];   // save list[0] before it is overwritten
        list[0] = list[1];    // copy list[1] into slot 0
        list[1] = temp;       // copy the saved value into slot 1
    }

    /* =================================================================
     * SELECTION SORT
     * =================================================================
     * IDEA
     *      Repeatedly find the smallest value in the unsorted region and
     *      place it at the front of that region by swapping.
     *
     * LOOP INVARIANT
     *      After iteration i of the outer loop, the first (i+1) elements of
     *      the array are the (i+1) smallest values, already in sorted order.
     *      The sorted region therefore grows by exactly one slot per pass.
     *
     * COMPLEXITY
     *      Time:    O(n^2) for BEST, AVERAGE, and WORST cases. Selection
     *               sort performs the same number of comparisons regardless
     *               of input order, so a pre-sorted array runs no faster
     *               than a random one.
     *      Space:   O(1). Sorts in place using only the temp swap variable.
     *      Stable?  No. A swap can leap an equal value over another equal
     *               value, changing their relative order.

     * ================================================================= */
    public void selectionSort() {
        // Cache the length once. 
        int s = list.length;
        System.out.println("list.length returns: " + s);

        // OUTER LOOP: i marks the FIRST index of the unsorted region.
        // We stop at s - 1, not s, because once the first n-1 positions
        // are correct, the final element must already be the largest and
        // is therefore already in its correct slot. 
        for (int i = 0; i < s - 1; i++) {

            // Assume the element at index i is the smallest in the unsorted
            // region. We will revise this guess as we scan to the right.
            int minIndex = i;

            // INNER LOOP: scan everything to the right of i looking for a
            // value smaller than our current candidate.
            // Why j = i + 1 ? Because comparing list[i] with itself proves
            // nothing; we already know it is equal to itself.
            for (int j = i + 1; j < s; j++) {
                // If we find any value smaller than the current minimum,
                // remember WHERE it is (the index), not the value itself.
                // Tracking the INDEX is what allows us to swap correctly
                // after the inner loop finishes.
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }

            // After the inner loop, minIndex points at the smallest value
            // in the unsorted region. Swap it into position i.
            // (If minIndex == i, we swap a value with itself; harmless.)
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    /* =================================================================
     * INSERTION SORT
     * =================================================================
     * IDEA
     *      Treat the array as two regions: a sorted region on the left
     *      and an unsorted region on the right. Take the first unsorted
     *      value (call it the "key") and shift larger values one slot to
     *      the right until the key's correct position is found, then
     *      drop the key into that slot.
     *
     *      This is how most people sort a hand of playing cards.
     *
     * LOOP INVARIANT
     *      After iteration i of the outer loop, the first (i+1) elements
     *      are sorted relative to one another (though not yet relative to
     *      elements still in the unsorted region).
     *
     * COMPLEXITY
     *      Time:    Best     O(n)   - already-sorted input. The inner
     *                                 while-loop exits immediately every
     *                                 iteration.
     *               Worst    O(n^2) - reverse-sorted input. Every element
     *                                 must shift all the way to the front.
     *               Average  O(n^2).
     *      Space:   O(1). Sorts in place.
     *      Stable?  YES. The inner condition uses strict >, so equal
     *               values are never moved past one another.
     *
     * WHEN TO USE
     *      Small arrays, or arrays that are already nearly sorted. Many
     *      industrial sorting libraries (including Java's TimSort) fall
     *      back to insertion sort once a recursive sort has reduced
     *      sub-arrays to a small size.
     * ================================================================= */
    public void insertionSort() {
        int n = list.length;

        // We start at i = 1, not i = 0, because a single element by itself
        // is trivially sorted - there is nothing to compare it to.
        for (int i = 1; i < n; i++) {

            // "key" is the value we are about to insert into the sorted
            // region. We must save it now because the shifting step below
            // will overwrite list[i].
            int key = list[i];

            // j walks BACKWARD through the sorted region looking for the
            // correct insertion point.
            int j = i - 1;

            // Slide elements one slot to the right as long as they are
            // strictly greater than key. Stop when we either:
            //      (a) run off the front of the array (j < 0), or
            //      (b) find a value that is <= key.
            // Using > (not >=) is what makes this sort STABLE: equal
            // values are not displaced past one another.
            //
            // SHORT-CIRCUIT NOTE: the bounds check `j >= 0` MUST come
            // before `list[j] > key`. If it did not, evaluating list[j]
            // when j == -1 would throw ArrayIndexOutOfBoundsException.
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];   // shift the larger value right
                j--;                     // step backward to look at the next one
            }

            // When the loop exits, j points either at -1 or at a value
            // <= key. Either way, the correct slot for key is j + 1.
            //
            // The "+ 1" is the most common bug in insertion sort: it is
            // easy to forget that j was decremented ONE STEP PAST the
            // insertion point on the final iteration of the while loop.
            list[j + 1] = key;
        }
    }

    /* =================================================================
     * MERGE SORT
     * =================================================================
     * IDEA
     *      Divide and conquer. Recursively split the array into halves
     *      until each piece has only one element (which is trivially
     *      sorted), then merge the pieces back together in order.
     *
     * STRUCTURE
     *      Three methods cooperate:
     *          mergeSort()         public entry point; hides the recursion.
     *          mergeSortHelper()   recursive splitter.
     *          merge()             combines two adjacent sorted sub-arrays
     *                              into one sorted sub-array.
     *
     * COMPLEXITY
     *      Time:    O(n log n) for BEST, AVERAGE, and WORST cases.
     *                  "log n" because we halve the array log2(n) times
     *                          before reaching the base case.
     *                  "n"     because each level of recursion does O(n)
     *                          total work merging the pieces back together.
     *      Space:   O(n). Merge sort is NOT in-place; the merge step uses
     *               an auxiliary array. This extra memory is the trade-off
     *               for guaranteed n log n performance.
     *      Stable?  YES, because merge() uses <= when choosing from the
     *               left half (see the comparison in merge()).
     *
     * WHEN TO USE
     *      Large data sets, linked lists, and any situation where the
     *      guaranteed n log n upper bound matters more than memory
     *      overhead. Java's Arrays.sort() for objects uses a merge sort
     *      variant called TimSort.
     * ================================================================= */
    public void mergeSort() {
        // Public wrapper. The recursive version requires extra parameters
        // (the left and right indices of the slice it should sort) that the
        // outside caller should not have to know about. The wrapper hides
        // that complexity and provides a clean public interface.
        mergeSortHelper(list, 0, list.length - 1);
    }

    /*
     * Recursive splitter. Sorts the slice arr[left..right] INCLUSIVE on
     * BOTH ends. (Many APIs use exclusive right bounds; this one does not,
     * so be careful when comparing this code to other implementations.)
     */
    private void mergeSortHelper(int[] arr, int left, int right) {
        // BASE CASE: a slice with zero or one element is already sorted,
        // so do nothing and return up the call stack.
        //
        // Without this base case the recursion would never terminate and
        // you would get a StackOverflowError.
        if (left >= right) return;

        // Compute the midpoint of the current slice.
        //
        // For AP CS A array sizes this is fine, but be aware that on very
        // large arrays "(left + right) / 2" can overflow a 32-bit int.
        // The professional fix is:
        //      int mid = left + (right - left) / 2;
        int mid = (left + right) / 2;

        // RECURSIVE CASE: sort each half independently, then merge them.
        mergeSortHelper(arr, left, mid);          // sort the left half
        mergeSortHelper(arr, mid + 1, right);     // sort the right half
        merge(arr, left, mid, right);             // combine the two halves
    }

    /*
     * Merges two adjacent already-sorted slices of arr:
     *      left half  : arr[left   .. mid  ]
     *      right half : arr[mid+1  .. right]
     * The merged, sorted result is written back into arr[left..right].
     */
    private void merge(int[] arr, int left, int mid, int right) {
        // Auxiliary array sized exactly to hold the merged result.
        // The "+ 1" appears because both bounds are INCLUSIVE; a slice
        // from index left to index right contains (right - left + 1) items.
        int[] temp = new int[right - left + 1];

        int i = left;       // pointer into the left half of arr
        int j = mid + 1;    // pointer into the right half of arr
        int k = 0;          // pointer into temp (the destination)

        // PHASE 1  -  parallel walk.
        // Walk both halves at once. At each step, copy the SMALLER of the
        // two front elements into temp and advance that pointer.
        //
        // The "i++" and "k++" inside the brackets are POST-INCREMENTS:
        // the CURRENT value of i (or k) is used for indexing, AND THEN
        // i (or k) is incremented by one. So
        //      temp[k++] = arr[i++];
        // is equivalent to
        //      temp[k] = arr[i];
        //      k++;
        //      i++;
        //
        // Using <= (not <) when copying from the left half is what makes
        // this sort STABLE. When two values tie, the one originally on
        // the left wins, preserving its relative order.
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // PHASE 2  -  drain whichever half still has items.
        // Phase 1 ended because one half was fully consumed. Whatever
        // remains in the OTHER half is already sorted and is greater
        // than everything currently in temp, so we copy it straight over.
        // At most one of these two loops executes a non-zero number of
        // times - never both.
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // PHASE 3  -  write back into the original array.
        // Copy the merged data back into arr at the correct offset.
        // Note "arr[left + x]", NOT "arr[x]" - we are writing into the
        // slice that started at index `left`, which may be anywhere
        // inside the array, not necessarily index 0.
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}