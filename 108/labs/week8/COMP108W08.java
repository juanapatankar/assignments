import java.awt.HeadlessException;

//
// by Prudence Wong 2021-03-20
//
// Name: Juana Patankar
// Student ID: 201471422
//
// Time complexity: 
// Express the worst case time complexity of your algorithm in big-O notation.
// You can assume that there are 
// n nodes in the original database list, 
// r requests in the request sequence, and 
// k distinct requests in the request sequence.
// Justify your answer.
//
// notExists: Searches iteratively through 2 unsorted lists. Therefore O(rn) worst case
//
// count: O(nr) as each movie ID is searched for in the list of length r.   
//

class COMP108W08 {

	public Node head, tail;
	
	public COMP108W08() {
		head = null;
		tail = null;
	}


	// Input: array[] with size entries
	// print all entries of array[] that does not exist in the list
	public void notExists(int array[], int size) {
		for (int i = 0; i < size; i++) {
			Boolean found = false;
			Node curr = head;
			while (curr != null && !found) {
				if (curr.data == array[i]) {
					found = true;
				}
				curr = curr.next;
			}
			if (!found) {
				System.out.println("Request " + i + ": " + array[i]);
			}
		}
	}
	
	// Input: array[] with size entries 
	// for each entry in the list, count how many times it appears in array[]
	public void count(int array[], int size) {
		Node curr = head;
		while (curr != null) {
			int count = 0;
			for (int i = 0; i < size; i++) {
				if (array[i] == curr.data) {
					count++;
				}
			}
			switch(count) {
				case 0:
					System.out.println(curr.data + " has not been requested.");
					break;
				case 1:
					System.out.println(curr.data + " has been requested once.");
					break;
				case 2:
					System.out.println(curr.data + " has been requested twice.");
					break;
				default:
					System.out.println(curr.data + " has been requested " + count + " time(s).");
			}
			curr = curr.next;

		}

	}

	// DO NOT change this method
	// insert newNode to the head of the list
	public void insertHead(Node newNode) {
		newNode.next = head;
		newNode.prev = null;
		if (head == null)
			tail = newNode;
		else
			head.prev = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// insert newNode to the tail of the list
	public void insertTail(Node newNode) {
		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		else head = newNode;
		tail = newNode;
	}

	// DO NOT change this method
	// this will turn the list into a String from head to tail
	public String headToTail(){
		Node curr;
		String outString="";
		
		curr = head;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

	// DO NOT change this method
	// this will turn the list into a String from tail to head
	public String tailToHead(){
		Node curr;
		String outString="";
		
		curr = tail;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.prev;
		}
		return outString;
	}
}
