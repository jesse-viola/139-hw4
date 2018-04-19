import java.io.*;

public class Main {
	public static void main(String[] args) {
		//instantiate the classes
		Fifo fifo = new Fifo();
		
		//command line file read in
		if(0 < args.length) {
			int count = 0;
			String filename = args[0];
			File file = new File(filename);
			try {
				FileInputStream fis = new FileInputStream(file);
				char current;
				while(fis.available() > 0) {
					current = (char) fis.read();
					System.out.println(current);
					count++;
				}
				//set the size of the data inputted needed for the datastructure
				fifo.setSize(count);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
	
}
