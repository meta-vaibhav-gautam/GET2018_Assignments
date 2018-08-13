package counsellingProcess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *class containing counselling and excel related methods
 *created on August 07, 2018
 */
public class CounsellingProcess {
    ArrayList <Program> programList = new ArrayList < Program > ();
    CircularQueue queueOfStudents = new CircularQueue(100);
    int noOfStudents = 0;

    /**
     * method to add excel file data in ProgramList
     * @param fileName
     * @throws IOException
     */
    public void addProgram(String fileName) throws IOException {
        try {
            InputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.println("Add Program");
            Iterator <Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator <Cell> cellIterator = nextRow.cellIterator();
                Program program = new Program();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            program.setName((String) nextCell.getStringCellValue());
                            break;

                        case 1:
                            program.setCapacity((int) nextCell.getNumericCellValue());
                            break;
                    }
                }
                programList.add(program);
            }
            workbook.close();
            file.close();
        } catch (IOException ex) {
            throw new IOException("File Not Found while adding Programs");
        }
    }

    /**
     * method add student excel data into the queue
     * @param fileName - file of student 
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    public void addStudent(String fileName) throws IOException, EncryptedDocumentException, InvalidFormatException {
        try {
            InputStream file = new FileInputStream(new File(fileName));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.println("Add Student");
            Iterator <Row> iterator = sheet.iterator();


            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator <Cell> cellIterator = nextRow.cellIterator();
                Student student = new Student();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            student.setName((String) nextCell.getStringCellValue());
                            break;

                        default:
                            student.setInterestedProgram((String) nextCell.getStringCellValue());
                            break;
                    }
                }
                queueOfStudents.enQueue(student);
                noOfStudents++;
            }
            workbook.close();
            file.close();
        } catch (IOException ex) {
            throw new IOException("File Not Found while adding Students");
        }
    }


    /**
     * method to allot the program to the student
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void allotPrograms() throws FileNotFoundException, IOException {
        ArrayList <AllocatedPrograms> selectedProgramList = new ArrayList < > ();

        for (int i = 0; i < noOfStudents; i++) {
            Student student = queueOfStudents.deQueue();

            for (int j = 0, k = 0; j < 5;) {
                if (k == programList.size()) {
                    j++ ;	 //student next preference
                    k = 0;
                    
                } else if (student.getInterestedProgram().get(j).equals(programList.get(k).getName()) &&  programList.get(k).getCapacity() > 0) { //to check whether student selected program is available or not
                    
                	selectedProgramList.add(new AllocatedPrograms(student.getName(), programList.get(k).getName())); // add student into the selectedProgramList
                    programList.get(k).setCapacity(programList.get(k).getCapacity() - 1); //change capacity of program list
                   
                    break;
                    
                } else {
                    k++; // next program from program list
                }
            }
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("List of Students");
        int rowCount = 0;

        for (AllocatedPrograms sp: selectedProgramList) {
            Row row = sheet.createRow(rowCount);
            writeBook(sp, row);
            rowCount++;
        }

        try (FileOutputStream outputStream = new FileOutputStream(new File("Allocatede.xlsx"))) {
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();
        }
    }

    /**
     * write data into spreadsheet file
     * @param allocatedPrograms
     * @param row
     */
    private void writeBook(AllocatedPrograms allocatedPrograms, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(allocatedPrograms.getStudentName());

        cell = row.createCell(2);
        cell.setCellValue(allocatedPrograms.getSelectedProgram());
    }

    public static void main(String[] arg) throws IOException, EncryptedDocumentException, InvalidFormatException {
        final String programFile = "Programs.xlsx";
        final String studentFile = "Student.xlsx";

        CounsellingProcess cp = new CounsellingProcess();
        cp.addProgram(programFile);
        cp.addStudent(studentFile);
        cp.allotPrograms();
    }
}