package counsellingProcess;
/**
 * Circular Queue
 */
public class CircularQueue implements Queue {
    int front;
    int rear;
    Student[] queueArray;
    int MAX_SIZE;

    public CircularQueue(int max) {
        front = -1;
        rear = -1;
        MAX_SIZE = max;
        queueArray = new Student[MAX_SIZE];
    }

    /**
     * Dequeue element from Front.
     * @return deletedElement - element which is deleted
     */
    @Override
    public Student deQueue() {
    	Student data = queueArray[front];
    	front = (front+1)% queueArray.length;
		return data;
    }

    /**
     * Enqueue elements to rear.
     * @param newstudent to be added or enqueue
     */
    @Override
    public boolean enQueue(Student newStudent) {
    	int index;
		index = (rear+1)% queueArray.length;

        if(index == front) {
        	 System.out.println("Queue Overflow ");
        	 return false;
        }
       
        rear = index;
        queueArray[rear] = newStudent;
        if(front == -1)
        	front = 0;
        return true;
        }
}
