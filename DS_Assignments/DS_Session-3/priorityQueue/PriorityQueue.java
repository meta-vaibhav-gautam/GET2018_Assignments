package priorityQueue;

/*
 * interface containing methods for a priority queue
 * created on August 07, 2018
 */
public interface PriorityQueue<valueType> {
	public int addElement(Queue<valueType> element);
	public int deleteElement();
	public int getHighestPriority();
}
