package Asm2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		@SuppressWarnings("resource")
		Scanner cs = new Scanner(System.in);
		OperationToProduct op = new OperationToProduct();
		boolean cont = false;

		do {
			showMenu();
			int functionID = 0;
			try {
				functionID = cs.nextInt();
			} catch (Exception e) {
				System.out.println("\n<< INVALID ID >> INPUT FUNCTION ID (0-10)!");
			}
			switch (functionID) {

			// LOAD DATA FROM FILE AND DISPLAY
			case 1:
				//op.readFile();
				op.readUnicodeFile();
				break;

			// INPUT AND ADD TO THE END
			case 2:
				op.createProduct();
				break;
			// DISPLAY DATA
			case 3:
				op.displayAllProduct();
				break;

			// SAVE PRODUCT LIST TO FILE
			case 4:
				op.writeUnicodeFile();
				//op.writeFile();
				break;

			// SEARCH BY ID
			case 5:
				op.searchById();
				break;

			// DELETE BY ID
			case 6:
				op.deleteProductById();
				break;

			// SORT BY ID
			case 7:
				op.quickSortById();
				break;

			// CONVERT TO BINARY
			case 8:
				op.convertToBinary();
				break;

			// LOAD TO STACK AND DISPLAY
			case 9:
				op.loadToStackAndDisplay();
				break;

			// LOAD TO QUEUE AND DISPLAY
			case 10:
				op.loadToQueueAndDisplay();
				break;
				
			// LOAD DATA BINARY AND DISPLAY
			case 11:
					op.readBinaryFile();
					break;

			// SAVE PRODUCT LIST TO BIANRY FILE
			case 12:
					op.writeBinaryFile();
					break;

			// Exit
			case 0:
				System.out.println("GOOD BYE!");
				System.exit(0);
				break;

			default:
				System.out.println("\n<< INVALID ID >> INPUT FUNCTION ID (0-10)!");
				break;
			}

			System.out.println("\n\n[1] - SHOW FUNCTION MENU | [2] - EXIT");
			try {
				int temp = cs.nextInt();
				if (temp == 1)
					cont = true;
				else {
					System.out.println("GOOD BYE!");
					cont = false;
				}
			} catch (Exception e) {
				System.out.println("\n<< INVALID ID. TRY AGAIN!>>");
			}
		} while (cont);

	}

	// SHOW FUNCTION MENU METHOD
	public static void showMenu() {

		System.out.println("\n|------------------------------------------------|");
		System.out.println("|************** PRODUCT MANAGEMENT **************|");
		System.out.println("|------------------------------------------------|");
		System.out.println("|MENU   [1]  LOAD DATA (UNICODE) AND DISPLAY     |");
		System.out.println("|       [2]  INPUT AND ADD TO THE END            |");
		System.out.println("|       [3]  DISPLAY DATA                        |");
		System.out.println("|       [4]  SAVE PRODUCT LIST TO FILE (UNICODE) |");
		System.out.println("|       [5]  SEARCH BY ID                        |");
		System.out.println("|       [6]  DELETE BY ID                        |");
		System.out.println("|       [7]  SORT BY ID                          |");
		System.out.println("|       [8]  CONVERT TO BINARY                   |");
		System.out.println("|       [9]  LOAD TO STACK AND DISPLAY           |");
		System.out.println("|       [10] LOAD TO QUEUE AND DISPLAY           |");
		System.out.println("|       [11] LOAD DATA (BINARY) AND DISPLAY      |");
		System.out.println("|       [12] SAVE PRODUCT LIST TO FILE (BINARY)  |");
		System.out.println("|       [0]  EXIT                                |");
		System.out.println("|________________________________________________|");
		System.out.print("\n>> INPUT FUNCTION ID: ");
	}
}
