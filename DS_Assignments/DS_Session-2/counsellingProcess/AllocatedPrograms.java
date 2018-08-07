package counsellingProcess;
/**
 * AllocatedPrograms - Allocate Program to student
 */
public class AllocatedPrograms {
    String studentName;
    String selectedProgram;

    public AllocatedPrograms(String studentName, String selectedProgram) {
        this.studentName = studentName;
        this.selectedProgram = selectedProgram;
    }

    /**
     * getSelectedProgram
     * @return selected program
     */
    public String getSelectedProgram() {
        return selectedProgram;
    }

    /**
     * getStudentName
     * @return student name
     */
    public String getStudentName() {
        return studentName;
    }   
}