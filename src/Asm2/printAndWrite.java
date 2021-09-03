package Asm2;

import java.io.FileWriter;
import java.io.PrintWriter;

public class printAndWrite {
	public void println(String s) {
		try {
			// Print to console display
			System.out.println(s);

			// Write to file
			// Set boolean append is true to append the string write to file
			FileWriter fileWriter = new FileWriter("console_output.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.println("");

			printWriter.print(s);
			printWriter.close();
			


		} catch (Exception e) {
			System.out.println("FILE ERROR.");
		}
	}
}
