public class Fifo {
	int[] data; //just the numbers from the input.txt
	int[] frames;
	int[] pages;
	int faults, count, totalFrames;
	
	public void runFifo() {
		//grab first three of the file which are params for the algorithm
		int maxPageIndex = data[0];
		int totalFrames = data[1];
		int totalRequests = data[2];
		int num = 0;
		boolean flag = true;
		
		int[] pages = new int[totalRequests];
		int[] frames = new int[totalFrames];
		
		//copy page requests into separate array
		for(int i = 0; i < pages.length; i++) {
			pages[i] = data[i+3];
		}
		
		//initialize frame array to -1 since 0 is valid
		for(int i=0; i<totalFrames; i++) {
			frames[i] = -1;
		}
		
		for(int i=0; i<totalRequests;i++) {
			flag = true;
			int page = pages[i];
			for(int j=0; j<totalFrames; j++) {
				if(frames[j] == page) {
					System.out.println("Page " + page + " already loaded into Frame " + j);
					flag = false;
					break;
				}
			}
			//reset frame
			if(num == totalFrames)
				num = 0;
			
			if(flag) {
				frames[num] = page;
				System.out.println("Page " + page + " loaded into Frame " + num);
				faults++;
				num++;
			}
			
			System.out.print("frame : ");
			for(int k=0; k<totalFrames; k++)
				System.out.print(frames[k]+ " ");
			System.out.println();
		}
		System.out.println();
		System.out.println("faults = " + faults);
	}
	
	public void setData(int[] data) {
		this.data = data;
	}
}