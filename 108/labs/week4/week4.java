//
// Enter your name: Juana Patankar
// Enter your student ID: 201471422
//
import java.util.*;
import java.io.*;

class week4 {

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
		boolean found;
		for (int i = 0; i < size1; i++) {
			found = false;
			for (int j = 0; j < size2; j++) {
				if (array1[i] == array2[j]) {
					found = true;
				}
			}
			
			if (!found) {
				System.out.print(array1[i] + " ");
			}
		}
		System.out.println(" ");
	}
		
	// Input: array1[] with size1 entries and array2[] with size2 entries
	// for each entry in array2[], count how many times it appears in array1[]
	static void count(int array1[], int size1, int array2[], int size2) {
		for (int i = 0; i < size2; i++) {
			int count = 0;
			for (int j = 0; j < size1; j++) {
				if (array2[i] == array1[j]) {
					count++;
				}
			}
			System.out.print(count + " ");
		}
		System.out.println(" ");
	}

}
