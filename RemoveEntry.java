//Algorithm for deleting random integers out of array until empty
//..Also time is taken for each array in seconds

import java.util.*;
import java.lang.Math;

public class RemoveEntry{
	public static void main(String args[]) {
		
		PrintInfo();
		System.out.println("Enter array size: ");
		//Take user input as value n (For B)
		int n = nextRandomInt();

		//Testing runtime for A
		long startTimeA = System.nanoTime();
		TestA();
		long endTimeA = System.nanoTime();
		long elapsedTimeA = (endTimeA - startTimeA);
		//Testing runtime for B
		long startTimeB = System.nanoTime();
		TestB(n);
		long endTimeB = System.nanoTime();
		long elapsedTimeB = (endTimeB - startTimeB);

		//Converting nanoseconds to seconds
		double secondsA = (double)elapsedTimeA / 1000000000.0;
		double secondsB = (double)elapsedTimeB / 1000000000.0;
		//Print time results
		System.out.println("Time taken in seconds for A: " + secondsA);
		System.out.println("Time taken in seconds for B: " + secondsB);
	}

	//**************************************
	//Start of algorithm
	//**************************************

	//Gets random value in the array
	public static int getRandom(int[] array) 
	{
		int r = new Random().nextInt(array.length);
		return array[r];
	}

	//Finds index of value in array
	public static int findIndexOf(int[] array, int c) 
	{
		int indexOfFind = 0;
		for (int i = 0; i < array.length; i++) {
			if (c == array[i]) {
				indexOfFind = i;
				break;
			}
		}
		return indexOfFind;
	}

	//Remove an element from the array
	public static int[] remove(int[] array, int s)
	{
		int g = findIndexOf(array, s);
		array[g] = array[array.length - 1];
		int[] newArray = new int[array.length - 1];

		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}

	//Remove a random element from the array
	public static int[] RemoveRandom(int[] array) 
	{
		int temp = getRandom(array);

		System.out.println();
		System.out.println("Before: " + Arrays.toString(array));

		array = remove(array, temp);	//Array is equal to itself without random(temp) element

		System.out.println("Removed: " + temp);
		System.out.println("After: " + Arrays.toString(array));
		System.out.println();
		return array;

	}

	//Remove all elements from array one at a time, randomly, until empty
	public static int[] RemoveAll(int[] array)
	{
		int length = array.length;

		for(int i = 0; i < length; i++){
			array = RemoveRandom(array);
		}
		return array;
	}

	//*******************************************
	//End of Algorithm
	//*******************************************

	//Create random array of input size n
	public static int[] RandomArray(int n)
	{
		int[] p = new int[n];
		Random r = new Random();

		for (int i = 0; i < n; i++)
		{
			int Random = (int)(Math.random()*n);
			p[i] = Random;
		}
		return p;
	}

	public static int[] TestA()
	{
		int[] a = {101, 102, 103, 104, 105};
		System.out.println();
		System.out.println("Test array A " + Arrays.toString(a));
		return RemoveAll(a);
	}

	//Test B, using random array of size n with values between 0 and n
	public static int[] TestB(int n)
	{
		int[] b = RandomArray(n);
		System.out.println();
		System.out.println("Test Array B " + Arrays.toString(b));
		return RemoveAll(b);
	}

	//Auxillary function for print statements
	public static void PrintInfo()
	{
		System.out.println();
		System.out.println("|| This algorithm removes a random value from an array until it is empty.");
		System.out.println("|| Test Array A is a fixed array containing 5 values.");
		System.out.println("|| Test Array B is an array of size n filled with values between 0 to n.");

		System.out.println();
		System.out.println("|| As the input value (n) increases, the time taken for B increases.");
		System.out.println("|| Random number generation in java has a time complexity of O(1).");
		System.out.println("|| Try comparing array sizes of 10 then 1000.");
		System.out.println("|| .. Or 50 then 5000.");
		System.out.println();
	}

	//User interger input as n
	public static int nextRandomInt()
	{
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			return n;
	}
}

