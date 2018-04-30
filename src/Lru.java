import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lru {
	int[] data; //just the numbers from the input.txt
	int[] frames;
	int[] pages;
	int faults, count, totalFrames;
	
	int[] test = {1,2,2,4,0};
	
	public void testinglru() {
		int indextest = index_of_minimum_value(test);
		System.out.println("This is testing smallest int index it is " + indextest);
	}

	public void runLru() throws Exception {
		int maxPageIndex = data[0];
		int totalFrames = data[1];
		int totalRequests = data[2];
		boolean duplicate = false;
		int duplicateIndex = 0;
		int count = 0;
		int frameIndex = 0;
		int faults = 0;
		
		int[] pages = new int[totalRequests];
		int[] frames = new int[totalFrames];
		int[] recent = new int[totalFrames];
		
		//copy page requests into separate array
		for(int i=0; i<pages.length; i++) {
			pages[i] = data[i+3];
		}
		
		//initialize the recent and frames to -1, as 0 is valid input
		for(int i=0; i<totalFrames; i++) {
			frames[i] = -1;
			recent[i] = -1;
		}
		
		for(int i=0; i<totalRequests; i++)
		{
			//get current page
			int page = pages[i];
			for(int j=0;j<totalFrames; j++)
			{
				//check to see if page already exists
				if(frames[j] == page)
				{
					count++;
					duplicate = true;
					duplicateIndex = j;
					System.out.println("Page " + page + " already loaded into Frame " + j);
					break;
				}
			}
			
			//if we find a duplicate we need to update the recent array
			if(duplicate == true)
			{
				recent[duplicateIndex] = count;
			}
			
			//if it doesn't exist we need to add to frames
			if(duplicate == false)
			{
				if(frameIndex < totalFrames)
				{
					//find smallest value in recent array, this array holds indexes of pages
					count++;
					recent[frameIndex] = count;
					frames[frameIndex] = page;
					System.out.println("Page " + page + " is being loaded into Frame " + frameIndex);
					frameIndex++;
					faults++;
				}
				
				else if(frameIndex >= totalFrames)
				{
					//find the smallest value in the recent array, find that index and then replace the frames array with that grabbed index with the new page
					count++;
					int index_to_replace = index_of_minimum_value(recent);
					recent[index_to_replace] = count;
					System.out.println("Page " + frames[index_to_replace] + " is being unloaded from Frame " + index_to_replace +  " Page " + page + " is being loaded in Frame " + index_to_replace);
					frames[index_to_replace] = page;
					faults++;
				}
			}
			duplicate = false;
		}
		System.out.println();
		System.out.println("faults = " + faults);
	}

	
	private static int index_of_minimum_value(int[] array) {
	    int index = 0;
	    for (int i = 1; i < array.length; i++) {
	        if ((array[i - 1] < array[i]) && (array[index] > array[i - 1]))
	        	index = i - 1;
	        else if (array[index] > array[i])
	        	index = i;
	    }
	    return index;
	}
	
	public void setData(int[] data) {
		this.data = data;
	}
}
