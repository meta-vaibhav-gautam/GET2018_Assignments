package priorityQueue;

/*
 * class containing implementation of priority queue
 * created on August 07, 2018
 */
public class PriorityQueueImplementation<valueType> implements PriorityQueue<valueType>{

	private int MAX_SIZE = 0;
	private Queue<valueType> priorityQueueArray[] = null;
	private int rearIndex=-1,frontIndex=-1;
	public PriorityQueueImplementation(int maxSize) {
		MAX_SIZE = maxSize;
		priorityQueueArray = new Queue[maxSize];
	}
	
	/*
	 * method to add element in a priority queue
	 * @param Queue object to be stored in array
	 * @return 1 if element added otherwise return 0
	 */
	@Override
	public int addElement(Queue<valueType> element) {
		if(rearIndex == (MAX_SIZE-1)) {
			System.out.println("Queue Overflowed !");
			return 0;
		}
		
		priorityQueueArray[++rearIndex] = element;
		if(frontIndex==-1) frontIndex++;
		
		displayPriorityQueue();
		return 1;
	}

	/*
	 * method removes the highest priority element from queue
	 * @return 1 if element is removed successfully otherwise return 0
	 */
	@Override
	public int deleteElement() {
		if(frontIndex<0) {
			System.out.println("Queue underflowed !");
			return 0;
		}
		
		int maxPriority = getHighestPriority();
		for (int i=frontIndex ; i<=rearIndex ; i++) {
			if(priorityQueueArray[i].getPriority() == maxPriority) {
				for(int j=i; j<rearIndex ; j++) {
					priorityQueueArray[j]=priorityQueueArray[j+1];
				}
				rearIndex--;
			}
		}
		displayPriorityQueue();
		return 1;
	}

	/*
	 * method to get highest priority in the queue
	 * @return maxPriority as integer as maximum priority in the list
	 */
	@Override
	public int getHighestPriority() {
		int maxPriority=0;
		for(int i=frontIndex ; i<=rearIndex ; i++) {
			if(priorityQueueArray[i].getPriority() > maxPriority) {
				maxPriority = priorityQueueArray[i].getPriority();
			}
		}
		return maxPriority;
	}
	
	/*
	 * method to display priority queue
	 */
	private void displayPriorityQueue() {
		System.out.println("Elements in queue: ");
		for(int i= frontIndex; i<=rearIndex ; i++) {
			System.out.print("["+priorityQueueArray[i].getValue()+" , "+priorityQueueArray[i].getPriority()+"] ");
		}
	}
}
