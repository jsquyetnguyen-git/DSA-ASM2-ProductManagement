package Asm2;

public class MyList extends printAndWrite {
	Node head, tail;

	public MyList() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	// Size of LinkedList
	public int length() {
		Node x = head;
		int size = 0;
		while (x != null) {
			size++;
			x = x.getNextNode();
		}
		return size;
	}

	// Delete element at tail of Linked List
	public void insertToLast(Product x) {
		Node newNode = new Node(x);
		if (isEmpty()) {
			head = tail = newNode;
			return;
		}
		tail.setNextNode(newNode);
		tail = newNode;
	}

	// display data of node
	public void displayData(Node x) {
		x.getData().displayDetail();
		;
	}

	// traverse all node of list
	public void traverse() {
		Node x = head;
		while (x != null) {
			displayData(x);
			x = x.getNextNode();
		}
	}

	public void search(String id) {
		boolean notExist = true;

		if (isEmpty()) {
			println("| List is empty!");
		} else {
			Node currentNode = head;
			while (currentNode != null) {
				if (currentNode.getData().getBcode().equals(id)) {
					displayData(currentNode);
					// If found product, notExist variable will be setted notExist to false.
					// If not found, notExist variable will be true.
					notExist = false;
				}
				currentNode = currentNode.getNextNode();
			}
			// If not found, push notice.
			if (notExist) {
				println("| Product with id [ " + id + " ] is not exist.             |");
			}
		}
	}

	// Delete element has id
	public void deleteElement(String id) {
		boolean exist = false;
		Node preNode = null;
		Node currentNode = head;

		// Search the Node need to delete and the previous node
		if (isEmpty()) {
			println("List is empty.");
			return;
		} else {
			while (currentNode != null) {
				if (currentNode.getData().getBcode().equals(id)) {
					exist = true;
					break;
				}
				preNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
		}

		if (exist == false) {
			println("| Product with code [ " + id + " ] is not exist.               |");
		} else {
			if (currentNode == head) {
				head = head.getNextNode();
			} else if (currentNode == tail) {
				preNode.setNextNode(null);
				tail = preNode;
			} else {
				preNode.setNextNode(currentNode.getNextNode());
			}
			// Show product has been deleted.
			println("The product " + currentNode.getData().getTitle() + " with id " + id
					+ " has been deleted successfully.");
		}

	}

	// Swap two node
	public void swapNode(Node i, Node j) {
		Product temp;
		temp = i.getData();
		i.setData(j.getData());
		j.setData(temp);
	}

	// Partition method to find previous node of pivot
	public Node partition(Node start, Node end) {
		// the base condition
		if (start == end || start == null || end == null) {
			return start;
		}
		// Choose pivot is last of linked list
		Product pivot = end.getData();
		Node current = start;
		Node previousOfPivot = start;

		// The loop will be iterated to the previous node of end node
		// since the end node is pivot
		while (start != end) {
			int x = start.getData().getBcode().compareTo(pivot.getBcode());
			// x < 0 if bcode of start < bcode of pivot
			if (x < 0) {
				previousOfPivot = current;

				// swap current and start
				swapNode(current, start);

				current = current.getNextNode();
			}
			start = start.getNextNode();
		}

		// Swap pivot (end) and current
		swapNode(current, end);

		return previousOfPivot;
	}

	// Quick sort method
	public void quickSort(Node start, Node end) {
		// the base condition
		if (start == null || start == end || start == end.getNextNode()) {
			return;
		}
		// Partition recurse
		Node previousOfPivot = partition(start, end);
		quickSort(start, previousOfPivot);

		//If Pivot is the smallest value in the list, previousOfPivot is start (initialization value).
		if (previousOfPivot != null && previousOfPivot == start) {
			quickSort(previousOfPivot.getNextNode(), end);
		//If Pivot is not smallest value of list
		} else if (previousOfPivot != null && previousOfPivot.getNextNode() != null) {
			quickSort(previousOfPivot.getNextNode().getNextNode(), end);
		}
	}

	// Convert quantity of head node to binary
	public long convert(long decimal) {
		long surplus;
		if (decimal == 0) {
			return 0;
		} else {
			surplus = decimal % 2;
			return surplus + 10 * convert(decimal / 2);
		}
	}
}
