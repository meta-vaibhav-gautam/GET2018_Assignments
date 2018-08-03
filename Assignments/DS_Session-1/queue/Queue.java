package queue;

/*
 * interface containing attributes of queue
 * created on August 1, 2018
 */
public interface Queue {
	
	public int addElementToQueue(int element);
	public int deleteElementFromQueue();
	public boolean isQueueFull();
	public boolean isQueueEmpty();
	public void displayQueueElements();

}
