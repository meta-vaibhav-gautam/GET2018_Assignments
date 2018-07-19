import java.util.List;

public class Grade {

    /*
     * finds average of the grades
     * @param list of grades
     * @return average of grades obtained
     */
    public double findAverage(List < Integer > grades) {
        double total = 0;
        for (Integer marks: grades) {
            total += marks;
        }
        return total / grades.size();
    }


    /*
     * finds maximum grade from the grades
     * @param list of grades
     * @return maximum of grades obtained
     */
    public int getMaxMarks(List < Integer > grades) {
        int max = 0;
        for (Integer marks: grades) {
            if (max < marks) {
                max = marks;
            }
        }
        return max;
    }


    /*
     * finds minimum grade from the grades
     * @param list of grades
     * @return minimum of grades obtained
     */
    public int getMinMarks(List < Integer > grades) {
        int min = 0;
        for (Integer marks: grades) {
            if (min > marks) {
                min = marks;
            }
        }
        return min;
    }


    /*
     * finds percentage of the passed students
     * passed students are whose marks >=40
     * @param list of grades
     * @return percentage of the passed student
     */
    public double passedStudentPercent(List < Integer > grades) {
        int count = 0;
        for (Integer marks: grades) {
            if (marks >= 40) {
                count++;

            }
        }
        double temp = (double) count / grades.size();
        return temp * 100;
    }
}