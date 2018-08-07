package queue;

import java.util.LinkedList;
import java.util.List;

/*
 * class containing concrete definition of the methods related to queue
 * created on August 1,2018
 */
public class QueueUsingLinkedList implements Queue {

	private List<Integer> queueList = new LinkedList<Integer>();
	int frontIndex=0, endIndex=-1;
	
	/*
	 * method to add element in queue
	 */
	@Override
	public int addElementToQueue(int element) {
		endIndex++;
		queueList.add(endIndex, element);
		return 1;
	}

	/*
	 * method is used to delete element from queue
	 * return 1 if successfully removed
	 */
	@Override
	public int deleteElementFromQueue() {
		if(frontIndex > endIndex) {
			System.out.println("queue underflowed !");
			return 0;
		}
		queueList.remove(frontIndex);
		frontIndex--;
		
		return 1;
	}

	/*
	 * method to check if queue is full
	 */
	@Override
	public boolean isQueueFull() {
		return false;
	}

	/*
	 * method to check if queue is empty
	 */
	@Override
	public boolean isQueueEmpty() {
		
		return (frontIndex>endIndex);
	}

	
	@Override
	public void displayQueueElements() {
		for(int queueIndex=frontIndex ; queueIndex<=endIndex ; queueIndex++) {
				System.out.println(queueList.get(queueIndex)+" ");
			}
			
		}
}
