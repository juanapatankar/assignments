//
// Prepared by Prudence Wong (2021-02-01)
//
import java.util.*;
import java.io.*;

class week2App {

	private static Scanner keyboardInput = new Scanner (System.in);


	// main program
	public static void main(String[] args) throws Exception {
		int x=0, y=0;

		// get two integer input x and y
		// note: there is no error checking
		try {
			System.out.print("Enter a positive number: ");
			x = keyboardInput.nextInt();
			System.out.print("Enter a larger number: ");
			y = keyboardInput.nextInt();
		}
		catch (Exception e) {
			keyboardInput.next();
		}

		System.out.println();

		System.out.println("calling week2.sumFromOne(" + x + ") ...");
		week2.sumFromOne(x);
		System.out.println();

		System.out.println("calling week2.sumFromOne(" + y + ") ...");
		week2.sumFromOne(y);
		System.out.println();

		System.out.println("calling week2.sumFromTo(" + x + ", " + y + ") ...");
		week2.sumFromTo(x, y);
		System.out.println();

		System.out.println("calling week2.isFactor(" + x + ", " + y + ") ...");
		week2.isFactor(x, y);
		System.out.println();

		System.out.println("calling week2.isFactor(" + y + ", " + x + ") ...");
		week2.isFactor(y, x);
		System.out.println();

		System.out.println("calling week2.multipleFactor(" + x + ", " + y + ") ...");
		week2.multipleFactor(x, y);
		System.out.println();
		
		System.out.println("calling week2.bugOne(" + x + ", " + y + ") ...");
		week2.bugOne(x, y);
		System.out.println();
		

	}

}

