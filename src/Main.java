import java.io.*;

public class Main {

	public static void main(String[] args) {
		//command line file readin
		if(0 < args.length) {
			String filename = args[0];
			File file = new File(filename);
			try {
				FileInputStream fis = new FileInputStream(file);
				char current;
				while(fis.available() > 0) {
					current = (char) fis.read();
					System.out.println(current);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
