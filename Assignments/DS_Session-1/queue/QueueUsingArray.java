package queue;

/*
 * class containing concrete declaration of the queue using array
 * created on August 1, 2018
 */
public class QueueUsingArray implements Queue{

	private int queueMaxSize;
	private int frontIndex = 0;
	private int endIndex = -1;
	private int queueArray[];
	
	public QueueUsingArray (int queueMaxSize) {
		this.queueMaxSize=queueMaxSize;
		queueArray = new int[queueMaxSize];
	}
	
	/*
	 * method to add elements to queue
	 * return 1 if successfully added otherwise return 0
	 */
	@Override
	public int addElementToQueue(int element) {
		if(endIndex == (queueMaxSize-1)) {
			System.out.println("Queue overflowed !");
			return 0;
		}
		queueArray[++endIndex]=element;
		return 1;
	}

	/*
	 * method removes the element from front of the queue
	 * returns 1 if successfully removed otherwise return 0
	 */
	@Override
	public int deleteElementFromQueue() {
		if(endIndex < frontIndex) {
			System.out.println("Queue underflowed !");
			return 0;
		}
		queueArray[frontIndex]=0;
		frontIndex++;
		return 1;
	}

	/*
	 * method tells whether the list is full or not
	 */
	@Override
	public boolean isQueueFull() {
		return (endIndex==(queueMaxSize-1));
	}

	/*
	 * method tells whether the list is empty or not
	 */
	@Override
	public boolean isQueueEmpty() {
		return (frontIndex > endIndex);
	}

	@Override
	public void displayQueueElements() {
		for(int queueIndex=frontIndex ; queueIndex<=endIndex ; queueIndex++) {
			System.out.print(queueArray[queueIndex]+" ");
		}
		
	}

}
