//
// Enter your name: Juana Patankar
// Enter your student ID: 201471422
//
import java.util.Arrays;
import java.lang.Math;
class COMP108W03 {

	// print the content of an array of size n
	static void printArray(int[] data, int n) {
		int i;

		for (i=0; i < n; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	// data[] is an array, n is size of array, key is the number we want to find
	static void seqSearch(int[] data, int n, int key) {
		int i, count;
		boolean found;

		// start sequential search on the array called data[]
		found = false;	// to indicate if the number is found
		i = 0;		// an index variable to iterate through the array
		count = 0;	// to count how many comparisons are made
		while (i<n && found==false) {
			if (data[i] == key) {
				found = true;
			} else {
				i = i+1;
			}
			count = count+1;
		}
		System.out.print("The number " + key + " is ");
		if (found == false)
			System.out.print("not ");
		System.out.println("found by sequential search and the number of comparisons used is " + count);
	}

	// data[] is an array in ascending order, n is size of array, key is the number we want to find
	// You can assume that data[] is already sorted
	// refer to Lecture 6
	/* static void binarySearch(int[] data, int n, int key) {
		System.out.println(n + " " + data + " " + key);
		if (n%2 == 0) {
			int comparisons = 0;
			int first = 0;
			int last = n-1;
			int mid = (int) Math.floor((last)/2.0);
			boolean found = false;
			while (data.length != 1 && found == false) {
				last = data.length - 1;
				System.out.println(last);
				first = 0;
				mid = last/2;
				comparisons += 1;
				if (key > data[mid]) {
					first = mid;
					data = Arrays.copyOfRange(data, first, last);
					first = 0;
					
				} else if (key < data[mid]) {
					last = mid;
					data = Arrays.copyOfRange(data, first, last);
				
				}
			}
			System.out.println(Arrays.toString(data));
			if (data[0] == key) {
				System.out.println("Found " + key);
				System.out.println("Number of comparisons: " + comparisons);
			} else if (data.length == 0) {
				System.out.println(key + " was not in the list");
			}
			
		}
	} */

	/* static void binarySearch(int[] data, int n, int key) {
		int first = 0;
		int last = n-1;
		boolean found = false;
		int comparisons = 0;
		int mid = (first + last)/2;
		while (first <= last && found == false) {
			comparisons++;
			if (key == data[mid]) {
				found = true;
			} else {
				if (key > data[mid]) {
					first = mid;
				} else {
					last = mid ;
				}
			}

			/* if (data[mid] > key) {
				first = mid;
				mid = (first + last)/2;
			} else if (data[mid] < key) {
				last = mid;
				mid = (first+last)/2;
			} else {
				found = true;
			} */
		/* } 
		if (found == true) {
			System.out.println("Found " + key);
			System.out.println("Number of comparisons required: " + comparisons);
		} else {
			System.out.println(key + " was not in the list");
		}
	} */

	static void binarySearch(int[] data, int n, int key) {
		int first = 0;
		int last = n-1;
		while (first <= last) {
			int mid = (first + last)/2;
			if (data[mid] > )
		}
	}

	// print the smallest number in the array of size n
	static void findMin(int[] data, int n) {
		int i, min;

		min = data[0];
		i = 1;
		while (i < n) {
			if (data[i] < min)
				min = data[i];
			i++;
		}
		System.out.println("The smallest number is " + min + ".");
	}

	// print the largest number in the array of size n
	// refer to Lecture 8
	static void findMax(int[] data, int n) {

	}

	// print the second smallest number in the array of size n
	// refer to Lecture 8
	static void findSecondMin(int[] data, int n) {

	}

	// print the second largest number in the array of size n
	// refer to Lecture 8
	static void findSecondMax(int[] data, int n) {

	}
	
	// print the smallest number and its position in an array of size n
	// Find the bug and fix it by altering ONE line of code
	static void bugOne(int[] data, int n) {
		int i, pos, min;

		pos = 0;
		min = 0;
		i = 1;
		while (i < n) {
			if (data[i] < min) {
				min = data[i];
				pos = i;
			}
			i++;
		}
		System.out.println("The smallest number is " + min + " at position " + pos + ".");
	}
}
