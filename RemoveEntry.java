//Delete random elements out of array until empty

import java.util.Arrays;
import java.util.Random;

public class RemoveEntry{
	public static void main(String args[]) throws IndexOutOfBoundsException{
		
		int[] a = {101, 102, 103, 104, 105};
		System.out.println();
		System.out.println("Test array: " + Arrays.toString(a));
		RemoveAll(a);
	}

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
		System.out.println("BEFORE: " + Arrays.toString(array));

		array = remove(array, temp);	//Array is equal to itself without random(temp) element

		System.out.println("To be removed: " + temp);
		System.out.println("AFTER: " + Arrays.toString(array));
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

	//Create random array of input size
	public static int[] RandomArray(int[] array, int n)
	{
		return null;
	}
}