package Asm2;

public class MyStack {
	Node head;

	public MyStack() {
		head = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	//push a new node to stack
	public void push(Product x) {
		head = new Node(x, head);
	}

	// Access and remove the top element of stack
	public Product pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
		}

		Product x = head.getData();
		head = head.getNextNode();
		return x;
	}

}
