import java.util.*;
import java.io.*;

class appweek3 {

	private static Scanner keyboardInput = new Scanner (System.in);


	// main program
	public static void main(String[] args) throws Exception {
		int key=0, n=20;
		int[] data = {15, 25, 10, 30, 35, 20, 5, 60, 80, 65, 75, 70, 100, 55, 90, 45, 50, 85, 95, 40};
		int[] sortData = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};


		System.out.print("Content of data array: ");
		week3.printArray(data, n);
		System.out.print("Content of sorted data array (for binary search): ");
		week3.printArray(sortData, n);

		// get an integer input key to search
		// note: there is no error checking
		try {
			System.out.print("Enter an integer to search: ");
			key = keyboardInput.nextInt();
		}
		catch (Exception e) {
			keyboardInput.next();
			System.exit(0);
		}
		
		System.out.println();

		System.out.println("calling week3.seqSearch()...");
		week3.seqSearch(data, n, key);
		System.out.println();

		System.out.println("calling week3.binarySearch()...");
		week3.binarySearch(sortData, n, key);
		System.out.println();

		System.out.println("calling week3.findMin()...");
		week3.findMin(data, n);
		System.out.println();

		System.out.println("calling week3.findMax()...");
		week3.findMax(data, n);
		System.out.println();

		System.out.println("calling week3.findSecondMin()...");
		week3.findSecondMin(data, n);
		System.out.println();

		System.out.println("calling week3.findSecondMax()...");
		week3.findSecondMax(data, n);
		System.out.println();

		System.out.println("calling week3.bugOne()...");
		week3.bugOne(data, n);
		System.out.println();


	}

}

