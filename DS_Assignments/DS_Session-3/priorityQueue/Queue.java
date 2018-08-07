package priorityQueue;

/*
 * class containing attribute of a queue element
 * created on August 07, 2018
 */
public class Queue <valueType>{

	private valueType value;
	private int priority;
	
	public Queue(){
		
	}
	
	public Queue (valueType value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	//method to obtain value
	public valueType getValue() {
		return value;
	}

	//method to obtain priority
	public int getPriority() {
		return priority;
	}
	
	
	
}
