import static org.junit.Assert.*;

import org.junit.Test;


public class LargestMirrorSectionTest {

	@Test
	public void testPass() {
		int elementsArray[]={1,2,3,8,9,3,2,1};
		LargestMirrorSection obj=new LargestMirrorSection();
		int result=obj.findLargestMirrorSection(elementsArray);
		
		assertEquals(3,result);
	}
	
	@Test
	public void testFail() {
		int elementsArray[]={1,2,3,8,9,3,2,1};
		LargestMirrorSection obj=new LargestMirrorSection();
		int result=obj.findLargestMirrorSection(elementsArray);
		
		assertEquals(4,result);
	}

}
