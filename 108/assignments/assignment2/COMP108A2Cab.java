import java.awt.HeadlessException;

//
// Note: You are allowed to add additional methods if you need.
// Coded by Prudence Wong 2021-03-06
//
// Name: Juana Patankar
// Student ID: 201471422
// MWS username: sgjpatan
//
// Time Complexity and explanation: 
// f denotes initial cabinet size
// n denotes the total number of requests 
// d denotes number of distinct requests
// You can use any of the above notations or define additional notation as you wish.
// 
// appendIfMiss():
// 	
// moveToFront():
// 	
// freqCount():
// 

class COMP108A2Cab {

	public COMP108A2Node head, tail;
	
	public COMP108A2Cab() {
		head = null;
		tail = null;
	}

	// append to end of list when miss
	public COMP108A2Output appendIfMiss(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);
		// Initialise the linked list cursor to point to the head
		COMP108A2Node curr = head;
		for (int i = 0; i < rSize; i++) {
			Boolean found = false;
			while (curr != null && !found) {
				if (curr.data == rArray[i]) {
					output.hitCount++;
					found = true;
				}
				curr = curr.next;
				output.compare[i]++;
			}
			curr = head;
			if (!found) {
				output.missCount++;
				COMP108A2Node newNode = new COMP108A2Node(rArray[i]);
				insertTail(newNode);
			}
		}
		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		return output;
	}

	// move the file requested to the beginning of the list
	public COMP108A2Output moveToFront(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);
		
		for (int i = 0; i < rSize; i++) {
			COMP108A2Node curr = head;
			Boolean found = false;
			while (curr != null && !found) {
				if (curr.data == rArray[i]) {
					if (curr.next != null) {
						if (head != curr) {
							curr.next.prev = curr.prev;
							curr.prev.next = curr.next;
							curr.next = null;
							curr.prev = null;
							this.insertHead(curr);
						}
						found = true;
					} else {
						tail = curr.prev;
						curr.prev.next = null;
						curr.prev = null;
						this.insertHead(curr);
						found = true;
					}
					
				}
				curr = curr.next;
				output.compare[i]++;
			}
			curr = head;
			if (found) {
				output.hitCount++;
			} else {
				output.missCount++;
				COMP108A2Node newNode = new COMP108A2Node(rArray[i]);
				this.insertHead(newNode);
			}
		}
		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		return output;	
	}
	public void insertNode(COMP108A2Node newNode) {
		COMP108A2Node curr = head;
		while (curr != null) {
			if (curr == head && curr.freq < newNode.freq) {
				this.insertHead(newNode);
			} else if (curr == tail && curr.freq > newNode.freq) {
				this.insertTail(newNode);
			} else if (curr.freq > newNode.freq && curr.next.freq != curr.freq && curr.next.freq < newNode.freq) {
				newNode.next = curr.next;
				newNode.prev = curr;
				curr.next.prev = newNode;
				curr.next = newNode;
			} else if (curr != head && curr != tail && curr.freq == curr.next.freq) {
				curr = curr.next;
				if (curr.freq > curr.next.freq) {
					newNode.next = curr.next;
					newNode.prev = curr;
					curr.next.prev = newNode;
					curr.next = newNode;
				} else {
					curr = curr.next;
				}
			
			}
			curr = curr.next;
		}
	}
	// move the file requested so that order is by non-increasing frequency
	public COMP108A2Output freqCount(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);
		for (int i = 0; i < rSize; i++) {
			COMP108A2Node curr = head;
			Boolean found = false;
			while (curr != null && !found) {
				if (curr.data == rArray[i]) {
					curr.freq++;
					COMP108A2Node newNode = curr;
					if (curr.next != null) {
						if (head != curr) {
							curr.next.prev = curr.prev;
							curr.prev.next = curr.next;
							curr.next = null;
							curr.prev = null;
							this.insertNode(newNode);
						}
						found = true;
					} else {
						tail = curr.prev;
						curr.prev.next = null;
						curr.prev = null;
						this.insertNode(newNode);
						found = true;
					}
				}
				curr = curr.next;
			}
			if (found) {
				output.hitCount++;
			} else {
				output.missCount++;
			}
		}
		

		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		output.cabFromHeadFreq = headToTailFreq();
		return output;		
	}

/* 	// Delete existing node
	while (curr != null) {
		if (curr.data == rArray[i] && head != curr) {
			if (curr.next != null) {
				if (head != curr) {
					curr.next.prev = curr.prev;
					curr.prev.next = curr.next;
					curr.next = null;
					curr.prev = null;
				} else {
					head = curr.next;
					curr.next.prev = head;
					curr.next = null;
					curr.prev = null;
				}
			} else {
				tail = curr.prev;
				curr.prev.next = null;
				curr.prev = null;
				
			}
			
		} else {
			curr = curr.next;
		}
		
	}
	// Insert into new position
	curr = head;
	while (curr != null) {
		if (curr.freq > newNode.freq && curr.next.freq < newNode.freq) {
			newNode.next = curr.next;
			newNode.prev = curr;
			curr.next.prev = newNode;
			curr.next = newNode;
		}
		curr = curr.next;
	} */
	// DO NOT change this method
	// insert newNode to head of list
	public void insertHead(COMP108A2Node newNode) {		

		newNode.next = head;
		newNode.prev = null;
		if (head == null)
			tail = newNode;
		else
			head.prev = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// insert newNode to tail of list
	public void insertTail(COMP108A2Node newNode) {

		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		else head = newNode;
		tail = newNode;
	}

	// DO NOT change this method
	// delete the node at the head of the linked list
	public COMP108A2Node deleteHead() {
		COMP108A2Node curr;

		curr = head;
		if (curr != null) {
			head = head.next;
			if (head == null)
				tail = null;
			else
				head.prev = null;
		}
		return curr;
	}
	
	// DO NOT change this method
	// empty the cabinet by repeatedly removing head from the list
	public void emptyCab() {
		while (head != null)
			deleteHead();
	}


	// DO NOT change this method
	// this will turn the list into a String from head to tail
	// Only to be used for output, do not use it to manipulate the list
	public String headToTail() {
		COMP108A2Node curr;
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
	// Only to be used for output, do not use it to manipulate the list
	public String tailToHead() {
		COMP108A2Node curr;
		String outString="";
		
		curr = tail;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.prev;
		}
		return outString;
	}

	// DO NOT change this method
	// this will turn the frequency of the list nodes into a String from head to tail
	// Only to be used for output, do not use it to manipulate the list
	public String headToTailFreq() {
		COMP108A2Node curr;
		String outString="";
		
		curr = head;
		while (curr != null) {
			outString += curr.freq;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

}
