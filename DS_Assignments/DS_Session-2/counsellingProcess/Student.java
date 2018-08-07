package counsellingProcess;

import java.util.ArrayList;

/**
 * class containing attributes of the student
 * created on August 08, 2018
 */
public class Student {
    String name;
    ArrayList<String> interestedProgram = new ArrayList<>();

    /**
     * getInterestedProgram - Interested Program List
     * @return interestedProgram
     */
    public ArrayList<String> getInterestedProgram() {
        return interestedProgram;
    }

    /**
     * getName - Student Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setName - set Student Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setInterestedProgram - set Interested Program
     * @param program
     */
    public void setInterestedProgram(String program) {
        interestedProgram.add(program);
    }
}
