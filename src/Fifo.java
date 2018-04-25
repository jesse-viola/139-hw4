import java.util.*;

public class Fifo {
	int[] data; //just the numbers from the input.txt
	
	public void runFifo() {
		//grab first three of the file which are params for the algorithm
		int maxPageIndex = data[0];
		int totalFrames = data[1];
		int totalRequests = data[2];
		int fifoPointer = 0;
		boolean alreadyLoaded = false;
		System.out.println("max page index is " + maxPageIndex);
		System.out.println("total frames is " + totalFrames);
		System.out.println("total requests is " + totalRequests);

		ArrayList<Integer> frames = new ArrayList<Integer>();
		
		//add items in until totalFrames is reached
		for(int i = 3; i < data.length; i++) {
			if(frames.size() != totalFrames) {
				//check to see if item is in list already
				int currentFrame = frames.get(fifoPointer);
				for(int j = 0; j < totalFrames; j++) {
					if(currentFrame == data[i]) {
						System.out.println("Page " + data[i] + "already in Frame " + fifoPointer);
					}
					else {
						frames.add(data[i]);
						System.out.println("Page " + data[i] + "loaded into Frame " + fifoPointer);
					}
				}
			}
			//else the frames are full and we need to FIFO
			else{
				System.out.println("Page " + frames.get(fifoPointer) + "unloaded from Frame " + fifoPointer + " Page " + data[i] + "loaded into Frame " + fifoPointer);
				frames.remove(fifoPointer);
				frames.add(fifoPointer, data[i]);
				fifoPointer++;
				fifoPointer = fifoPointer % totalFrames;
			}
		}
	}
	
	public void setData(int[] data) {
		this.data = data;
	}
}