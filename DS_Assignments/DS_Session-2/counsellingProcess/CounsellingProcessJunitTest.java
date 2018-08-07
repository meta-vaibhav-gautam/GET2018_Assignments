package counsellingProcess;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;


public class CounsellingProcessJunitTest {
	private CounsellingProcess object;

	@Before
	public void initialize(){
		object = new CounsellingProcess();
	}
	
	@Test
	public void testCounsellingProgram() throws IOException, EncryptedDocumentException, InvalidFormatException {
		object.addProgram("Programs.xlsx");
		object.addStudent("Student.xlsx");
		object.allotPrograms();
	}

	@Test
	public void programFileNotExistTest() {
		try {
			object.addProgram("C:\\Users\\User24\\workspace\\DS_Session-2_CounsellingProcess\\Programs.xlsx");
		} catch (IOException ex) {
			assertEquals("File Not Found while adding Programs", ex.getMessage());
		}
	}

	@Test
	public void studentFileNotExistTest() throws EncryptedDocumentException, InvalidFormatException {
		try {
			object.addStudent("C:\\Users\\User24\\workspace\\DS_Session-2_CounsellingProcess\\Student.xlsx");
		} catch (IOException ex) {
			assertEquals("File Not Found while adding Students",
					ex.getMessage());
		}
	}
}