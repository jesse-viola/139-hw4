import java.util.Arrays;

public class Opt {
	int[] data; //just the numbers from the input.txt
	int[] frames;
	int[] pages;
	int faults, count, totalFrames;
	
	public void runOpt()
	{
		//grab first three of the file which are params for the algorithm
		int maxPageIndex = data[0];
		int totalFrames = data[1];
		int totalRequests = data[2];
		int num = 100;
		int frameIndex = 0;
		int optimalTracker = 0;
		boolean duplicate = false;
		
		int[] pages = new int[totalRequests];
		int[] frames = new int[totalFrames];
		int[] buffer = new int[totalFrames];
		
		//copy page requests into separate array
		for(int i = 0; i < pages.length; i++) {
			pages[i] = data[i+3];
		}
		
		//initialize frame array to -1 since 0 is valid
		for(int i=0; i<totalFrames; i++) {
			frames[i] = -1;
			buffer[i] = -1;
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
					System.out.println("Page " + page + " already loaded into Frame " + j);
					break;
				}
			}
			
			if(duplicate == false)
			{
				if(frameIndex < totalFrames)
				{
					frames[frameIndex] = page;
					//keep track of indexes in buffer array
					buffer[frameIndex] = i;
					System.out.println("Page " + page + " is being loaded into Frame " + frameIndex);
					frameIndex++;
					faults++;
				}
				else if(frameIndex >= totalFrames)
				{
					//we need to go through the buffer array and see which one will not be used.
					for(int j=0; j<totalFrames; j++)
					{
						//make another index 
						int temp = -1;
						boolean exists = false;
				
						for(int k = i; k<totalRequests; k++)
						{
							//search through entire request array
								if(buffer[j] == pages[k])
								{
									temp = k;
									//find if the number exists in the request array still and record the greatest number
									buffer[j] = temp;
								}
						}
					}
					
					//now we need to add to frames and update our buffer array, to figure out which index we need to remove we look through buffer array and
					//find the index of the biggest number in there. or -2
					int index_to_replace = getIndexOfLargest(buffer);
					System.out.println("Page " + frames[index_to_replace] + " is being unloaded from Frame " + index_to_replace +  " Page " + page + " is being loaded in Frame " + index_to_replace);
					frames[index_to_replace] = page;
					buffer[index_to_replace] = i;
					faults++;
				}
			}
			duplicate = false;
		}
		
	}
	
	public int[] removeIndex( int [] arr, int remIndex )
	{
	   for ( int i = remIndex ; i < arr.length - 1 ; i++ )
	   {
	      arr[ i ] = arr[ i + 1 ] ; 
	   }
	   return arr;
	}
	
	public int getIndexOfLargest( int[] array )
	{
	  if ( array == null || array.length == 0 ) return -1; // null or empty

	  int largest = 0;
	  for ( int i = 1; i < array.length; i++ )
	  {
	      if ( array[i] > array[largest] ) largest = i;
	  }
	  return largest; // position of the first largest found
	}
	
	public void setData(int[] data) {
		this.data = data;
	}
}
