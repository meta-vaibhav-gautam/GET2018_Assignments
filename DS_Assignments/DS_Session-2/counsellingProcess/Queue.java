package counsellingProcess;

/**
 * Queue interface provide two operation
 *
 */
public interface Queue {

    public Student deQueue();
    public boolean enQueue(Student newStudent);
}
