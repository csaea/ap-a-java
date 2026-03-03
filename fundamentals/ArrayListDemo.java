import java.util.ArrayList;
// https://www.w3schools.com/java/java_arraylist.asp
import java.util.Collections;
// https://www.w3schools.com/java/java_ref_collections.asp
import java.util.Arrays;

public class ArrayListDemo {

	public static void main(String[] args) {

		// To create an arraylist you need to define its type with the class such as
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("After creation: " + list);

		// The type of the object must be the same as the type of the variable so
		// ArrayList<Integer> list2 = new ArrayList<Double>(); // ERR

		// Array list types also cannot be empty
		// ArrayList<> list3 = new ArrayList<Double>(); // ERR

		// To add an index you can add just the value or value + index. 
		// each new element is added to the end of the list
		list.add(0);
		list.add(3);
		list.add(5);
		list.add(3);
		list.add(9);
		System.out.println("Initial list: " + list);


		// to add to a specific index
		list.add(1, 5); // add 5 to the 1st index
		System.out.println("Insertion after first index: " + list);

		// to get the size
		System.out.println("Current size: " + list.size());

		// Instead of using [] to get elements, you must you arraylist .get() from the index

		System.out.println("Element at index 0: " + list.get(0)); // 0th index
		System.out.println("Element at index 3: " + list.get(3)); // 3rd index

		// to remove at an index do
		list.remove(4); // remove 4th index
		System.out.println("Removed 4th index: " + list);

		// but to remove the first occurance of an object do
		// [0, 3, 5, 3, 0]
		list.remove(Integer.valueOf(3));
		System.out.println("Removed first occurace of 3: " + list);
		// [0, 5, 3, 0]

		// to sort a list use the Collections class, which includes a lot of ALGORITHMS for dealing with arrays (ie collections of any type)
		Collections.sort(list);
		System.out.println("After sort: " + list);

		// to check if it has an element do
		System.out.println("Contains 5? " + list.contains(5)); // returns true if 5 is present

		// You can convert a regular array to an ArrayList. 
		Integer[] arr = list.toArray(new Integer[0]);
		// Note: the [0] is default, for whatever size.
		System.out.println(arr); // memory reference, unreadable, so:
		System.out.println("Converted list to array: " + Arrays.toString(arr));

		// Split the list by two portions

		// split list from 3 to 5
		ArrayList<Integer> splitList = new ArrayList<Integer>(list.subList(0, list.size()));
		System.out.println("Split list: " + splitList);

		// To clear all elements from a list do
		list.clear();
		System.out.println("Cleared list: " + list);


		// Filter out all odd numbers from a list
		// Create a arraylist with 10 random numbs
		// and remove all odds

		// make a guest list that allows the user to enter names
		// if the name exist tell the use "this person is invited"
		// continue until you type exit

		// Create a list of grocery items
		// if the user types in a food item print its index
		// if not print "Not found" and add it to the list

	}

}