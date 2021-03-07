//
// Enter your name: Juana Patankar
// Enter your student ID: 201471422
//

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

	 static void binarySearch(int[] data, int n, int key) {
		int first = 0;
		int last = n-1;
		boolean found = false;
		int comparisons = 0;
		int mid = (first + last)/2;
		while (first <= last && found == false) {
			mid = (first+last)/2;
			if (data[mid] == key) {
				comparisons++;
				found = true;
				break;
			} else {
				
				if (data[mid] < key) {
					comparisons++;
					first = mid+1;
				} else {
					if (n % 2 == 0) {
						comparisons++;
						last = mid - 1;
					} else { 
						last = mid;
					}
					
				}
			}
		}
		if (found == true) {
			System.out.println("Found " + key + " in the list");
			System.out.println("Number of comparisons required: " + comparisons);
		}
		else {
			System.out.println(key + " is not in the list");
			System.out.println("Number of comparisons required: " + (comparisons));
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
		int max = data[0];
		for (int i = 1; i < n; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		System.out.println("Highest number: " + max);
	}

	// print the second smallest number in the array of size n
	// refer to Lecture 8
	static void findSecondMin(int[] data, int n) {
		int min = data[0];
		for (int i = 1; i < n; i++) {
			if (data[i] < min) {
				min = data[i];
			}
		}
		int sndmin = 1000000000;
		for (int i = 0; i < n; i++) {
			if (data[i] > min && sndmin > data[i]) {
				sndmin = data[i];
			}
		}
		System.out.println("Smallest value: " + min);
		System.out.println("Second smallest value: " + sndmin);
	}

	// print the second largest number in the array of size n
	// refer to Lecture 8
	static void findSecondMax(int[] data, int n) {
		int sndmax = 0;
		int max = data[0];
		for (int i = 1; i < n; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}

		for (int i = 0; i < n; i++) {
			if (data[i] > sndmax && data[i] < max) {
				sndmax = data[i];
			}
		}
		System.out.println("Largest value: " + max);
		System.out.println("Second largest value: " + sndmax);
	}
	
	// print the smallest number and its position in an array of size n
	// Find the bug and fix it by altering ONE line of code
	static void bugOne(int[] data, int n) {
		int i, pos, min;
		
		pos = 0;
		min = data[0];
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