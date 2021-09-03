package Asm2;

import java.io.Serializable;

public class Product extends printAndWrite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bcode;
	String title;
	int quantity;
	double price;

	public Product(String bcode, String title, int quantity, double price) {
		this.bcode = bcode;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void displayDetail() {
		println(String.format("|%10s|%20s|%10d|%15s VND |", getBcode(), getTitle(), getQuantity(), getPrice()));

	}

}
