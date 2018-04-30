import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		//instantiate the classes
		Fifo fifo = new Fifo();
		Lru lru = new Lru();
		Opt opt = new Opt();
		//command line file read in
		String filename = args[0];
		int[] data = readFiles(filename);
		System.out.println(Arrays.toString(data));
		//choose what algo to run
		if(args[1].equals("FIFO")) {
			System.out.println("User started FIFO");
			System.out.println();
			//pass data to FIFO class
			fifo.setData(data);
			fifo.runFifo();
		}
		else if(args[1].equals("LRU")) {
			System.out.println("User started LRU");
			System.out.println();
			lru.setData(data);
			lru.runLru();
		}
		else if(args[1].equals("OPT")) {
			System.out.println("User started OPT");
			System.out.println();
			opt.setData(data);
			opt.runOpt();
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
