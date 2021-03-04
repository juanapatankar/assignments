//
// Enter your name: Juana Patankar
// Enter your student ID: 201471422
//
/* Time complexity of notExists: O(n^2)
Time complexity of count: O(n^2) */

import java.util.*;
import java.io.*;

class COMP108W04 {

	// print the content of an array of size n
	static void printArray(int[] data, int n) {
		int i;

		for (i=0; i < n; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	// Input: array1[] with size1 entries and array2[] with size2 entries
	// print all entries of array1[] that does not exist in array2[]
	static void notExists(int array1[], int size1, int array2[], int size2) {
		for (int i = 0; i < size1; i++) {
			boolean foundRequest = false;
			for (int j = 0; j < size2; j++) {
				if (array2[j] == array1[i]) {
					foundRequest = true;
				}
			}
			if (!foundRequest) {
				System.out.println(array1[i]);
			}
		}
	}
		
	// Input: array1[] with size1 entries and array2[] with size2 entries
	// for each entry in array2[], count how many times it appears in array1[]
	static void count(int array1[], int size1, int array2[], int size2) {
		for (int j = 0; j < size2; j++) {
			int count = 0;
			for (int i = 0; i < size1; i++) {
				if (array1[i] == array2[j]) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
