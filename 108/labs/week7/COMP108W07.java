//
// by Prudence Wong 2021-03-20
//
// Name: Juana Patankar
// Student ID: 201471422
//

class COMP108W07 {

	public Node head, tail;
	
	public COMP108W07() {
		head = null;
		tail = null;
	}

	// sequential search if key is in the list
	// move the node to head if found, do nothing if not found
	public void searchMoveToHead(int key) {
		Node curr = head;
		Boolean found = false;
		while (curr != null && found == false) {
			if (curr.data == key) {
				 if (curr.next != null) {
					if (head != curr) {
						curr.next.prev = curr.prev;
						curr.prev.next = curr.next;
						curr.prev = null;
						curr.next = null;
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
		}
		if (!found) {
			System.out.println("Did not find " + key + " in the list.");
		}
	}


	// sequential search if key is in the list
	// move the node to tail if found, do nothing if not found
	public void searchMoveToTail(int key) {
		Node curr = head;
		Boolean found = false;
		while (curr != null && found == false) {
			if (curr.data == key) {
				if (curr.prev != null) {
					if (tail != curr) {
						curr.next.prev = curr.prev;
						curr.prev.next = curr.next;
						curr.prev = null;
						curr.next = null;
						this.insertTail(curr);
					}
					found = true;
				} else {
					head = curr.next;
					curr.prev = null;
					curr.next.prev = null;
					this.insertTail(curr);
					found = true;
				}
			}
			curr = curr.next;
		}
		if (!found) {
			System.out.println("Did not find " + key + " in the list.");
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
