package counsellingProcess;

/**
 *class containing attributes of program
 */
public class Program {
    private String name;
    private int capacity;

    /**
     * method to get Capacity of program
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * method to get Name of program
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method to set capacity of program
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * method to set setName of program
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
