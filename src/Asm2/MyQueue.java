package Asm2;

public class MyQueue extends printAndWrite {
	Node head, tail;

	public MyQueue() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	// add new node to queue
	public void enqueue(Product x) {
		if (isEmpty()) {
			head = tail = new Node(x);
		} else {
			tail.setNextNode(new Node(x));
			tail = tail.getNextNode();
		}
	}

	// Access and remove the first element of queue
	public Product dequeue() {
		if (isEmpty()) {
			println("Queue is empty.");
		}

		Product x = head.getData();
		head = head.getNextNode();
		return x;
	}

}
