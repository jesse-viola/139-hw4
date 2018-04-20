import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//instantiate the classes
		Fifo fifo = new Fifo();
		
		//command line file read in
		String filename = args[0];
		int[] data = readFiles(filename);
		System.out.println(Arrays.toString(data));
	
		//add command line catch for arg[1] for specifying what algorithm to run
		if(args[1].equals("FIFO")) {
			System.out.println("User started FIFO");
			fifo.testsize();
		}
		else if(args[1].equals("LRU")) {
			System.out.println("User started LRU");
		}
		else if(args[1].equals("OPT")) {
			System.out.println("User started OPT");
		}
	}
	
	public static int[] readFiles(String file) {
		try {
			File f = new File(file);
			Scanner scanner = new Scanner(f);
			int counter = 0;
			//get count of how many ints are in file
			while(scanner.hasNextInt()) {
				counter++;
				scanner.nextInt();
			}
			//create array based off count
			int[] myArray = new int[counter];
			//reset cursor
			Scanner scanner1 = new Scanner(f);
			for(int i = 0; i < myArray.length; i++) {
				myArray[i] = scanner1.nextInt();
			}
			
			scanner.close();
			scanner1.close();
			
			return myArray;
			
		} catch(Exception e) {
			return null;
		}
	}
}
