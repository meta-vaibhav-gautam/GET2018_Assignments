package circularQueue;

/*
 * class containing concrete declaration of the queue using array
 * created on August 1, 2018
 */
public class CircularQueue {

	private int queueMaxSize;
	private int frontIndex = -1;
	private int endIndex = -1;
	private int queueArray[];
	
	public CircularQueue (int queueMaxSize) {
		this.queueMaxSize=queueMaxSize;
		queueArray = new int[queueMaxSize];
	}
	
	/*
	 * method to add elements to queue
	 * return 1 if successfully added otherwise return 0
	 */
	public int addElementToQueue(int element) {
		int index;
		index = (endIndex+1)% queueArray.length;

        if(index == frontIndex) {
        	 System.out.println("Queue Overflow ");
        	 return 0;
        }
       
        endIndex = index;
        queueArray[endIndex] = element;
        if(frontIndex == -1)
            frontIndex = 0;
      
        return 1;
	}

	/*
	 * method removes the element from front of the queue
	 * returns 1 if successfully removed otherwise return 0
	 */
	public int deleteElementFromQueue() {
		frontIndex = (frontIndex+1)% queueArray.length;
		return 1;
	}


	public void displayQueueElements() {
		if(frontIndex == -1)
	           System.out.println("Queue underflow");
	        else
	        {
	            System.out.println("\nElements of Queue are:");
	            int i = frontIndex;

	            while(i != endIndex)
	            {
	                System.out.print(queueArray[i]+" ");
	                i = (i+1)% queueArray.length;
	            }

	            System.out.print(queueArray[i]+" ");

	        }
		
	}

}
