package Asm2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class OperationToProduct extends printAndWrite {

	MyList myList = new MyList();
	MyStack myStack = new MyStack();
	MyQueue myQueue = new MyQueue();

	Scanner cs = new Scanner(System.in);

	// GET PRODUCT TO LINKED LIST
	public void createProduct() {
		System.out.print("Input Product's ID: ");
		String bcode = cs.next();
		System.out.print("Input Product's Name: ");
		cs.nextLine();
		String title = cs.nextLine();
		System.out.print("Input Product's quantity: ");
		int quantity = cs.nextInt();
		System.out.print("Input Product's price: ");
		double price = cs.nextDouble();
		// Add to last of linked list
		myList.insertToLast(new Product(bcode, title, quantity, price));
		println("\n" + title + " with id " + bcode + " has been added to list.");
	}

	// DISPLAY ALL PRODUCT
	public void displayAllProduct() {

		println("\n                   **** ALL PRODUCTS ****                       |");
		println("|---------------------------------------------------------------|");
		println(String.format("|%10s|%20s|%10s|%15s VND |", "ID", "NAME", "QTY", "PRICE"));
		println("|---------------------------------------------------------------|");
		myList.traverse();
		println("|_______________________________________________________________|");

	}

	// WRITE TO FILE
	public void writeBinaryFile() {
		try {
			FileOutputStream fos = new FileOutputStream("DataBinary.txt");
			ObjectOutputStream fileO = new ObjectOutputStream(fos);

			if (myList.isEmpty()) {
				println("List is empty!\nPlease add product to list before.");
			} else {
				Node x = myList.head;
				while (x != null) {
					fileO.writeObject(x.getData());
					x = x.getNextNode();
				}
				println("All product has been write to file.\n Choose [9] or [10] function to display.");
			}
			fos.close();
			fileO.close();
		} catch (Exception e) {
			System.out.println("Error during file writing.");
		}
	}

	public void writeUnicodeFile() {
		try {
			FileWriter fw = new FileWriter("DataUnicode.txt");

			if (myList.isEmpty()) {
				println("List is empty!\nPlease add product to list before.");
			} else {
				Node p = myList.head;
				while (p != null) {
					fw.write(p.getData().getBcode() + ";" + p.getData().getTitle() + ";" + p.getData().getQuantity()
							+ ";" + p.getData().getPrice() + "\n");

					p = p.getNextNode();
				}
			}
			fw.close();
		} catch (Exception e) {
			System.out.println("Error during file writing.");
		}
	}

	// READ FROM FILE
	public void readBinaryFile() {
		try {
			FileInputStream fis = new FileInputStream("DataBinary.txt");
			ObjectInputStream fileI = new ObjectInputStream(fis);

			Product p = null;
			if (fis.available() == 0) {
				println("File is empty!");
			}

			while (fis.available() != 0) {
				p = (Product) fileI.readObject();
				myList.insertToLast(p);
			}

			println("Data has been loaded and add to list.\nChoose [3] function to display.");

			fileI.close();
		} catch (Exception e) {
			System.out.println("Error during file reading.");
		}
	}

	public void readUnicodeFile() {
		try {
			FileReader fr = new FileReader("DataUnicode.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}

				String txt[] = line.split(";");
				String bCode = txt[0];
				String title = txt[1];
				int quantity = Integer.parseInt(txt[2]);
				Double price = Double.parseDouble(txt[3]);
				myList.insertToLast(new Product(bCode, title, quantity, price));
				
			}
			println("Data has been loaded and add to list.\nChoose [3] function to display.");
			br.close();

		} catch (Exception e) {
			System.out.println("Error during file reading.");
		}

	}

	// SEARCH PRODUCT BY ID
	public void searchById() {

		System.out.print("INPUT PRODUCT CODE FOR SEARCHING:");
		String Bcode = cs.next();
		println("\n                   **** SEARCHING RESULT ****                   |");
		println("|---------------------------------------------------------------|");
		println(String.format("|%10s|%20s|%10s|%15s VND |", "ID", "NAME", "QTY", "PRICE"));
		println("|---------------------------------------------------------------|");
		myList.search(Bcode);
		println("|_______________________________________________________________|");

	}

	// DELETE PRODUCT WITH ID
	public void deleteProductById() {
		System.out.print("INPUT PRODUCT CODE FOR DELETE:");
		String Bcode = cs.next();
		myList.deleteElement(Bcode);
	}

	// SORT PRODUCT LIST BY ID
	public void quickSortById() {

		myList.quickSort(myList.head, myList.tail);
		println("\n                   **** SORT BY ID ****                       |");
		println("|---------------------------------------------------------------|");
		println(String.format("|%10s|%20s|%10s|%15s VND |", "ID", "NAME", "QTY", "PRICE"));
		println("|---------------------------------------------------------------|");
		if (myList.isEmpty()) {
			println("| List is empty!");
		}
		myList.traverse();
		println("|_______________________________________________________________|");
	}

	// CONVERT PRODUCT QUANTITY TO BINARY
	public void convertToBinary() {
		int headQuantity = myList.head.getData().getQuantity();
		println("\nThe quantity of first product: " + headQuantity);
		println("Binary convert result: ");
		println(String.valueOf(myList.convert(headQuantity)));
	}

	// LOAD PRODUCT LIST FROM FILE TO STACK AND DISPLAY
	public void loadToStackAndDisplay() {
		try {
			FileInputStream fis = new FileInputStream("DataFile.txt");
			ObjectInputStream fileI = new ObjectInputStream(fis);

			Product p = null;

			// read file and push to stack
			while (fis.available() != 0) {
				p = (Product) fileI.readObject();
				myStack.push(p);
			}
			fileI.close();

			// display stack
			println("\n                   **** PRODUCT LIST ****                       |");
			println("|---------------------------------------------------------------|");
			println(String.format("|%10s|%20s|%10s|%15s VND |", "ID", "NAME", "QTY", "PRICE"));
			println("|---------------------------------------------------------------|");
			// Show notice if file is empty
			if (myStack.isEmpty()) {
				println("| File is empty!");
			}
			// display stack
			while (!myStack.isEmpty()) {
				myStack.pop().displayDetail();
			}
			println("|_______________________________________________________________|");

		} catch (Exception e) {
			println("Error during file reading.");
		}

	}

	// LOAD PRODUCT LIST FROM FILE TO QUEUE AND DISPLAY
	public void loadToQueueAndDisplay() {
		try {
			FileInputStream fis = new FileInputStream("DataFile.txt");
			ObjectInputStream fileI = new ObjectInputStream(fis);

			Product p = null;

			// read file and push to queue
			while (fis.available() != 0) {
				p = (Product) fileI.readObject();
				myQueue.enqueue(p);
			}

			fileI.close();

			// display queue
			println("\n                   **** PRODUCT LIST ****                       |");
			println("|---------------------------------------------------------------|");
			println(String.format("|%10s|%20s|%10s|%15s VND |", "ID", "NAME", "QTY", "PRICE"));
			println("|---------------------------------------------------------------|");
			// Show notice if file is empty
			if (myQueue.isEmpty()) {
				println("| File is empty!");
			}

			// display queue
			while (!myQueue.isEmpty()) {
				myQueue.dequeue().displayDetail();
			}
			println("|_______________________________________________________________|");

		} catch (Exception e) {
			println("Error during file reading.");
		}
	}

}
