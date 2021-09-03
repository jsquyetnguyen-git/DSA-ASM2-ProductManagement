package Asm2;

public class Node {
	private Product data;
	private Node nextNode;

	public Node(Product data, Node nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}

	public Node(Product data) {
		this.data = data;
		this.nextNode = null;
	}

	public Product getData() {
		return data;
	}

	public void setData(Product data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

}
