public class Fifo {
	int[] data; //just the numbers from the input.txt
	
	public void runFifo() {
		//grab first three of the file which are params for the algorithm
		int maxPageIndex = data[0];
		int totalFrames = data[1];
		int totalRequests = data[2];
		System.out.println("max page index is " + maxPageIndex);
		System.out.println("total frames is " + totalFrames);
		System.out.println("total requests is " + totalRequests);
	}
	public void setData(int[] data) {
		this.data = data;
	}
}
